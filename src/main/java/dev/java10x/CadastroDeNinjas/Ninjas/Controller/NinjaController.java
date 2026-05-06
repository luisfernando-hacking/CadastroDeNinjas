package dev.java10x.CadastroDeNinjas.Ninjas.Controller;

import dev.java10x.CadastroDeNinjas.Ninjas.DTO.NinjaDTO;
import dev.java10x.CadastroDeNinjas.Ninjas.Service.NinjaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    private final NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @PostMapping("/adicionar")
    @Operation(summary = "Adicionar um novo ninja", description = "Essa rota permite adicionar um novo ninja")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Ninja criado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro na criação do ninja"),
    })
    public ResponseEntity<String> adicionarNinja(
            @Parameter(description = "Usuário precisa mandar as informações do ninja a ser adicionado pelo corpo da requisição") @RequestBody NinjaDTO ninjaDTO) {

        NinjaDTO ninja = ninjaService.criarNinja(ninjaDTO);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Ninja criado com sucesso: " + ninja.getNome() + " (ID): " + ninja.getId());
    }

    @GetMapping("/listar")
    @Operation(summary = "Listar todos os ninjas", description = "Essa rota permite listar todos os ninjas")
    public ResponseEntity<List<NinjaDTO>> listarNinjas() {
        List<NinjaDTO> ninjas = ninjaService.listarNinjas();

        return ResponseEntity.ok(ninjas);
    }

    @GetMapping("/listar/{id}")
    @Operation(summary = "Listar ninja por ID", description = "Essa rota permite listar um ninja pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ninja listado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Ninja não encontrado"),
    })
    public ResponseEntity<?> listarNinjasPorId(
            @Parameter(description = "Usuário precisa mandar o ID no caminho da requisição") @PathVariable Long id) {

        NinjaDTO ninja = ninjaService.listarNinjaPorId(id);

        if (ninja != null) {
            return ResponseEntity.ok(ninja);
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("O ninja com o id " + id + " não foi encontrado.");
        }
    }

    @PutMapping("editar/{id}")
    @Operation(summary = "Editar ninja por ID", description = "Essa rota permite editar um ninja pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ninja editado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Ninja não encontrado"),
    })
    public ResponseEntity<?> editarNinjaPorId(
            @Parameter(description = "Usuário precisa mandar o ID no caminho da requisição") @PathVariable Long id,
            @Parameter(description = "Usuário precisa mandar os dados do ninja a ser atualizado no corpo da requisição") @RequestBody NinjaDTO ninjaAtualizado) {

        NinjaDTO ninja = ninjaService.atualizarNinjaPorId(id, ninjaAtualizado);

        if (ninja != null) {
            return ResponseEntity.ok(ninja);
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("O ninja com o id " + id + " não foi encontrado.");
        }
    }

    @DeleteMapping("deletar/{id}")
    @Operation(summary = "Deletar ninja por ID", description = "Essa rota permite deletar um ninja pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ninja deletado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Ninja não encontrado"),
    })
    public ResponseEntity<String> deletarNinjaPorId(
            @Parameter(description = "Usuário precisa mandar o ID no caminho da requisição") @PathVariable Long id) {

        if (ninjaService.listarNinjaPorId(id) != null) {
            ninjaService.deletarNinjaPorId(id);

            return ResponseEntity.ok("O ninja com o id " + id + " deletado com sucesso.");
        }
        else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("O ninja com o id " + id + " não foi encontrado.");
            }
        }
}
