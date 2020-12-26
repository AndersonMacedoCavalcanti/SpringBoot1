package com.mbalem.curso.boot.web.controller;

import com.mbalem.curso.boot.Service.CargoService;
import com.mbalem.curso.boot.Service.FuncionarioService;
import com.mbalem.curso.boot.domain.Cargo;
import com.mbalem.curso.boot.domain.Funcionarios;
import com.mbalem.curso.boot.domain.Uf;
import com.mbalem.curso.boot.web.validator.FuncionarioValidator;
import org.springframework.beans.factory.FactoryBeanNotInitializedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @Autowired
    private CargoService cargoService;

    @InitBinder
    public void initBinder(WebDataBinder binder){
        binder.addValidators(new FuncionarioValidator());
    }

    @GetMapping("/cadastrar")
    public String cadastrar(Funcionarios funcionarios){
        return "/funcionario/cadastro";
    }

    @GetMapping("/listar")
    public String listar(ModelMap model){
        model.addAttribute("funcionarios", funcionarioService.buscarTodos());
        return "/funcionario/lista";
    }

    @PostMapping("/salvar")
    public String salvar(@Valid Funcionarios funcionarios, BindingResult result, RedirectAttributes attr){

        if(result.hasErrors()){
            return "/funcionario/cadastro";
        }



        funcionarioService.salvar(funcionarios);
        attr.addFlashAttribute("success","Funcionario inserido com sucesso");
        return "redirect:/funcionarios/cadastrar";
    }

    @ModelAttribute("cargos")
    public List<Cargo> getCargos(){
        return cargoService.buscarTodos();
    }

    @ModelAttribute("ufs")
    public  Uf[] getUfs(){
        return Uf.values();
    }

    @GetMapping("/editar/{id}")
    public String preEditar(@PathVariable("id") Long id,ModelMap model){
        model.addAttribute("funcionarios",funcionarioService.buscarPorId(id));
        return "/funcionario/cadastro";
    }

    @PostMapping("/editar")
    public String editar(@Valid Funcionarios funcionarios, BindingResult result ,RedirectAttributes attr){

        if(result.hasErrors()){
            return "/funcionario/cadastro";
        }



        funcionarioService.editar(funcionarios);
        attr.addFlashAttribute("success","Funcionario modificado com sucesso");
        return "redirect:/funcionarios/cadastrar";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable("id") Long id, RedirectAttributes attr){
        funcionarioService.excluir(id);
        attr.addFlashAttribute("success","Funcionario excluido com sucesso");
        return "redirect:/funcionarios/listar";

    }

    @GetMapping("/buscar/nome")
    public String getPorNome(@RequestParam("nome") String nome, ModelMap model){
        model.addAttribute("funcionarios",funcionarioService.buscarPorNome(nome));
        return "/funcionario/lista";
    }

    @GetMapping("/buscar/cargo")
    public String getPorCargo(@RequestParam("id") Long id, ModelMap model){
        model.addAttribute("funcionarios",funcionarioService.buscarPorCargo(id));
        return "/funcionario/lista";
    }

    @GetMapping("/buscar/data")
    public String getPorData(@RequestParam(value = "entrada", required = false)@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate entrada,
                             @RequestParam(value = "saida", required = false )@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate saida,
                             ModelMap model){
        model.addAttribute("funcionarios", funcionarioService.buscarPorData(entrada,saida));
        return "/funcionario/lista";
    }



}
