package com.example.model;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Table(name = "orders")
@Entity
public class Order implements Serializable {
    @Id
    @Column(name = "ID", nullable = false, insertable = false, updatable = false)
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "date", nullable = false)
    private Date date;
    @Column(name = "price", nullable = false)
    private int price;

    public Order(Date date, int price) {
        this.date = date;
        this.price = price;
    }

    public Order() {
    }

    @ManyToOne
    @JoinColumn(name = "id_client")
    private Client client;
    @ManyToMany
    @JoinTable(name = "order_product", joinColumns = @JoinColumn(name = "id", referencedColumnName = "ID"), inverseJoinColumns = @JoinColumn(name = "id_pro", referencedColumnName = "ID"))
    private List<Product> productList;

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

    @Override
    public String toString() {
        return "Order{" + "id=" + id + ",date" + date + ",price" + price + '}';
    }

}