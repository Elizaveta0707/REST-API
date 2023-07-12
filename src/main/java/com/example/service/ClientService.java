package com.example.service;

import com.example.dto.ClientDto;
import com.example.dto.ClientMapper;
import com.example.model.Client;
import com.example.repository.ClientRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClientService implements IClientService {
    @Autowired
    private final ClientRepository clientRepository;

    public ClientService(ClientRepository userRepository) {
        this.clientRepository = userRepository;
    }

    @Override
    public ClientDto getById(long id) {
        Optional<Client> optionalUser = clientRepository.findById(id);
        Client user = optionalUser.get();
        return ClientMapper.mapToUserDto(user);
    }

    public ClientDto create(ClientDto userDto) {
        Client users = ClientMapper.mapToUser(userDto);

        Client savedUser = clientRepository.save(users);

        ClientDto savedUserDto = ClientMapper.mapToUserDto(savedUser);

        return savedUserDto;
    }

    public void delete(long id) {
        clientRepository.deleteById(id);
    }

    @Override
    public List<ClientDto> getAll() {
        List<Client> users = clientRepository.findAll();
        return users.stream().map(ClientMapper::mapToUserDto)
                .collect(Collectors.toList());
    }

    public List<Client> getSortUsers(int page, int size, String[] sort) {

        return clientRepository.findAll(PageRequest.of(page, size, getSortCriteria(sort))).getContent();
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
