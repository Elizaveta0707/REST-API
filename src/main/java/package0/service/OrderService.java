package package0.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import package0.repository.OrderRepository;

import package0.model.Order;

import java.util.Arrays;
import java.util.List;
@Service
@Slf4j
public class OrderService implements IOrderService
{
    @Autowired
    private final OrderRepository orderRepository;
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> getAll() {
        return orderRepository.findAll();
    }

    @Override
    public Order getById(int id) {
        return orderRepository.findById(id).get();
    }
    public  void save (Order id)
    {
        orderRepository.save(id);
    }
    public  void delete(int id){
        orderRepository.deleteById(id);
    }
    public List<Order> getSortUsers(int page, int size, String[] sort) {

        return orderRepository.findAll(PageRequest.of(page, size, getSortCriteria(sort))).getContent();
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
