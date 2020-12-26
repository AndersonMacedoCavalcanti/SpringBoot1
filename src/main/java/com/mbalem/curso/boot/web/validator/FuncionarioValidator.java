package com.mbalem.curso.boot.web.validator;

import com.mbalem.curso.boot.domain.Funcionarios;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.time.LocalDate;

public class FuncionarioValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz){
        return Funcionarios.class.equals(clazz);
    }

    @Override
    public void validate(Object object, Errors errors) {
        Funcionarios f = (Funcionarios) object;
        LocalDate entrada  = f.getDataEntrada();

        if(f.getDataSaida() !=null){
            if(f.getDataSaida().isBefore(entrada)){
                errors.rejectValue("dataSaida","PosteriorDataEntrada.funcionarios.dataSaida");
            }
        }
    }

}
