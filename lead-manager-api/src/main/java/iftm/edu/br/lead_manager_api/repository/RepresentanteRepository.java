package iftm.edu.br.lead_manager_api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import iftm.edu.br.lead_manager_api.model.Representante;

public interface RepresentanteRepository extends JpaRepository<Representante, Long> {

    @Query("SELECT r FROM Representante r WHERE r.cnpj = :cnpj")
    Optional<Representante> findByCnpj(@Param("cnpj") String cnpj);

    
}
