package com.mbalem.curso.boot.dao;

import com.mbalem.curso.boot.domain.Cargo;
import org.springframework.stereotype.Repository;

@Repository
public class CargoDaoImp extends AbstractDao<Cargo, Long> implements CargoDao{
}
