package io.github.DevCarlosMoura.mstriagecore.controller;

import io.github.DevCarlosMoura.mstriagecore.client.TriageProfileClient;
import io.github.DevCarlosMoura.mstriagecore.dto.TriageProfileDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("api/v1/triage-requests")
public class TriageRequestController {
    @Autowired
    private TriageProfileClient triageProfileClient;

    @GetMapping("/{id}/triage-profile")
    public ResponseEntity<TriageProfileDTO> getProfileDetails(@PathVariable UUID profileid) {
        ResponseEntity<TriageProfileDTO> response = triageProfileClient.getTriageProfileById(profileid);
        return response;

    @PostMapping
    public ResponseEntity<?> startTriage(@ResquestBody TriageRequestDTO request) {
        System.out.println("Starting triage for product SKU: " + triageRequest.getProductSku());
        
        try {
            ResponseEntity<TriageProfileDTO> profileResponse = triageProfileClient.getTriageProfileBySku(triageRequest.getProductSku());
            
            if (profileResponse.getStatusCode().is2xxSuccessful() && profileResponse.getBody() != null) {
                TriageProfileDTO profile = profileResponse.getBody();
                System.out.println("Triage Profile Retrieved: " + triageRequest.getProductSku() + ":");
                System.out.println("Component Check List: " + profile.getComponentCheckList());
                System.out.println("Critical Analysis Points: " + profile.getCriticalAnalysisPoints());

                String responseMessage = "Triage started for product SKU: " + triageRequest.getProductSku() + " Profile Searched Successfully.";
                return ResponseEntity.ok(responseMessage);
        } else {
                System.err.println(" Profile not found for SKU: " + triageRequest.getProductSku());
                String errorMessage = "Triage Profile not found for SKU: " + triageRequest.getProductSku();
                return ResponseEntity.status(404).body(errorMessage);
        }
    } catch (Exception e) {
            System.err.println("Error retrieving profile for SKU: " + triageRequest.getProductSku());
            String errorMessage = "Error retrieving Triage Profile for SKU: " + triageRequest.getProductSku();
            return ResponseEntity.status(500).body(errorMessage);
        }
    }
}
