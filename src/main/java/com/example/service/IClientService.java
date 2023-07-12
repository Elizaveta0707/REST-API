package com.example.service;

import com.example.model.Client;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface IClientService {
    Client getById(long id);

    void save(Client user);

    void delete(long id);

    List<Client> getAll();

    List<Client> getSortUsers(int page, int size, String[] sort);

    Sort getSortCriteria(String[] sort);
}
