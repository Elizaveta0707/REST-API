package com.example.rest;

import com.example.dto.ProductsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import com.example.model.Product;
import com.example.service.ProductService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/product/")
public class ProductRestController {
    @Autowired
    private ProductService productService;

    @RequestMapping(value = "{ID}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<ProductsDto> getOrders(@PathVariable("ID") Long id) {
        if (id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        ProductsDto product = this.productService.getById(id);
        if (id == 0) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<ProductsDto> createProduct(@RequestBody @Valid ProductsDto product) {
        HttpHeaders headers = new HttpHeaders();
        if (product == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        this.productService.create(product);
        return new ResponseEntity<>(product, headers, HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<ProductsDto> updateOrders(@RequestBody @Valid ProductsDto product, UriComponentsBuilder builder) {
        HttpHeaders heards = new HttpHeaders();
        if (product == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        this.productService.create(product);
        return new ResponseEntity<>(product, heards, HttpStatus.OK);
    }

    @RequestMapping(value = "{ID}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<ProductsDto> deleteOrders(@PathVariable("ID") Long id) {
        ProductsDto product = this.productService.getById(id);
        if (product == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        this.productService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<ProductsDto>> getAllOrders() {
        List<ProductsDto> products = this.productService.getAll();
        if (products.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(products, HttpStatus.OK);

    }

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllSort
            (
                    @RequestParam(defaultValue = "0") int page,
                    @RequestParam(defaultValue = "5") int size,
                    @RequestParam(defaultValue = "ID") String[] sort) {
        List<Product> products = productService.getSortUsers(page, size, sort);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
}
