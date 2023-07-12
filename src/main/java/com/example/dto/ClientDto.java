package com.example.dto;

public class ClientDto {
    private long id;
    private String fio;
    private long number;
    private String adress;

    public ClientDto(long id, String fio, long number, String adress) {
        this.id = id;
        this.fio = fio;
        this.number = number;
        this.adress = adress;
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

}
