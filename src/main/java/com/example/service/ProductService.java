package com.example.service;

import com.example.dto.*;
import com.example.model.Client;
import com.example.model.Order;
import com.example.model.Product;
import com.example.repository.ProductRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService implements IProductService {
    @Autowired
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductsDto> getAll() {
        List<Product> products = productRepository.findAll();
        return products.stream().map(ProductMapper::mapToProductDto)
                .collect(Collectors.toList());
    }

    @Override
    public ProductsDto getById(long id) {
        Optional<Product> optionalUser = productRepository.findById(id);
        Product product = optionalUser.get();
        return ProductMapper.mapToProductDto(product);
    }


    @Override
    public ProductsDto create(ProductsDto prod) {
        Product mapToProduct = ProductMapper.mapToProduct(prod);

        Product savedOrder = productRepository.save(mapToProduct);

        ProductsDto productsDto = ProductMapper.mapToProductDto(savedOrder);

        return productsDto;
    }

    public void delete(long id) {
        productRepository.deleteById(id);
    }

    public List<Product> getSortUsers(int page, int size, String[] sort) {
        return productRepository.findAll(PageRequest.of(page, size, getSortCriteria(sort))).getContent();
    }

    public Sort getSortCriteria(String[] sort) {
        String[] sortProperties = new String[sort.length];
        Sort.Direction[] sortDirections = new Sort.Direction[sort.length];

        for (int i = 0; i < sort.length; i++) {
            String[] parts = sort[i].split(",");
            sortProperties[i] = parts[0];
            sortDirections[i] = parts[1].equalsIgnoreCase("asc") ? Sort.Direction.ASC : Sort.Direction.DESC;
        }

        return Sort.by(Arrays.toString(sortDirections)).and(Sort.by(sortProperties));
    }
}

