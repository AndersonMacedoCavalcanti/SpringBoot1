package com.mbalem.curso.boot.Service;

import com.mbalem.curso.boot.dao.DepartamentoDao;
import com.mbalem.curso.boot.domain.Departamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DepartamentoServiceImp implements DepartamentoService {

    @Autowired
    private DepartamentoDao dao;

    @Override  @Transactional(readOnly = false)
    public void salvar(Departamento departamento) {
        dao.save(departamento);

    }

    @Override @Transactional(readOnly = false)
    public void editar(Departamento departamento) {
        dao.update(departamento);
    }

    @Override @Transactional(readOnly = false)
    public void excluir(Long id) {
        dao.delete(id);
    }

    @Override @Transactional(readOnly = true)
    public Departamento buscarPorId(Long id) {
        return dao.findById(id);
    }

    @Override @Transactional(readOnly = true)
    public List<Departamento> buscarTodos() {
        return dao.findAll();
    }
}
