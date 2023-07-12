package com.example.dto;

import com.example.model.Order;
import com.example.model.Product;

public class ProductMapper {
    public static ProductsDto mapToProductDto(Product product) {
        ProductsDto productsDto = new ProductsDto(product.getId(), product.getName(), product.getPrice());
        return productsDto;
    }

    public static Product mapToProduct(ProductsDto productsDto) {
        Product product = new Product(productsDto.getId(), productsDto.getName(), productsDto.getPrice());
        return product;
    }
}
