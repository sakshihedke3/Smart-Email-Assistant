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
        System.out.println("🔥 API HIT");
        System.out.println("EMAIL: " + emailRequest.getEmailContent());
        System.out.println("TONE: " + emailRequest.getTone());

        String response = emailGeneratorService.generateEmailReply(emailRequest);

        return ResponseEntity.ok(response);

    } catch (Exception e) {
        e.printStackTrace(); // THIS WILL SHOW IN RENDER LOGS
        return ResponseEntity.status(500).body(e.getMessage());
    }
}
