package com.mbalem.curso.boot.domain;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@SuppressWarnings("Serial")
@Entity
@Table(name = "CARGOS")
public class Cargo extends AbstractEntity<Long>{

    @NotBlank(message="Informe um nome.")
    @Size(min=3,max=60,message="O nome do cargo deve ter entre {min} e {max} caracteres.")
    @Column(name = "nome", nullable = false, unique = true,length = 60)
    private String nome;

    @ManyToOne
    @JoinColumn(name = "id_departamento_fk")
    private Departamento departamento;

    @OneToMany(mappedBy = "cargo")
    private List<Funcionarios> funcionarios;

    public List<Funcionarios> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(List<Funcionarios> funcionarios) {
        this.funcionarios = funcionarios;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }
}
