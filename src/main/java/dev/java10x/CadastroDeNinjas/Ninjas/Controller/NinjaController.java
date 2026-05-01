package dev.java10x.CadastroDeNinjas.Ninjas.Controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    // CRUD --> Create / Read / Update / Delete

    @PostMapping("/adicionar")
    public String criarNinja() {
        return "Ninja adicionado";
    }

    @GetMapping("/listar")
    public String listarNinjas() {
        return "Ninja listados";
    }

    @GetMapping("/listar/{id}")
    public String listarNinjasPorId() {
        return "Ninja listados por ID";
    }

    @PutMapping("editar/{id}")
    public String editarNinjaPorId() {
        return "Ninja editado por ID";
    }

    @DeleteMapping("deletar/{id}")
    public String deletarNinja() {
        return "Ninja deletado por ID";
    }

}
