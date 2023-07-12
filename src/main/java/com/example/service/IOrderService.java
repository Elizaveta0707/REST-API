package com.example.service;

import com.example.model.Order;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface IOrderService {
    Order getById(long id);

    void save(Order order);

    void delete(long id);

    List<Order> getAll();

    List<Order> getSortUsers(int page, int size, String[] sort);

    Sort getSortCriteria(String[] sort);
}
