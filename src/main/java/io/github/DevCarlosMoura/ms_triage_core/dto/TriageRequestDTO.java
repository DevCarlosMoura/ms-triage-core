package io.github.DevCarlosMoura.mstriagecore.dto; // Adjusted package name

import java.util.List;

import lombok.Data; // Added import for List

@Data
public class TriageRequestDTO {
    private String productSku;
    private List<String> reportedIssues; // Added List<String> type
    private String origin;
}