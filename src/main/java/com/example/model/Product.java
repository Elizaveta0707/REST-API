package com.example.model;


import javax.persistence.Entity;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "product")

public class Product implements Serializable {
    @Id
    @Column(name = "ID", nullable = false)
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "price", nullable = false)
    private int price;
    @ManyToMany(mappedBy = "productList")
    private List<Order> orderList;

    public Product() {
    }

    public Product(long id, String name, int price) {
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

    @Override
    public String toString() {
        return "Product{" + "id=" + id + ",name" + name + ",price" + price + '}';
    }
}