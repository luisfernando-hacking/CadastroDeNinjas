package dev.java10x.CadastroDeNinjas.Ninjas.Service;

import dev.java10x.CadastroDeNinjas.Ninjas.Model.NinjaModel;
import dev.java10x.CadastroDeNinjas.Ninjas.Repository.NinjaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {

    @Autowired   // inicializando um construtor
    private NinjaRepository ninjaRepository;            // injeção de dependencia

    public List<NinjaModel> listarNinjas() {
        return ninjaRepository.findAll();
    }

    public NinjaModel listarNinjaPorId(Long id) {
        Optional<NinjaModel> ninja = ninjaRepository.findById(id);      // pode existir ou nao, entao se existir ele executa a linha
        return ninja.orElse(null);                                // se nao existir ele retorna nulo
    }

    public NinjaModel criarNinja(NinjaModel ninja) {
        return ninjaRepository.save(ninja);     // esse metodo é a mesma coisa que o insert
    }

    public void deletarNinjaPorId(Long id) {      // tem que ser void
        ninjaRepository.deleteById(id);                          // DELETE FROM TB_CADASTRO WHERE ID=?
    }

    public NinjaModel atualizarNinjaPorId(Long id, NinjaModel ninjaAtualizado) {
        if (ninjaRepository.existsById(id)) {                 // o ninja existe?
            ninjaAtualizado.setId(id);                        // se sim, pega o id do ninja original
            return ninjaRepository.save(ninjaAtualizado);     // salva o ninja atualizado
        }

        return null;   // caso nao exista
    }

}
