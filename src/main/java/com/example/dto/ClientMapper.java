package com.example.dto;

import com.example.model.Client;

public class ClientMapper {
    public static ClientDto mapToUserDto(Client user) {
        ClientDto userDto = new ClientDto(user.getId(), user.getFio(), user.getNumber(), user.getAdress()

        );
        return userDto;
    }

    public static Client mapToUser(ClientDto userDto) {
        Client user = new Client(userDto.getId(), userDto.getFio(), userDto.getNumber(), userDto.getAdress());
        return user;
    }
}
