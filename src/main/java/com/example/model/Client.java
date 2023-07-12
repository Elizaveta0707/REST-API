package com.example.model;

import javax.persistence.Entity;
import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "client")

public class Client implements Serializable {
    @Id
    @Column(name = "id_client")
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "fio")
    private String fio;
    @Column(name = "number")
    private long number;
    @Column(name = "adress")
    private String adress;


    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Order> orders = new ArrayList<>();

    public Client(long id, String fio, long number, String adress) {
        this.id = id;
        this.fio = fio;
        this.number = number;
        this.adress = adress;
    }

    public Client() {
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getFio() {
        return fio;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public Long getNumber() {
        return number;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getAdress() {
        return adress;
    }

    public void addComment(Order orders) {
        this.orders.add(orders);
    }

    @Override
    public String toString() {
        return "Client{" + "id=" + id + ",fio" + fio + ",number" + number + ",adress" + adress + '}';
    }
}