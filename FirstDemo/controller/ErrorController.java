package com.example.FirstDemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class ErrorController implements org.springframework.boot.web.servlet.error.ErrorController {
	
	@RequestMapping("/error")
    public String handleError(HttpServletRequest request) {
        // Get the error status code
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");

        if (statusCode == 404) {
            // Return a custom error page for 404 errors
            return "error/404";
        } else {
            // Return a generic error page for all other errors
            return "error/generic";
        }
    }

    public String getErrorPath() {
        return "/error";
    }
}
