package iftm.edu.br.lead_manager_api.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import iftm.edu.br.lead_manager_api.model.Endereco;
import iftm.edu.br.lead_manager_api.repository.EnderecoRepository;

@Service
public class EnderecoService {

    EnderecoRepository repository;

    public EnderecoService(EnderecoRepository repository) {
        this.repository = repository;
    }

    public List<Endereco> getAll() throws Exception {
        try {
            List<Endereco> object = new ArrayList<>();
            repository.findAll().forEach(object::add);
            return object;
        } catch (Exception e) {
            return Collections.emptyList();
        }
    }

    public Endereco getById(Long id) throws Exception {
        Optional<Endereco> object = repository.findById(id);
        if (object.isPresent()) {
            return object.get();
        } else {
            return null;
        }
    }

    public Endereco create(Endereco data) {
        return repository.save(data);
    }

    public Endereco update(Long id, Endereco newData) {
        Optional<Endereco> existingDataOptional = repository.findById(id);

        if (existingDataOptional.isPresent()) {
            Endereco data = existingDataOptional.get();
            data.setEstado(newData.getEstado());
            data.setCep(newData.getCep());
            data.setCidade(newData.getCidade());
            data.setRua(newData.getRua());
            data.setBairro(newData.getBairro());
            data.setNumero(newData.getNumero());
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
