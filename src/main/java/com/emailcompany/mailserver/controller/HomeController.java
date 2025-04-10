package com.emailcompany.mailserver.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
// "Welcome to the Mail Server! Try /api/v1/users or /api/v1/emails";
@RestController
@RequestMapping("/")
public class HomeController {

    @GetMapping
    public String home() {
        return """
                <!DOCTYPE html>
                <html lang="en">
                <head>
                    <meta charset="UTF-8">
                    <meta name="viewport" content="width=device-width, initial-scale=1.0">
                    <title>Mail Server</title>
                    <style>
                        body { font-family: Arial, sans-serif; text-align: left; padding: 20px; }
                            h1 { color: #333; }
                            a { display: block; margin-top: 10px; font-size: 18px; }
                    </style>
                </head>
                <body>
                    <h1>Welcome to the Mail Server!</h1>
                    <img src="/resources/Epostsending11.png" alt="Logo" style="width: 500px; height: auto;">
                    <p>Try the following endpoints:</p>
                    
                    <!-- CREATE OPERATIONS -->
                    <!-- Can only use GET method in URL bar -->
                    
                    <!-- READ operations -->
                    <!-- See a list of users  -->
                    <p>See a list of users:</p>
                    <a href="/api/users">/api/users</a> <code>GET</code>
                    
                    <!-- See a list of emails -->
                    <p>See a list of emails:</p>
                    <a href="/api/emails">/api/emails</a> <code>GET</code>
                    
                    <!-- UPDATE operations -->
                    <!-- Can only use GET method in URL bar -->
                    
                    <!-- DELETE operations -->
                    <!-- Can only use GET method in URL bar -->
                    
                    <!-- Delete an email -->
                    <!-- Can only use GET method in URL bar-->
                    
                    <p>To create, update or delete entries, please use Postman as the URL bar method only supports the <code>GET</code> HTTP method.</p>
                    <p>For more information, please refer to the API documentation in README.md.</p>
                </body>
                </html>
                """;
    }
}
