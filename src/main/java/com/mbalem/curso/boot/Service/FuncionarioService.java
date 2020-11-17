package com.mbalem.curso.boot.Service;

import com.mbalem.curso.boot.domain.Funcionarios;

import java.util.List;

public interface FuncionarioService {
    void salvar(Funcionarios funcionarios);

    void editar(Funcionarios funcionarios);

    void excluir(Long id);

    Funcionarios buscarPorId(Long id);

    List<Funcionarios> buscarTodos();

}
