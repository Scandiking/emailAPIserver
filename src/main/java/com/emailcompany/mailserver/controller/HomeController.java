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
                    <p>Try the following endpoints:</p>
                    
                    <!-- See a list of users  -->
                    <p>See a list of users:</p>
                    <a href="/api/v1/users">/api/v1/users</a>
                    
                    <!-- See a list of emails -->
                    <p>See a list of emails:</p>
                    <a href="/api/v1/emails">/api/v1/emails</a>
                </body>
                </html>
                """;
    }
}
