package io.github.DevCarlosMoura.ms_triage_core.dto;

import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
@Data
public class TriageProfileDTO {
    private UUID id;
    private String productSku;
    private List<string> componentCheckList;
    private List<String> criticalAnalysisPoints;
    private LocalDataTime createdAt;
    private LocalDataTime updatedAt;

}
