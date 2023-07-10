package package0.service;

import org.springframework.data.domain.Sort;
import package0.model.Product;
import package0.model.User;

import java.util.List;

public interface IProductService
{
    Product getById(int id);
    void save(Product product);
    void delete(int id);
    List<Product> getAll();
    List<Product> getSortUsers(int page, int size, String[] sort);
    Sort getSortCriteria(String[] sort);
}
