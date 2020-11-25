package com.mbalem.curso.boot.dao;

import com.mbalem.curso.boot.domain.Funcionarios;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FuncionarioDaoImp extends AbstractDao<Funcionarios, Long> implements FuncionarioDao {

    public List<Funcionarios> buscarPorNome(String nome){

        return createQuery("select f from Funcionarios f where f.nome like concat('%',?1,'%')", nome);
    }

    @Override
    public List<Funcionarios> buscarPorCargo(Long id) {
        return createQuery("select f from Funcionarios f where f.cargo.id = ?1", id);
    }
}
