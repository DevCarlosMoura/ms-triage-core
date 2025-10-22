package io.github.DevCarlosMoura.ms_triage_core.dto;

import lombok.Data;
import java.util.UUID;

@Data
public class TriageRequestDTO {
    private String productSku;
    private List<String> reportedIssues;
    private String origin;

}
