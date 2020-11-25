package com.mbalem.curso.boot.web.controller;

import com.mbalem.curso.boot.Service.CargoService;
import com.mbalem.curso.boot.Service.DepartamentoService;
import com.mbalem.curso.boot.domain.Cargo;
import com.mbalem.curso.boot.domain.Departamento;
import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/cargos")
public class CargosController {

    @Autowired
    private CargoService cargoService;

    @Autowired
    private DepartamentoService departamentoService;

    @GetMapping("/cadastrar")
    public String cadastrar(Cargo cargo) {
        return "/cargo/cadastro";
    }

    @GetMapping("/listar")
    public String listar(ModelMap model) {
        model.addAttribute("cargos",cargoService.buscarTodos());
        return "/cargo/lista";
    }

    @PostMapping("/salvar")
    public String salvar(Cargo cargo, RedirectAttributes attr) {
        cargoService.salvar(cargo);
        attr.addFlashAttribute("success", "cargo gravado com sucesso.");
        return "redirect:/cargos/cadastrar";
    }
    @GetMapping("/editar/{id}")
    public String preEditar(@PathVariable("id") Long id, ModelMap model){
        model.addAttribute("cargo",cargoService.buscarPorId(id));
        return "cargo/cadastro";
    }

    @PostMapping("/editar")
    public String editar(Cargo cargo, RedirectAttributes attr){
        cargoService.editar(cargo);
        attr.addFlashAttribute("success","Cargo alterado com sucesso");
        return "redirect:/cargos/cadastrar";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable("id") Long id, RedirectAttributes attr){

        if (cargoService.cargoTemFucionarios(id)){
            attr.addFlashAttribute("fail","Cargo não removido. Possui funcionario(s) cadastrado");
        }else{
            cargoService.excluir(id);
            attr.addFlashAttribute("success","Cargo removido com sucesso");

        }
        return "redirect:/cargos/listar";
    }


    @ModelAttribute("departamentos")
    public List<Departamento> listDeDepartamentos(){
        return departamentoService.buscarTodos();
    }
}
