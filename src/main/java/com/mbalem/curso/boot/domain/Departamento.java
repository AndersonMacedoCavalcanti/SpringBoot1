package com.mbalem.curso.boot.domain;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "DEPARTAMENTOS")

public class Departamento extends AbstractEntity<Long> {

    @Column(name = "name", nullable = false, unique = true, length = 60)
    private String nome;

    @OneToMany(mappedBy = "departamento")
    private List<Cargos> cargos;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Cargos> getCargos() {
        return cargos;
    }

    public void setCargos(List<Cargos> cargos) {
        this.cargos = cargos;
    }
}
