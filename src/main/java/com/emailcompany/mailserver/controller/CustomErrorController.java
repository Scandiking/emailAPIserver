package com.emailcompany.mailserver.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CustomErrorController implements ErrorController {

    @RequestMapping("/error")
    @ResponseBody
    public String handleError(HttpServletRequest request) {
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        int statusCode = status != null ? Integer.parseInt(status.toString()) : 500;

        StringBuilder htmlBuilder = new StringBuilder();
        htmlBuilder.append("<!DOCTYPE html>");
        htmlBuilder.append("<html>");
        htmlBuilder.append("<head>");
        htmlBuilder.append("    <title>Error</title>");
        htmlBuilder.append("    <style>");
        htmlBuilder.append("        body { font-family: Arial, sans-serif; text-align: center; padding: 50px; }");
        htmlBuilder.append("        .error-container { max-width: 600px; margin: 0 auto; }");
        htmlBuilder.append("        h1 { color: #e74c3c; }");
        htmlBuilder.append("    </style>");
        htmlBuilder.append("</head>");
        htmlBuilder.append("<body>");
        htmlBuilder.append("    <div class=\"error-container\">");
        htmlBuilder.append("        <h1>Error " + statusCode + "</h1>");
        htmlBuilder.append("        <p>Sorry, something went wrong!</p>");
        htmlBuilder.append("        <p>Return to <a href=\"/\">homepage</a></p>");
        htmlBuilder.append("    </div>");
        htmlBuilder.append("</body>");
        htmlBuilder.append("</html>");

        return htmlBuilder.toString();
    }
}
