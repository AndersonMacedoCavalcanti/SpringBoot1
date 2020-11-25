package com.mbalem.curso.boot.Conversor;


import com.mbalem.curso.boot.Service.DepartamentoService;
import com.mbalem.curso.boot.domain.Departamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StringToDepartamentoConvert implements Converter<String, Departamento> {

    @Autowired
    private DepartamentoService service;

    @Override
    public Departamento convert(String text){
        if (text.isEmpty()){
            return null;
        }
        Long id = Long.valueOf(text);
        return service.buscarPorId(id);
    }
}
