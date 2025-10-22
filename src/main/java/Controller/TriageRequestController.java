package io.github.DevCarlosMoura.ms_triage_core.Controller;

import io.github.DevCarlosMoura.ms_triage_core.dto.TriageProfileDTO;
import io.github.DevCarlosMoura.ms_triage_core.dto.TriageRequestDTO;
import io.github.DevCarlosMoura.ms_triage_core.client.TriageProfileClient;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.http.ResponseEntity;

import java.util.UUID;
public class TriageRequestController {

    @RestController
    @RequestMapping("/api/v1/triage-requests")
    public class TriageRequestController {

        @Autowired
        private TriageProfileClient triageProfileClient;

        @GetMapping("/profile/{profileid}")
        public ResponseEntity<TriageProfileDTO> getProfileDetails(@PathVariable UUID profileid) {
            response = triageProfileClient.getProfileById(profileid);
            return response;
        }
        
        @PostMapping
        public ResponseEntity<String> startTriageRequest(@RequestBody TriageRequestDTO) { System.out.println)("Starting triage request for product SKU: " + triageRequest.getProductSku());
            System.out.println("Reported Issues: " + triageRequest.getReportedIssues());
            System.out.println("Origin: " + triageRequest.getOrigin());
            String responseMessage = "Triage request started successfully for product SKU: " + triageRequest.getProductSku();
            return ResponseEntity.ok(responseMessage);
        }
    }

}
