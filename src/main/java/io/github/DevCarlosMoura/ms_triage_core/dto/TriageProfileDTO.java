package io.github.DevCarlosMoura.mstriagecore.dto; 

import java.time.LocalDateTime;
import java.util.List; 
import java.util.UUID;

import lombok.Data;

@Data
public class TriageProfileDTO {
    private UUID id;
    private String productSku;
    private List<String> componentChecklist; 
    private List<String> criticalAnalysisPoints;
    private LocalDateTime createdAt; 
    private LocalDateTime updatedAt;
}