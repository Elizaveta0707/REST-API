package com.example.dto;

public class ProductsDto {
    private long id;
    private String name;
    private int price;

    public ProductsDto() {
    }

    public ProductsDto(long id, String name, int price) {
        this.id = id;

        this.name = name;
        this.price = price;

    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}
