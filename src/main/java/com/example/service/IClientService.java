package com.example.service;

import com.example.dto.ClientDto;
import com.example.model.Client;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface IClientService {
    ClientDto getById(long id);

    ClientDto create(ClientDto userDto);

    void delete(long id);


    List<Client> getSortUsers(int page, int size, String[] sort);

    Sort getSortCriteria(String[] sort);

    List<ClientDto> getAll();
}
