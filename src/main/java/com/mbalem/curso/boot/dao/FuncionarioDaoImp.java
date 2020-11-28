package com.mbalem.curso.boot.dao;

import com.mbalem.curso.boot.domain.Funcionarios;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public class FuncionarioDaoImp extends AbstractDao<Funcionarios, Long> implements FuncionarioDao {

    public List<Funcionarios> buscarPorNome(String nome){

        return createQuery("select f from Funcionarios f where f.nome like concat('%',?1,'%')", nome);
    }

    @Override
    public List<Funcionarios> findByDataEntrada(LocalDate entrada) {
        String jpql = "select f from Funcionarios f where f.dataEntrada = ?1 order by f.dataEntrada asc";
        return createQuery(jpql, entrada);
    }

    @Override
    public List<Funcionarios> fundByDataEntradaDataSaida(LocalDate entrada, LocalDate saida) {
        String jpql = "select f from Funcionarios f where f.dataEntrada = ?1 and f.dataSaida = ?2 order by f.dataEntrada asc";
        return createQuery(jpql, entrada, saida);
    }

    @Override
    public List<Funcionarios> findByDataSaida(LocalDate saida) {
        String jpql = "select f from Funcionarios f where f.dataSaida = ?1 order by f.dataSaida asc";
        return createQuery(jpql, saida);

    }

    @Override
    public List<Funcionarios> buscarPorCargo(Long id) {
        return createQuery("select f from Funcionarios f where f.cargo.id = ?1", id);
    }
}
