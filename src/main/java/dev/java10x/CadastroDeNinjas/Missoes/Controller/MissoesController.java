package dev.java10x.CadastroDeNinjas.Missoes.Controller;

import dev.java10x.CadastroDeNinjas.Missoes.DTO.MissoesDTO;
import dev.java10x.CadastroDeNinjas.Missoes.Service.MissoesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/missoes")
public class MissoesController {

    @Autowired
    private MissoesService missoesService;

    @PostMapping("/adicionar")
    public ResponseEntity<String> adicionarMissao(@RequestBody MissoesDTO missao) {
        MissoesDTO novaMissao = missoesService.adicionarMissao(missao);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Missão criada com sucesso: " + novaMissao.getNomeMissao() + " (ID): " + novaMissao.getId());
    }

    @GetMapping("/listar")
    public ResponseEntity<List<MissoesDTO>> listarMissoes() {
        List<MissoesDTO> missoes = missoesService.listarMissoes();

        return ResponseEntity.ok(missoes);
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarMissaoPorId(@PathVariable Long id) {
        MissoesDTO missao = missoesService.listarMissaoPorId(id);

        if (missao != null) {
            return ResponseEntity.ok(missao);
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("A missão com o id " + id + " não foi encontrada.");
        }
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<?> editarMissaoPorId(@PathVariable Long id, @RequestBody MissoesDTO missaoAtualizada) {
        MissoesDTO missao = missoesService.editarMissaoPorId(id, missaoAtualizada);

        if (missao != null) {
            return ResponseEntity.ok(missao);
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("A missão com o id " + id + " não foi encontrada.");
        }
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarMissaoPorId(@PathVariable Long id) {
        if (missoesService.listarMissaoPorId(id) != null) {
            missoesService.deletarMissaoporId(id);

            return ResponseEntity.ok("A missão com o id " + id + " deletada com sucesso.");
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("A missão com o id " + id + " não foi encontrada.");
        }
    }

}