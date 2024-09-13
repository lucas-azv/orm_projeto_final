package iftm.edu.br.lead_manager_api.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import iftm.edu.br.lead_manager_api.model.Cliente;
import iftm.edu.br.lead_manager_api.repository.ClienteRepository;

@Service
public class ClienteService {

    ClienteRepository repository;

    public ClienteService(ClienteRepository repository) {
        this.repository = repository;
    }

    public List<Cliente> getAll() throws Exception {
        try {
            List<Cliente> object = new ArrayList<>();
            repository.findAll().forEach(object::add);
            return object;
        } catch (Exception e) {
            return Collections.emptyList();
        }
    }

    public Cliente getById(Long id) throws Exception {
        Optional<Cliente> object = repository.findById(id);
        if (object.isPresent()) {
            return object.get();
        } else {
            return null;
        }
    }

    public Cliente create(Cliente data) {
        return repository.save(data);
    }

    public Cliente update(Long id, Cliente newData) {
        Optional<Cliente> existingDataOptional = repository.findById(id);

        if (existingDataOptional.isPresent()) {
            Cliente data = existingDataOptional.get();
            data.setNome(newData.getNome());
            data.setTelefone(newData.getTelefone());
            data.setEmail(newData.getEmail());
            data.setEndereco(newData.getEndereco());
            data.setRepresentante(newData.getRepresentante());
            return repository.save(data);
        } else {
            return null;
        }
    }

    public boolean deleteById(Long id) {
        try {
            repository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
