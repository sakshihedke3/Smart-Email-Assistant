package com.email.writer.app;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/email")
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class EmailGeneratorController {

    private final EmailGeneratorService emailGeneratorService;

    @PostMapping("/generate")
    public ResponseEntity<?> generateEmail(@RequestBody EmailRequest emailRequest) {
        try {
            // Debug logs to see request in Render logs
            System.out.println("🔥 API HIT");
            System.out.println("EMAIL CONTENT: " + emailRequest.getEmailContent());
            System.out.println("TONE: " + emailRequest.getTone());

            // Generate email reply using service
            String response = emailGeneratorService.generateEmailReply(emailRequest);

            // Return success
            return ResponseEntity.ok(response);

        } catch (Exception e) {
            // Print stack trace to logs
            e.printStackTrace();

            // Return 500 with message
            return ResponseEntity.status(500).body("Failed to generate email reply: " + e.getMessage());
        }
    }

} // <-- Closing brace for the class
