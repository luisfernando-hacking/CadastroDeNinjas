package dev.java10x.CadastroDeNinjas.Missoes.Controller;

import dev.java10x.CadastroDeNinjas.Missoes.Model.MissoesModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/missoes")
public class MissoesController {

    // CRUD --> Create / Read / Update / Delete

    @PostMapping("/criar")
    public String criarMissao() {
        return "missao criada";
    }

    @GetMapping("/listar")
    public String listarMissao() {
        return "missoes listadas";
    }

    @PutMapping("/editar")
    public String editarMissao() {
        return "missao editada";
    }

    @DeleteMapping("/deletar")
    public String deletarMissao() {
        return "missao deletada";
    }

}
