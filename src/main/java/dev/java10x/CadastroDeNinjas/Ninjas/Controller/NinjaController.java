package dev.java10x.CadastroDeNinjas.Ninjas.Controller;

import dev.java10x.CadastroDeNinjas.Ninjas.DTO.NinjaDTO;
import dev.java10x.CadastroDeNinjas.Ninjas.Service.NinjaService;
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
    public ResponseEntity<String> adicionarNinja(@RequestBody NinjaDTO ninjaDTO) {      // retornando uma resposta do tipo string
        NinjaDTO ninja = ninjaService.criarNinja(ninjaDTO);

        return ResponseEntity.status(HttpStatus.CREATED)                                                // enum com varios status, nesse caso "criado" (200 OK)  --> e dá pra colocar qualquer status
                .body("Ninja criado com sucesso: " + ninja.getNome() + " (ID): " + ninja.getId());      // retornando uma mensagem personalizada
    }

    @GetMapping("/listar")
    public ResponseEntity<List<NinjaDTO>> listarNinjas() {
        List<NinjaDTO> ninjas = ninjaService.listarNinjas();

        return ResponseEntity.ok(ninjas);        // (200 OK)
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarNinjasPorId(@PathVariable Long id) {
        NinjaDTO ninja = ninjaService.listarNinjaPorId(id);

        if (ninja != null) {
            return ResponseEntity.ok(ninja);      // devolvendo JSON
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("O ninja com o id " + id + " não foi encontrado.");
        }
    }

    @PutMapping("editar/{id}")
    public ResponseEntity<?> editarNinjaPorId(@PathVariable Long id, @RequestBody NinjaDTO ninjaAtualizado) {
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
    public ResponseEntity<String> deletarNinjaPorId(@PathVariable Long id) {
        if (ninjaService.listarNinjaPorId(id) != null) {
            ninjaService.deletarNinjaPorId(id);

            return ResponseEntity.ok("O ninja com o id " + id + " deletado com sucesso.");      // se tudo tiver ok, ele executa
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("O ninja com o id " + id + " não foi encontrado.");
        }
    }

}
