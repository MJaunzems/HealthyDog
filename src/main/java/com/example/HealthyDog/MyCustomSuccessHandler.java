package com.example.HealthyDog;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import java.io.IOException;

public class MyCustomSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException{
        String redirectUrl = null;

        for(GrantedAuthority authority: authentication.getAuthorities()){
            if(authority.getAuthority().equals("ADMIN")){
                redirectUrl = "/admin";
                break;
            } else {
                redirectUrl = "/";
            }
        }

        if(redirectUrl == null){
            throw new IllegalStateException();
        }
        new DefaultRedirectStrategy().sendRedirect(request,response,redirectUrl);
    }
}
