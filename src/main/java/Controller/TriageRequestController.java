package io.github.DevCarlosMoura.mstriagecore.controller;

import io.github.DevCarlosMoura.mstriagecore.client.TriageProfileClient;
import io.github.DevCarlosMoura.mstriagecore.dto.TriageProfileDTO;
import io.github.DevCarlosMoura.mstriagecore.dto.TriageRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus; 
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*; 

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/triage-requests")
public class TriageRequestController {

    @Autowired
    private TriageProfileClient triageProfileClient;


    @GetMapping("/profile/{profileId}")
    public ResponseEntity<TriageProfileDTO> getProfileDetails(@PathVariable UUID profileId) { 
        ResponseEntity<TriageProfileDTO> response = triageProfileClient.getProfileById(profileId); 
        return response;
    }

    
    @PostMapping
    public ResponseEntity<?> startTriage(@RequestBody TriageRequestDTO request) { 
        System.out.println("Starting triage for product SKU: " + request.getProductSku()); 

        try {
           
            ResponseEntity<TriageProfileDTO> profileResponse = triageProfileClient.getProfileBySku(request.getProductSku()); 

            
            if (profileResponse.getStatusCode().is2xxSuccessful() && profileResponse.getBody() != null) {
                TriageProfileDTO profile = profileResponse.getBody();
                System.out.println("Triage Profile Retrieved for SKU " + request.getProductSku() + ":"); 
                System.out.println(" - Component Checklist: " + profile.getComponentChecklist()); 
                System.out.println(" - Critical Analysis Points: " + profile.getCriticalAnalysisPoints());


                String responseMessage = "Triage started for SKU " + request.getProductSku() + ". Profile Found."; 
                return ResponseEntity.ok(responseMessage);

            } else {

                System.err.println("Profile NOT found for SKU: " + request.getProductSku()); 
                String errorMessage = "Triage Profile not found for SKU: " + request.getProductSku(); 

                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
            }

        } catch (Exception e) { 
            System.err.println("Error processing triage for SKU " + request.getProductSku() + ": " + e.getMessage()); 
            e.printStackTrace(); 
            String errorMessage = "Internal error while processing triage request.";
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
        }
    }
}