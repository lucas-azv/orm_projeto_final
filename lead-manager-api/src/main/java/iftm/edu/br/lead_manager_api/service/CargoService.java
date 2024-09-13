package iftm.edu.br.lead_manager_api.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import iftm.edu.br.lead_manager_api.model.Cargo;
import iftm.edu.br.lead_manager_api.repository.CargoRepository;

@Service
public class CargoService {

    CargoRepository repository;

    public CargoService(CargoRepository repository) {
        this.repository = repository;
    }

    public List<Cargo> getAll() throws Exception {
        try {
            List<Cargo> cargos = new ArrayList<>();
            repository.findAll().forEach(cargos::add);
            return cargos;
        } catch (Exception e) {
            return Collections.emptyList();
        }
    }

    public Cargo getById(Long id) throws Exception {
        Optional<Cargo> cargo = repository.findById(id);
        if (cargo.isPresent()) {
            return cargo.get();
        } else {
            return null;
        }
    }

    public Cargo create(Cargo cargo) {
        return repository.save(cargo);
    }

    public Cargo update(Long id, Cargo newData) {
        Optional<Cargo> existingDataOptional = repository.findById(id);

        if (existingDataOptional.isPresent()) {
            Cargo data = existingDataOptional.get();
            data.setNome(newData.getNome());
            data.setFuncionarios(newData.getFuncionarios());
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
