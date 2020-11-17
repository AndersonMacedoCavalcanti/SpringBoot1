package com.mbalem.curso.boot.dao;

import com.mbalem.curso.boot.domain.Departamento;
import com.mbalem.curso.boot.domain.Funcionarios;

import java.util.List;

public interface FuncionarioDao {

    void save (Funcionarios funcionarios);

    void update (Funcionarios funcionarios);

    void delete(Long id);

    Funcionarios findById(Long id);

    List<Funcionarios> findAll();

}
