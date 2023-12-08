package com.example.HealthyDog.Controllers;

import com.example.HealthyDog.Entities.AllergicFoodsEntity;
import com.example.HealthyDog.Entities.FoodEntity;
import com.example.HealthyDog.FoodDTO;
import com.example.HealthyDog.Repositories.AllergicFoodsRepository;
import com.example.HealthyDog.Services.CalculatorService;
import com.example.HealthyDog.Services.CannedFoodService;
import com.example.HealthyDog.Services.DryFoodService;
import com.example.HealthyDog.Services.PdfService;
import jakarta.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CalculatorController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CalculatorController.class);

    @Autowired
    private CalculatorService calculatorService;
    @Autowired
    private AllergicFoodsRepository allergicFoodsRepository;
    @Autowired
    private CannedFoodService cannedFoodService;
    @Autowired
    private DryFoodService dryFoodService;

    @Autowired
    private PdfService pdfService;

    private final List<FoodDTO> MENU = new ArrayList<>();

    @GetMapping("/calculate")
    public String calculate(Model model, HttpSession session) {
        if (session.getAttribute("weight") == null || session.getAttribute("activity") == null) {
            session.setAttribute("weight", 10.0);
            session.setAttribute("activity", "medium_active");
            session.setAttribute("age", "Adult");
        }
        double rer = calculatorService.calculateRER((Double) session.getAttribute("weight"));
        double k = calculatorService.validateAndSetK((String) session.getAttribute("activity"));
        double dailyCalories = calculatorService.calculateDailyCalories(rer, k);
        List<FoodEntity> allFoods = dryFoodService.getAllFoods();
        List<FoodEntity> filteredFoods = calculatorService.filterFoods(allFoods, session);
        List<FoodDTO> foodResults = new ArrayList<>();
        for (FoodEntity food : filteredFoods) {
            double foodCalorieContent = food.getCalorie();
            double foodGrams = calculatorService.calculateFoodGrams(dailyCalories, foodCalorieContent);
            foodResults.add(new FoodDTO(food.getCompany(), Math.round(foodGrams), food.getWeight(), food.getImageName(), food.getPrice()));
        }

        MENU.addAll(foodResults);

        Iterable<AllergicFoodsEntity> options = allergicFoodsRepository.findAll();

        model.addAttribute("options", options);
        model.addAttribute("foodResults", foodResults);
        model.addAttribute("selectedAnimal", session.getAttribute("type"));
        return "dryfoods";
    }

    @GetMapping("/generate-pdf")
    public ModelAndView generatePdfReport(Model model, RedirectAttributes redirectAttributes) {

        if (!MENU.isEmpty()) {
            try {
                pdfService.generatePdf(MENU);
                redirectAttributes.addFlashAttribute("message", "PDF report generated successfully!");
            } catch (Exception e) {
                redirectAttributes.addFlashAttribute("errorPrint", "Error generating PDF report: " + e.getMessage());
            }
            return new ModelAndView("redirect:/dryfoods");
        } else {
            redirectAttributes.addFlashAttribute("errorPrint", "You must complete the form.");
            return new ModelAndView("redirect:/dryfoods");
        }
    }

}

