package io.github.DevCarlosMoura.ms_triage_core.client; 

import java.util.UUID; 

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import io.github.DevCarlosMoura.ms_triage_core.dto.TriageProfileDTO;


@FeignClient(name = "triageProfileClient", url = "http://localhost:8080/api/v1/triage-profiles")
public interface TriageProfileClient {


    @GetMapping("/{id}")
    ResponseEntity<TriageProfileDTO> getProfileById(@PathVariable("id") UUID id);

    @GetMapping("/by-sku/{sku}")
    ResponseEntity<TriageProfileDTO> getProfileBySku(@PathVariable("sku") String sku); // Kept this version
}