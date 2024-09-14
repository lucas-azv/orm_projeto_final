package iftm.edu.br.lead_manager_api.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import javax.management.RuntimeErrorException;

import org.springframework.stereotype.Service;

import iftm.edu.br.lead_manager_api.model.Representante;
import iftm.edu.br.lead_manager_api.repository.RepresentanteRepository;

@Service
public class RepresentanteService {

    RepresentanteRepository repository;

    public RepresentanteService(RepresentanteRepository repository) {
        this.repository = repository;
    }

    public List<Representante> getAll() throws Exception {
        try {
            List<Representante> object = new ArrayList<>();
            repository.findAll().forEach(object::add);
            return object;
        } catch (Exception e) {
            return Collections.emptyList();
        }
    }

    public Representante getById(Long id) throws Exception {
        Optional<Representante> object = repository.findById(id);
        if (object.isPresent()) {
            return object.get();
        } else {
            return null;
        }
    }

    public Optional<Representante> findByCnpj(String cnpj) throws Exception {
        try {
            if (cnpj.length() == 14) {
                return repository.findByCnpj(cnpj);
            } else {
                throw new IllegalArgumentException("CNPJ inválido. Deve ter 14 dígitos.");
            }
        } catch (Exception e) {
            throw new Exception("Erro ao buscar representante por CNPJ: " + e.getMessage(), e);
        }
    }

    public Representante create(Representante data) {
        return repository.save(data);
    }

    public Representante update(Long id, Representante newData) {
        Optional<Representante> existingDataOptional = repository.findById(id);

        if (existingDataOptional.isPresent()) {
            Representante data = existingDataOptional.get();
            data.setNome(newData.getNome());
            data.setCnpj(newData.getCnpj());
            data.setRazaoSocial(newData.getRazaoSocial());
            data.setEndereco(newData.getEndereco());
            data.setFuncionarios(newData.getFuncionarios());
            data.setRepresentados(newData.getRepresentados());
            data.setClientes(newData.getClientes());
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
