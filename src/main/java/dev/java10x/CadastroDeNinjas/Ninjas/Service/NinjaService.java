package dev.java10x.CadastroDeNinjas.Ninjas.Service;

import dev.java10x.CadastroDeNinjas.Ninjas.Model.NinjaModel;
import dev.java10x.CadastroDeNinjas.Ninjas.Repository.NinjaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NinjaService {

    @Autowired   // inicializando um construtor
    private NinjaRepository ninjaRepository;            // injeção de dependencia

    public List<NinjaModel> listarNinjas() {
        return ninjaRepository.findAll();
    }

}
