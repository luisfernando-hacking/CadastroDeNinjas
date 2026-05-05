package dev.java10x.CadastroDeNinjas.Ninjas.Mapper;

import dev.java10x.CadastroDeNinjas.Ninjas.DTO.NinjaDTO;
import dev.java10x.CadastroDeNinjas.Ninjas.Model.NinjaModel;
import org.springframework.stereotype.Component;

// mapper --> dizendo pro spring que, por exemplo, o campo "id" do DTO é igual ao campo "id" do model (nao em relação ao nome, e sim a referência), e etc (para todos os campos)
@Component
public class NinjaMapper {

    public NinjaModel mapping(NinjaDTO ninjaDTO) {
        NinjaModel ninjaModel = new NinjaModel();

        // o model vai ter o mesmo valor do campo lá do DTO

        ninjaModel.setId(ninjaDTO.getId());
        ninjaModel.setNome(ninjaDTO.getNome());
        ninjaModel.setEmail(ninjaDTO.getEmail());
        ninjaModel.setImgUrl(ninjaDTO.getImgUrl());
        ninjaModel.setIdade(ninjaDTO.getIdade());
        ninjaModel.setMissoes(ninjaDTO.getMissoes());
        ninjaModel.setRank(ninjaDTO.getRank());

        return ninjaModel;
    }

    public NinjaDTO mapping(NinjaModel ninjaModel) {
        NinjaDTO ninjaDTO = new NinjaDTO();

        // o DTO vai ter o mesmo valor do campo lá do model (caminho inverso)

        ninjaDTO.setId(ninjaModel.getId());
        ninjaDTO.setNome(ninjaModel.getNome());
        ninjaDTO.setEmail(ninjaModel.getEmail());
        ninjaDTO.setImgUrl(ninjaModel.getImgUrl());
        ninjaDTO.setIdade(ninjaModel.getIdade());
        ninjaDTO.setMissoes(ninjaModel.getMissoes());
        ninjaDTO.setRank(ninjaModel.getRank());

        return ninjaDTO;
    }

}
