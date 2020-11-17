package com.mbalem.curso.boot.dao;

import com.mbalem.curso.boot.domain.Funcionarios;
import org.springframework.stereotype.Repository;

@Repository
public class FuncionarioDaoImp extends AbstractDao<Funcionarios, Long> implements FuncionarioDao {
}
