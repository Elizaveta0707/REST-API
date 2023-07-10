package package0.service;

import org.springframework.data.domain.Sort;
import package0.model.Order;
import package0.model.User;

import java.util.List;

public interface IOrderService
{
    Order getById(int id);
    void save(Order order);
    void delete(int id);
    List<Order> getAll();
    List<Order> getSortUsers(int page, int size, String[] sort);
    Sort getSortCriteria(String[] sort);
}
