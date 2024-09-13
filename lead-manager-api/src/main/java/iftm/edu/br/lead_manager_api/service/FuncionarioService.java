package iftm.edu.br.lead_manager_api.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import iftm.edu.br.lead_manager_api.model.Funcionario;
import iftm.edu.br.lead_manager_api.repository.FuncionarioRepository;

@Service
public class FuncionarioService {

    FuncionarioRepository repository;

    public FuncionarioService(FuncionarioRepository repository) {
        this.repository = repository;
    }

    public List<Funcionario> getAll() throws Exception {
        try {
            List<Funcionario> object = new ArrayList<>();
            repository.findAll().forEach(object::add);
            return object;
        } catch (Exception e) {
            return Collections.emptyList();
        }
    }

    public Funcionario getById(Long id) throws Exception {
        Optional<Funcionario> object = repository.findById(id);
        if (object.isPresent()) {
            return object.get();
        } else {
            return null;
        }
    }

    public Funcionario create(Funcionario data) {
        return repository.save(data);
    }

    public Funcionario update(Long id, Funcionario newData) {
        Optional<Funcionario> existingDataOptional = repository.findById(id);

        if (existingDataOptional.isPresent()) {
            Funcionario data = existingDataOptional.get();
            data.setNome(newData.getNome());
            data.setCpf(newData.getCpf());
            data.setCargo(newData.getCargo());
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
