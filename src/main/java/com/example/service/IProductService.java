package com.example.service;

import com.example.dto.ProductsDto;
import com.example.model.Product;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface IProductService {
    ProductsDto getById(long id);

    ProductsDto create(ProductsDto prod);

    void delete(long id);

    List<ProductsDto> getAll();

    List<Product> getSortUsers(int page, int size, String[] sort);

    Sort getSortCriteria(String[] sort);
}
