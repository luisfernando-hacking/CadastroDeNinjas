package dev.java10x.CadastroDeNinjas.Missoes.Service;

import dev.java10x.CadastroDeNinjas.Missoes.DTO.MissoesDTO;
import dev.java10x.CadastroDeNinjas.Missoes.Mapper.MissoesMapper;
import dev.java10x.CadastroDeNinjas.Missoes.Model.MissoesModel;
import dev.java10x.CadastroDeNinjas.Missoes.Repository.MissoesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MissoesService {

    private final MissoesRepository missoesRepository;
    private final MissoesMapper missoesMapper;

    public MissoesService(MissoesRepository missoesRepository, MissoesMapper missoesMapper) {
        this.missoesRepository = missoesRepository;
        this.missoesMapper = missoesMapper;
    }

    public List<MissoesDTO> listarMissoes() {
        List<MissoesModel> missoes = missoesRepository.findAll();

        return missoes.stream()
                .map(missoesMapper::mapping)
                .collect(Collectors.toList());
    }

    public MissoesDTO listarMissaoPorId(Long id) {
        Optional<MissoesModel> missao = missoesRepository.findById(id);

        return missao
                .map(missoesMapper::mapping)
                .orElse(null);
    }

    public MissoesDTO adicionarMissao(MissoesDTO missaoDTO) {
        MissoesModel missao = missoesMapper.mapping(missaoDTO);

        missao = missoesRepository.save(missao);

        return missoesMapper.mapping(missao);
    }

    public void deletarMissaoporId(Long id) {
        missoesRepository.deleteById(id);
    }

    public MissoesDTO editarMissaoPorId(Long id, MissoesDTO missaoAtualizadaDTO) {
        Optional<MissoesModel> missaoExistente = missoesRepository.findById(id);

        if (missaoExistente.isPresent()) {
            MissoesModel missaoAtualizadaModel = missoesMapper.mapping(missaoAtualizadaDTO);
            missaoAtualizadaModel.setId(id);
            MissoesModel missao = missoesRepository.save(missaoAtualizadaModel);

            return missoesMapper.mapping(missao);
        }

        return null;
    }

}
