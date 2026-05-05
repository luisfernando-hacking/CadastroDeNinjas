package dev.java10x.CadastroDeNinjas.Missoes.DTO;

import dev.java10x.CadastroDeNinjas.Ninjas.Model.NinjaModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MissoesDTO {

    private Long id;
    private String nomeMissao;
    private String dificuldade;
    private List<NinjaModel> ninjas;

}
