package com.example.service;

import com.example.model.Product;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface IProductService {
    Product getById(long id);

    void save(Product product);

    void delete(long id);

    List<Product> getAll();

    List<Product> getSortUsers(int page, int size, String[] sort);

    Sort getSortCriteria(String[] sort);
}
