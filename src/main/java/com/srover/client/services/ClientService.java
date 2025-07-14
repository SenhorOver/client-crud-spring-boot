package com.srover.client.services;

import com.srover.client.dto.ClientDTO;
import com.srover.client.entities.Client;
import com.srover.client.repositories.ClientRepository;
import com.srover.client.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ClientService {
    @Autowired
    private ClientRepository repository;

    public ClientDTO findById(Long id) {
        Client entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado"));
        return new ClientDTO(entity);
    }

    public Page<ClientDTO> findAll(Pageable pageable) {
        Page<Client> entities = repository.findAll(pageable);
        return entities.map(ClientDTO::new);
    }
}
