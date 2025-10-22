package io.github.DevCarlosMoura.ms_triage_core.client;

import io.github.DevCarlosMoura.ms_triage_core.dto.TriageProfileDTO;\
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@FeignClient(name = "triage-profile", url = "http://localhost:8080/api/v1/triage-profiles")
public interface TriageProfileClient {

    @GetMapping("/{id}")
    ResponseEntity<TriageProfileDTO> getTriageProfileById(@PathVariable("id") UUID id);

    @GetMapping("/by-sku/{sku}")
    ResponseEntity<TriageProfileDTO> getProfileBySku(@PathVariable ("sku") String sku);
}
