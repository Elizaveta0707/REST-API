package com.example.dto;

import java.util.Date;

public class OrdersDto {
    private long id;
    private Date date;
    private int price;

    public OrdersDto(long id, Date date, int price) {
        this.id = id;
        this.date = date;
        this.price = price;
    }

    public OrdersDto() {
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}
