package com.project.shopapp.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateCategoryResponse {
    @JsonProperty("message")
    private String message;
}