package com.mbalem.curso.boot.Service;

import com.mbalem.curso.boot.dao.FuncionarioDao;
import com.mbalem.curso.boot.domain.Funcionarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
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
    public List<Funcionarios> buscarPorNome(String nome) {
        return dao.buscarPorNome(nome);
    }

    @Override
    public List<Funcionarios> buscarPorCargo(Long id) {
        return dao.buscarPorCargo(id);
    }

    @Override
    public List<Funcionarios> buscarPorData(LocalDate entrada, LocalDate saida){
        
        if(entrada != null && saida != null){
            return dao.fundByDataEntradaDataSaida(entrada,saida);
        }else if(entrada !=null){
            return dao.findByDataEntrada(entrada);
        }else if(saida !=null){
            return dao.findByDataSaida(saida);
        }else{
            return new ArrayList<>();
        }

    }

    @Override
    public List<Funcionarios> buscarTodos() {
        return dao.findAll();
    }
}
