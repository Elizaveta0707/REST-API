package com.example.service;

import com.example.dto.OrdersDto;
import com.example.model.Order;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface IOrderService {
    OrdersDto getById(long id);

    OrdersDto create(OrdersDto orders);

    void delete(long id);

    List<OrdersDto> getAll();

    List<Order> getSortUsers(int page, int size, String[] sort);

    Sort getSortCriteria(String[] sort);
}
