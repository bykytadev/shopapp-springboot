package com.project.shopapp.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.project.shopapp.dtos.CategoryDTO;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/categories") // http://localhost:8080/api/v1/categories
// @Validated // chưa chui vào hàm nó mới kiểm tra class thôi là kiểm tra rồi. Muốn hiện ra không được thì phải có @Valid
public class CategoryControllers {
    // Hiển thị tất cả danh mục sản phẩm
    @GetMapping("") // http://localhost:8080/api/v1/categories?page=1&limit=10
    public ResponseEntity<?> getAllCategories(
            @RequestParam(name = "page", defaultValue = "1") int page,
            @RequestParam(name = "limit", defaultValue = "10") int limit) {
        return ResponseEntity
                .ok(String.format("This is get all categories with page = %d and limit = %d", page, limit));
    }

    // Thêm mới danh mục sản phẩm
    // Nếu tham số truyền vào là 1 object thì sao ? ==> Data Transfer Object (DTO) = Request Object
    // Dùng @valid để kiểm tra tính hợp lệ của dữ liệu trước khi thực hiện hành động
    @PostMapping("")
    public ResponseEntity<?> createCategories(@Valid @RequestBody CategoryDTO categoryDTO, BindingResult result) {
        if (result.hasErrors()) {
            List<String> errorMessages = result.getFieldErrors().stream()
                    .map(fieldError -> fieldError.getDefaultMessage())
                    .collect(Collectors.toList());
            return ResponseEntity.badRequest().body(errorMessages);
        }
        return ResponseEntity.ok("This is create category with name = " + categoryDTO);
    }

    // Cập nhật danh mục sản phẩm
    @PutMapping("/{id}")
    public ResponseEntity<?> updateCategories(@PathVariable Long id) {
        return ResponseEntity.ok("This is update category with id = " + id + "");
    }

    // Xóa danh mục sản phẩm
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCategories(@PathVariable Long id) {
        return ResponseEntity.ok("Delete category with id = " + id);
    }
}