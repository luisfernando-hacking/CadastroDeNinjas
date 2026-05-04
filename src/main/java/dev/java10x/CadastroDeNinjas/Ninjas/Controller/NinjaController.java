package dev.java10x.CadastroDeNinjas.Ninjas.Controller;

import dev.java10x.CadastroDeNinjas.Ninjas.Model.NinjaModel;
import dev.java10x.CadastroDeNinjas.Ninjas.Service.NinjaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    // CRUD --> Create / Read / Update / Delete

    @Autowired   // inicializando construtor
    private NinjaService ninjaService;      // injetando dependencia

    @PostMapping("/adicionar")
    public NinjaModel adicionarNinja(@RequestBody NinjaModel ninja) {    // resposta pelo corpo da requisicao, em JSON
        return ninjaService.criarNinja(ninja);
    }

    @GetMapping("/listar")
    public List<NinjaModel> listarNinjas() {
        return ninjaService.listarNinjas();
    }

    @GetMapping("/listar/{id}")           // usando path variables
    public NinjaModel listarNinjasPorId(@PathVariable Long id) {
        return ninjaService.listarNinjaPorId(id);
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
