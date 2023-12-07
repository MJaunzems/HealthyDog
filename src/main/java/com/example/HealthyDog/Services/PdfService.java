package com.example.HealthyDog.Services;

import com.example.HealthyDog.FoodDTO;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.stereotype.Service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@Service
public class PdfService {

    public void generatePdf(List<FoodDTO> foodResults) throws IOException, DocumentException {
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream("foodReport.pdf"));
        document.open();
        document.add(new Paragraph("Report food calculation! " + new Date()));
        document.add(new Paragraph(" "));

        PdfPTable table = new PdfPTable(5);

        table.addCell("Company");
        table.addCell("Grams");
        table.addCell("Weight");
        table.addCell("Image");
        table.addCell("Price");

        for (FoodDTO food : foodResults) {
            table.addCell(food.getCompanyName());
            table.addCell(String.valueOf(food.getGrams()));
            table.addCell(String.valueOf(food.getWeight()));
            table.addCell(food.getPhoto());
            table.addCell(String.valueOf(food.getPrice()));
        }
        document.add(table);
        document.close();
    }
}
