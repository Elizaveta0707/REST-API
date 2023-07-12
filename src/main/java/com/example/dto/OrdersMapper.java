package com.example.dto;

import com.example.model.Client;
import com.example.model.Order;

public class OrdersMapper {
    public static OrdersDto mapToOrderDto(Order order) {
        OrdersDto ordersDto = new OrdersDto(order.getId(), order.getDate(), order.getPrice());
        return ordersDto;
    }

    public static Order mapToOrder(OrdersDto ordersDto) {
        Order order = new Order(ordersDto.getId(), ordersDto.getDate(), ordersDto.getPrice());
        return order;
    }
}
