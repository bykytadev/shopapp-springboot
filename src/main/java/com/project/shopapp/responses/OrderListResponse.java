package com.project.shopapp.responses;

import java.util.List;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class OrderListResponse {
    private List<OrderResponse> orders;
    private int totalPages;
}
