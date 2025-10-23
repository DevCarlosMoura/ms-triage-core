package io.github.DevCarlosMoura.mstriagecore.controller;

import io.github.DevCarlosMoura.mstriagecore.client.TriageProfileClient;
import io.github.DevCarlosMoura.mstriagecore.dto.TriageProfileDTO;
import io.github.DevCarlosMoura.mstriagecore.dto.TriageRequestDTO; // Import added
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus; // Import added
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*; // Combined imports

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/triage-requests") // Added leading slash
public class TriageRequestController {

    @Autowired
    private TriageProfileClient triageProfileClient;

    // Endpoint to test fetching profile details via Feign
    @GetMapping("/profile/{profileId}") // Corrected path and variable name
    public ResponseEntity<TriageProfileDTO> getProfileDetails(@PathVariable UUID profileId) { // Corrected parameter name
        ResponseEntity<TriageProfileDTO> response = triageProfileClient.getProfileById(profileId); // Corrected method call
        return response;
    }

    // Endpoint to start a new triage process
    @PostMapping
    public ResponseEntity<?> startTriage(@RequestBody TriageRequestDTO request) { // Corrected annotation and parameter name
        System.out.println("Starting triage for product SKU: " + request.getProductSku()); // Used 'request'

        try {
            // Call ms-triage-profile to get product details by SKU
            ResponseEntity<TriageProfileDTO> profileResponse = triageProfileClient.getProfileBySku(request.getProductSku()); // Corrected method call and used 'request'

            // Check if the profile was found
            if (profileResponse.getStatusCode().is2xxSuccessful() && profileResponse.getBody() != null) {
                TriageProfileDTO profile = profileResponse.getBody();
                System.out.println("Triage Profile Retrieved for SKU " + request.getProductSku() + ":"); // Used 'request'
                System.out.println(" - Component Checklist: " + profile.getComponentChecklist()); // Corrected getter name
                System.out.println(" - Critical Analysis Points: " + profile.getCriticalAnalysisPoints());

                // TODO: Call rules engine (ms-rules-engine) to make a decision
                // TODO: Send event/message for notification (ms-notification-service)

                String responseMessage = "Triage started for SKU " + request.getProductSku() + ". Profile Found."; // Used 'request'
                return ResponseEntity.ok(responseMessage);

            } else {
                // Profile not found in the other service
                System.err.println("Profile NOT found for SKU: " + request.getProductSku()); // Used 'request'
                String errorMessage = "Triage Profile not found for SKU: " + request.getProductSku(); // Used 'request'
                // Return a 404 Not Found status
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
            }

        } catch (Exception e) { // Generic catch for communication errors or others
            System.err.println("Error processing triage for SKU " + request.getProductSku() + ": " + e.getMessage()); // Used 'request'
            e.printStackTrace(); // Good practice to print the full error during development
            String errorMessage = "Internal error while processing triage request.";
            // Return a 500 Internal Server Error status
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
        }
    }
}