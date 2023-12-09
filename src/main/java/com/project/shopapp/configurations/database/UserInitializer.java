package com.project.shopapp.configurations.database;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.project.shopapp.models.User;
import com.project.shopapp.repositories.RoleRepository;
import com.project.shopapp.repositories.UserRepository;

@Configuration
public class UserInitializer {

    @Bean
    public CommandLineRunner initAdminUser(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            if (userRepository.findByPhoneNumber("0823826654").isEmpty()) {
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                Date dateOfBirth = formatter.parse("2000-10-15");

                User adminUser = User.builder()
                        .fullName("Hồ Minh Trung")
                        .phoneNumber("0823826654")
                        .address("Dĩ An, Bình Dương")
                        .password(passwordEncoder.encode("123456"))
                        .active(true)
                        .dateOfBirth(dateOfBirth)
                        .facebookAccountId(0)
                        .googleAccountId(0)
                        .role(roleRepository.findById(1L).orElse(null))
                        .build();
                userRepository.save(adminUser);
            }
        };
    }
}