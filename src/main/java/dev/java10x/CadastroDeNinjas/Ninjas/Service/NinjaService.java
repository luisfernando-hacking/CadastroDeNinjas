package dev.java10x.CadastroDeNinjas.Ninjas.Service;

import dev.java10x.CadastroDeNinjas.Ninjas.DTO.NinjaDTO;
import dev.java10x.CadastroDeNinjas.Ninjas.Mapper.NinjaMapper;
import dev.java10x.CadastroDeNinjas.Ninjas.Model.NinjaModel;
import dev.java10x.CadastroDeNinjas.Ninjas.Repository.NinjaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NinjaService {


    private final NinjaRepository ninjaRepository;
    private final NinjaMapper ninjaMapper;

    public NinjaService(NinjaRepository ninjaRepository, NinjaMapper ninjaMapper) {
        this.ninjaRepository = ninjaRepository;
        this.ninjaMapper = ninjaMapper;
    }

    public List<NinjaDTO> listarNinjas() {
        List<NinjaModel> ninjas = ninjaRepository.findAll();

        return ninjas.stream()
                .map(ninjaMapper::mapping)
                .collect(Collectors.toList());
    }

    public NinjaDTO listarNinjaPorId(Long id) {
        Optional<NinjaModel> ninja = ninjaRepository.findById(id);

        return ninja
                .map(ninjaMapper::mapping)
                .orElse(null);
    }

    public NinjaDTO criarNinja(NinjaDTO ninjaDTO) {
        NinjaModel ninja = ninjaMapper.mapping(ninjaDTO);

        ninja = ninjaRepository.save(ninja);

        return ninjaMapper.mapping(ninja);
    }

    public void deletarNinjaPorId(Long id) {      // como nao tem ligação direta com o model, nao tem o que mudar
        ninjaRepository.deleteById(id);
    }

    public NinjaDTO atualizarNinjaPorId(Long id, NinjaDTO ninjaAtualizadoDTO) {
        Optional<NinjaModel> ninjaExistente = ninjaRepository.findById(id);      // mesma coisa que o if/else

        if (ninjaExistente.isPresent()) {
            NinjaModel ninjaAtualizadoModel = ninjaMapper.mapping(ninjaAtualizadoDTO);
            ninjaAtualizadoModel.setId(id);
            NinjaModel ninja = ninjaRepository.save(ninjaAtualizadoModel);

            return ninjaMapper.mapping(ninja);
        }

        return null;
    }

}
