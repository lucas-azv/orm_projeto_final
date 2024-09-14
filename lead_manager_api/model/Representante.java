package iftm.edu.br.lead_manager_api.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "representantes")
public class Representante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome-representante", nullable = false)
    private String nome;

    @Column(name = "cnpj-representande", nullable = false)
    private String cnpj;

    @Column(name = "razao-socila", nullable = false)
    private String razaoSocial;

    @OneToOne
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;

    @OneToMany(mappedBy = "representante")
    private List<Funcionario> funcionarios;

    @OneToMany(mappedBy = "representante")
    private List<Representado> representados;

    @OneToMany(mappedBy = "representante")
    private List<Cliente> clientes;
    
}
