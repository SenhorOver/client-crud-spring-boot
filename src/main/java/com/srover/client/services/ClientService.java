package com.srover.client.services;

import com.srover.client.dto.ClientDTO;
import com.srover.client.entities.Client;
import com.srover.client.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {
    @Autowired
    private ClientRepository repository;

    public ClientDTO findById(Long id) {
        Client entity = repository.findById(id).orElse(null);
        return new ClientDTO(entity);
    }
}
