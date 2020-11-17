package com.mbalem.curso.boot.dao;

import com.mbalem.curso.boot.domain.Cargo;
import com.mbalem.curso.boot.domain.Departamento;

import java.util.List;

public interface CargoDao {

    void save (Cargo cargo);

    void update (Cargo cargo);

    void delete(Long id);

    Cargo findById(Long id);

    List<Cargo> findAll();

}
