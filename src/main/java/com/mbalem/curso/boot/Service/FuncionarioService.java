package com.mbalem.curso.boot.Service;

import com.mbalem.curso.boot.domain.Funcionarios;

import java.time.LocalDate;
import java.util.List;

public interface FuncionarioService {
    void salvar(Funcionarios funcionarios);

    void editar(Funcionarios funcionarios);

    void excluir(Long id);

    Funcionarios buscarPorId(Long id);

    List<Funcionarios> buscarPorNome(String nome);

    List<Funcionarios> buscarPorCargo(Long id);

    List<Funcionarios> buscarPorData(LocalDate entrada, LocalDate saida);

    List<Funcionarios> buscarTodos();

}
