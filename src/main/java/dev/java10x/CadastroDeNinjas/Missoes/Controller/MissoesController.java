package dev.java10x.CadastroDeNinjas.Missoes.Controller;

import dev.java10x.CadastroDeNinjas.Missoes.DTO.MissoesDTO;
import dev.java10x.CadastroDeNinjas.Missoes.Service.MissoesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/missoes")
public class MissoesController {

    @Autowired
    private MissoesService missoesService;

    @PostMapping("/adicionar")
    public MissoesDTO adicionarMissao(@RequestBody MissoesDTO missao) {
        return missoesService.adicionarMissao(missao);
    }

    @GetMapping("/listar")
    public List<MissoesDTO> listarMissoes() {
        return missoesService.listarMissoes();
    }

    @GetMapping("/listar/{id}")
    public MissoesDTO listarMissaoPorId(@PathVariable Long id) {
        return missoesService.listarMissaoPorId(id);
    }

    @PutMapping("/editar/{id}")
    public MissoesDTO editarMissaoPorId(@PathVariable Long id, @RequestBody MissoesDTO missaoAtualizada) {
        return missoesService.editarMissaoPorId(id, missaoAtualizada);
    }

    @DeleteMapping("/deletar/{id}")
    public void deletarMissaoPorId(@PathVariable Long id) {
        missoesService.deletarMissaoporId(id);
    }

}
