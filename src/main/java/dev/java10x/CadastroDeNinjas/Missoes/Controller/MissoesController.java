package dev.java10x.CadastroDeNinjas.Missoes.Controller;

import dev.java10x.CadastroDeNinjas.Missoes.DTO.MissoesDTO;
import dev.java10x.CadastroDeNinjas.Missoes.Service.MissoesService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/missoes")
public class MissoesController {

    private final MissoesService missoesService;

    public MissoesController(MissoesService missoesService) {
        this.missoesService = missoesService;
    }

    @PostMapping("/adicionar")
    @Operation(summary = "Adicionar uma nova missão", description = "Essa rota permite adicionar uma nova missão")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Missão criada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro na criação da missão"),
    })
    public ResponseEntity<String> adicionarMissao(
            @Parameter(description = "Usuário precisa mandar as informações da missão no corpo da requisição")
            @RequestBody MissoesDTO missao) {

        MissoesDTO novaMissao = missoesService.adicionarMissao(missao);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Missão criada com sucesso: " + novaMissao.getNomeMissao() + " (ID): " + novaMissao.getId());
    }

    @GetMapping("/listar")
    @Operation(summary = "Listar todas as missões", description = "Essa rota permite listar todas as missões")
    public ResponseEntity<List<MissoesDTO>> listarMissoes() {
        List<MissoesDTO> missoes = missoesService.listarMissoes();

        return ResponseEntity.ok(missoes);
    }

    @GetMapping("/listar/{id}")
    @Operation(summary = "Listar missão por ID", description = "Essa rota permite listar uma missão pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Missão encontrada com sucesso"),
            @ApiResponse(responseCode = "404", description = "Missão não encontrada"),
    })
    public ResponseEntity<?> listarMissaoPorId(
            @Parameter(description = "Usuário precisa mandar o ID no caminho da requisição")
            @PathVariable Long id) {

        MissoesDTO missao = missoesService.listarMissaoPorId(id);

        if (missao != null) {
            return ResponseEntity.ok(missao);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("A missão com o id " + id + " não foi encontrada.");
        }
    }

    @PutMapping("/editar/{id}")
    @Operation(summary = "Editar missão por ID", description = "Essa rota permite editar uma missão pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Missão editada com sucesso"),
            @ApiResponse(responseCode = "404", description = "Missão não encontrada"),
    })
    public ResponseEntity<?> editarMissaoPorId(
            @Parameter(description = "Usuário precisa mandar o ID no caminho da requisição")
            @PathVariable Long id,
            @Parameter(description = "Usuário precisa mandar os dados da missão atualizada no corpo da requisição")
            @RequestBody MissoesDTO missaoAtualizada) {

        MissoesDTO missao = missoesService.editarMissaoPorId(id, missaoAtualizada);

        if (missao != null) {
            return ResponseEntity.ok(missao);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("A missão com o id " + id + " não foi encontrada.");
        }
    }

    @DeleteMapping("/deletar/{id}")
    @Operation(summary = "Deletar missão por ID", description = "Essa rota permite deletar uma missão pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Missão deletada com sucesso"),
            @ApiResponse(responseCode = "404", description = "Missão não encontrada"),
    })
    public ResponseEntity<String> deletarMissaoPorId(
            @Parameter(description = "Usuário precisa mandar o ID no caminho da requisição")
            @PathVariable Long id) {

        if (missoesService.listarMissaoPorId(id) != null) {
            missoesService.deletarMissaoporId(id);

            return ResponseEntity.ok("A missão com o id " + id + " deletada com sucesso.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("A missão com o id " + id + " não foi encontrada.");
        }
    }
}