package dev.java10x.CadastroDeNinjas.Missoes.Model;

import dev.java10x.CadastroDeNinjas.Ninjas.Model.NinjaModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "tb_missoes")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class MissoesModel {

    // ORM (mapeamento objeto-relacional) --> um scanner que fica escaneando a todo momento a classe de entidade para criar/alterar colunas na tabela. ele mapeia, interpreta e envia todos os atributos para o banco de dados

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeMissao;

    private String dificuldade;

    @OneToMany(mappedBy = "missoes")
    private List<NinjaModel> ninjas;

}


