package com.mbalem.curso.boot.dao;

import com.mbalem.curso.boot.domain.Funcionarios;

import java.time.LocalDate;
import java.util.List;

public interface FuncionarioDao {

    void save (Funcionarios funcionarios);

    void update (Funcionarios funcionarios);

    void delete(Long id);

    Funcionarios findById(Long id);

    List<Funcionarios> findAll();

    List<Funcionarios> buscarPorNome(String nome);

    List<Funcionarios> findByDataEntrada(LocalDate entrada);

    List<Funcionarios> fundByDataEntradaDataSaida(LocalDate entrada, LocalDate saida);

    List<Funcionarios> findByDataSaida(LocalDate saida);

    List<Funcionarios> buscarPorCargo(Long id);

}
