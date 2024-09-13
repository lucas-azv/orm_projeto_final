package iftm.edu.br.lead_manager_api.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import iftm.edu.br.lead_manager_api.model.Representado;
import iftm.edu.br.lead_manager_api.repository.RepresentadoRepository;

@Service
public class RepresentadoService {

    RepresentadoRepository repository;

    public RepresentadoService(RepresentadoRepository repository) {
        this.repository = repository;
    }

    public List<Representado> getAll() throws Exception {
        try {
            List<Representado> object = new ArrayList<>();
            repository.findAll().forEach(object::add);
            return object;
        } catch (Exception e) {
            return Collections.emptyList();
        }
    }

    public Representado getById(Long id) throws Exception {
        Optional<Representado> object = repository.findById(id);
        if (object.isPresent()) {
            return object.get();
        } else {
            return null;
        }
    }

    public Representado create(Representado data) {
        return repository.save(data);
    }

    public Representado update(Long id, Representado newData) {
        Optional<Representado> existingDataOptional = repository.findById(id);

        if (existingDataOptional.isPresent()) {
            Representado data = existingDataOptional.get();
            data.setNome(newData.getNome());
            data.setCnpj(newData.getCnpj());
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
