package iftm.edu.br.lead_manager_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import iftm.edu.br.lead_manager_api.model.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
}
