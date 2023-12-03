package com.project.shopapp.services.product;

import org.springframework.data.domain.*;

import com.project.shopapp.dtos.ProductDTO;
import com.project.shopapp.dtos.ProductImageDTO;
import com.project.shopapp.models.Products.Product;
import com.project.shopapp.models.Products.ProductImage;
import com.project.shopapp.responses.ProductResponse;

public interface IProductService {
    Product createProduct(ProductDTO productDTO) throws Exception;

    Product getProductById(long id) throws Exception;

    Page<ProductResponse> getAllProducts(PageRequest pageRequest);

    Product updateProduct(long id, ProductDTO productDTO) throws Exception;

    void deleteProduct(long id);

    boolean existsByName(String name);

    ProductImage createProductImage(Long productId, ProductImageDTO productImageDTO) throws Exception;

}
