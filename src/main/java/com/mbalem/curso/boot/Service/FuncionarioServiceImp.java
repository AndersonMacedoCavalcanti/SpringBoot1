package com.mbalem.curso.boot.Service;

import com.mbalem.curso.boot.dao.FuncionarioDao;
import com.mbalem.curso.boot.domain.Funcionarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class FuncionarioServiceImp implements FuncionarioService{

    @Autowired
    private FuncionarioDao dao;

    @Override @Transactional(readOnly = false)
    public void salvar(Funcionarios funcionarios) {
        dao.save(funcionarios);
    }

    @Override @Transactional(readOnly = false)
    public void editar(Funcionarios funcionarios) {
        dao.update(funcionarios);
    }

    @Override @Transactional(readOnly = false)
    public void excluir(Long id) {
        dao.delete(id);
    }

    @Override
    public Funcionarios buscarPorId(Long id) {
        return dao.findById(id);
    }

    @Override
    public List<Funcionarios> buscarTodos() {
        return dao.findAll();
    }
}
