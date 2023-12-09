package com.project.shopapp.services.product;

import com.project.shopapp.models.Products.ProductImage;

public interface IProductImageService {
    ProductImage deleteProductImage(Long id) throws Exception;
}
