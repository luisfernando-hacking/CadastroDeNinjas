package dev.java10x.CadastroDeNinjas.Ninjas.Model;

import dev.java10x.CadastroDeNinjas.Missoes.Model.MissoesModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "tb_cadastro")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class NinjaModel {

    // --------------- ARQUITETURA POR CAMADA -----------------
    //
    //                    NO MINIMO
    //  Apresentação   -->     Controller
    //  Serviço        -->     Service
    //  Persistencia   -->     Repository (com banco de dados)
    //  Banco de Dados
    //
    //                 E tem outras, que ficam entre o service e o repository
    //                 -->     Model
    //                 -->     DTO
    //
    //  Monolito       -->     Todos os códigos no mesmo lugar


    // ORM (mapeamento objeto-relacional) --> um scanner que fica escaneando a todo momento a classe de entidade para criar/alterar colunas na tabela. ele mapeia, interpreta e envia todos os atributos para o banco de dados

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_gerado_sequencialmente")      // podemos especificar o nome da coluna
    private Long id;                    // PK --> primary key

    @Column(name = "nome_ninja")
    private String nome;                // VARCHAR(255)

    @Column(unique = true, name = "email_ninja")
    private String email;               // VARCHAR(255) Unique

    @Column(name = "img_url")
    private String imgUrl;

    @Column(name = "idade_ninja")
    private int idade;                  // INT

    @ManyToOne
    @JoinColumn(name = "missoes_id")
    private MissoesModel missoes;       // FK --> foreign key

}
