package dev.java10x.CadastroDeNinjas.Missoes.Mapper;

import dev.java10x.CadastroDeNinjas.Missoes.DTO.MissoesDTO;
import dev.java10x.CadastroDeNinjas.Missoes.Model.MissoesModel;
import org.springframework.stereotype.Component;

@Component
public class MissoesMapper {

    public MissoesModel mapping(MissoesDTO missoesDTO) {
        MissoesModel missoesModel = new MissoesModel();

        missoesModel.setId(missoesDTO.getId());
        missoesModel.setDificuldade(missoesDTO.getDificuldade());
        missoesModel.setNinjas(missoesDTO.getNinjas());
        missoesModel.setNomeMissao(missoesDTO.getNomeMissao());

        return missoesModel;
    }

    public MissoesDTO mapping(MissoesModel missoesModel) {
        MissoesDTO missoesDTO = new MissoesDTO();

        missoesDTO.setId(missoesModel.getId());
        missoesDTO.setDificuldade(missoesModel.getDificuldade());
        missoesDTO.setNinjas(missoesModel.getNinjas());
        missoesDTO.setNomeMissao(missoesModel.getNomeMissao());

        return missoesDTO;
    }

}
