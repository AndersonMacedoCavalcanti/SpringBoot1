package com.mbalem.curso.boot.web.controller;

import com.mbalem.curso.boot.Service.DepartamentoService;
import com.mbalem.curso.boot.domain.Departamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/departamentos")
public class DepartamentoController {

    @Autowired
    private DepartamentoService service;

    @GetMapping("/cadastrar")
    public String cadastrar(Departamento departamento){
        return "/departamento/cadastro";
    }

    @GetMapping("/listar")
    public String listar(ModelMap model){
        model.addAttribute("departamentos",service.buscarTodos());
        return "departamento/lista";
    }

    @PostMapping("/salvar")
    public String salvar(Departamento departamento, RedirectAttributes attr){
        service.salvar(departamento);
        attr.addFlashAttribute("success","Departamento gravado com sucesso.");
        return "redirect:/departamentos/cadastrar";

    }
    @GetMapping("/editar/{id}")
    public String preEditar(@PathVariable("id") Long id, ModelMap model){
        model.addAttribute("departamento", service.buscarPorId(id));
        return "/departamento/cadastro";
    }
    @PostMapping("/editar")
    public String editar(Departamento departamento, RedirectAttributes attr){
        service.editar(departamento);
        attr.addFlashAttribute("success","Departamento editado com sucesso.");
        return "redirect:/departamentos/cadastrar";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable("id") Long id, RedirectAttributes attr){

        if (service.departamentoTemCargo(id)){
            attr.addFlashAttribute("fail","Departamento não removido. Possui cargo(s) cadastrados");
        }else{
            service.excluir(id);
            attr.addFlashAttribute("success","Departamento removido com sucesso");

        }
        return "redirect:/departamentos/listar";
    }



}
