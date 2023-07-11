package package0.service;


import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import package0.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import package0.repository.ProductRepository;

import java.util.Arrays;
import java.util.List;
@Service

public class ProductService implements  IProductService
{
    @Autowired
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public Product getById(int id)
    {
        return productRepository.findById(id).get();
    }

    @Override
    public void save(Product prod)
    {
        productRepository.save(prod);
    }

    public  void delete(int id){
        productRepository.deleteById(id);
    }
    public List<Product> getSortUsers(int page, int size, String[] sort) {
        return productRepository.findAll(PageRequest.of(page, size, getSortCriteria(sort))).getContent();
    }

    public Sort getSortCriteria(String[] sort)
    {
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

