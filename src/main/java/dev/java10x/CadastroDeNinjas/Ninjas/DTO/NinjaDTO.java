package dev.java10x.CadastroDeNinjas.Ninjas.DTO;

import dev.java10x.CadastroDeNinjas.Missoes.Model.MissoesModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// DTO --> "clone" do model mas sem acesso ao banco de dados, para não expor o model diretamente, criando camadas de abstração. tirando responsabilidades do model
//@Entity         // nao precisa disso!
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NinjaDTO {

    // e tambem nao precisa das annotations, já que nao tem responsabilidades

    private Long id;
    private String nome;
    private String email;
    private String imgUrl;
    private String rank;                // agora podemos adicionar o rank
    private int idade;
    private MissoesModel missoes;

}
