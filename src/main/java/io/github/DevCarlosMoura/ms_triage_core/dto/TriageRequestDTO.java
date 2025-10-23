package io.github.DevCarlosMoura.mstriagecore.dto;

import java.util.List;

import lombok.Data; 

@Data
public class TriageRequestDTO {
    private String productSku;
    private List<String> reportedIssues; 
    private String origin;
}