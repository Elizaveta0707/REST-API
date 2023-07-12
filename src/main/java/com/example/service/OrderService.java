package com.example.service;

import com.example.dto.ClientDto;
import com.example.dto.ClientMapper;
import com.example.dto.OrdersDto;
import com.example.dto.OrdersMapper;
import com.example.model.Client;
import com.example.model.Order;
import com.example.repository.OrderRepository;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderService implements IOrderService {
    @Autowired
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public List<OrdersDto> getAll() {
        List<Order> orders = orderRepository.findAll();
        return orders.stream().map(OrdersMapper::mapToOrderDto)
                .collect(Collectors.toList());
    }

    @Override
    public OrdersDto getById(long id) {
        Optional<Order> optionalUser = orderRepository.findById(id);
        Order user = optionalUser.get();
        return OrdersMapper.mapToOrderDto(user);
    }

    public OrdersDto create(OrdersDto orders) {
        Order users = OrdersMapper.mapToOrder(orders);

        Order savedOrder = orderRepository.save(users);

        OrdersDto ordersDto = OrdersMapper.mapToOrderDto(savedOrder);

        return ordersDto;
    }

    public void delete(long id) {
        orderRepository.deleteById(id);
    }

    public List<Order> getSortUsers(int page, int size, String[] sort) {

        return orderRepository.findAll(PageRequest.of(page, size, getSortCriteria(sort))).getContent();
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
