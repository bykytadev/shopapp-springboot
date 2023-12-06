package com.project.shopapp.controllers;

import java.net.InetAddress;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.project.shopapp.models.Category;
import com.project.shopapp.services.category.CategoryService;

import jakarta.annotation.security.PermitAll;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("${api.prefix}/healthcheck")
@AllArgsConstructor
public class HealthCheckController {
    private final CategoryService categoryService;

    @PermitAll
    @GetMapping("/health")
    public ResponseEntity<?> healthCheck() {
        // Perform additional health checks here
        try {
            List<Category> categories = categoryService.getAllCategories();
            // Get the computer name
            String computerName = InetAddress.getLocalHost().getHostName();
            return ResponseEntity.ok("ok, Computer Name: " + computerName);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("failed");
        }
    }
}
