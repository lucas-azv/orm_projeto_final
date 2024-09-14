package iftm.edu.br.lead_manager_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import iftm.edu.br.lead_manager_api.model.Cargo;

public interface CargoRepository extends JpaRepository<Cargo, Long> {
}
