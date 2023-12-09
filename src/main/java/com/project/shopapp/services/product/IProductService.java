package com.project.shopapp.services.product;

import java.io.IOException;
import java.util.List;

import org.springframework.data.domain.*;
import org.springframework.web.multipart.MultipartFile;

import com.project.shopapp.dtos.ProductDTO;
import com.project.shopapp.dtos.ProductImageDTO;
import com.project.shopapp.models.Products.Product;
import com.project.shopapp.models.Products.ProductImage;
import com.project.shopapp.responses.ProductResponse;

public interface IProductService {
        Product createProduct(ProductDTO productDTO) throws Exception;

        Product getProductById(long id) throws Exception;

        public Page<ProductResponse> getAllProducts(String keyword, Long categoryId, PageRequest pageRequest);

        Product updateProduct(long id, ProductDTO productDTO) throws Exception;

        void deleteProduct(long id);

        boolean existsByName(String name);

        ProductImage createProductImage(Long productId, ProductImageDTO productImageDTO) throws Exception;

        List<Product> findProductsByIds(List<Long> productIds);

        String storeFile(MultipartFile file) throws IOException;

        void deleteFile(String filename) throws IOException;
}
