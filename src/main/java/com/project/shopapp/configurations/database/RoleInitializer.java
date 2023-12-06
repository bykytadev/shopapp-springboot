package com.project.shopapp.configurations.database;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.project.shopapp.models.Role;
import com.project.shopapp.repositories.RoleRepository;

@Configuration
public class RoleInitializer {

    @Bean
    public CommandLineRunner initRoles(RoleRepository roleRepository) {
        return args -> {
            if (roleRepository.findByName(Role.ADMIN) == null) {
                Role adminRole = Role.builder().id(1L).name(Role.ADMIN).build();
                roleRepository.save(adminRole);
            }

            if (roleRepository.findByName(Role.USER) == null) {
                Role userRole = Role.builder().id(2L).name(Role.USER).build();
                roleRepository.save(userRole);
            }
        };
    }
}