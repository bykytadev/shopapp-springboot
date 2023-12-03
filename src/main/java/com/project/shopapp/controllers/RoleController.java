package com.project.shopapp.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.shopapp.models.Role;
import com.project.shopapp.services.role.RoleService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("${api.prefix}/roles")
@RequiredArgsConstructor

public class RoleController {
    private final RoleService roleService;

    @GetMapping("")
    public ResponseEntity<?> getAllRoles() {
        List<Role> roles = roleService.getAllRoles();
        return ResponseEntity.ok(roles);
    }
}
