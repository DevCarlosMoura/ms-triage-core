package io.github.DevCarlosMoura.mstriagecore.dto; // Adjusted to match controller/client package name

import java.time.LocalDateTime;
import java.util.List; // Correct import (already present)
import java.util.UUID;

import lombok.Data;

@Data
public class TriageProfileDTO {
    private UUID id;
    private String productSku;
    private List<String> componentChecklist; // Corrected: Uppercase 'S' in String, lowercase 'l' in checklist
    private List<String> criticalAnalysisPoints;
    private LocalDateTime createdAt; // Corrected: LocalDateTime
    private LocalDateTime updatedAt; // Corrected: LocalDateTime
}