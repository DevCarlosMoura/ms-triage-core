package io.github.DevCarlosMoura.ms_triage_core.client; // Corrected package name slightly for consistency

import java.util.UUID; // Corrected import slightly

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import io.github.DevCarlosMoura.ms_triage_core.dto.TriageProfileDTO;

// Corrected FeignClient name and package name to match conventions
@FeignClient(name = "triageProfileClient", url = "http://localhost:8080/api/v1/triage-profiles")
public interface TriageProfileClient {

    // Corrected method name to match usage
    @GetMapping("/{id}")
    ResponseEntity<TriageProfileDTO> getProfileById(@PathVariable("id") UUID id);

    @GetMapping("/by-sku/{sku}")
    ResponseEntity<TriageProfileDTO> getProfileBySku(@PathVariable("sku") String sku); // Kept this version
}