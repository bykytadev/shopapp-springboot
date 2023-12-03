package com.project.shopapp.responses;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.project.shopapp.models.Category;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoryResponse {
    @JsonProperty("message")
    private String message;

    @JsonProperty("errors")
    private List<String> errors;

    @JsonProperty("category")
    private Category category;
}

