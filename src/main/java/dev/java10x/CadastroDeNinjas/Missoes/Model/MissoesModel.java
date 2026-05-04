package dev.java10x.CadastroDeNinjas.Missoes.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome")
    private String nomeMissao;

    @Column(name = "dificuldade")
    private String dificuldade;

    @OneToMany(mappedBy = "missoes")
    @JsonIgnore       // para evitar loop infinito (vai ignorar a serialização)
    private List<NinjaModel> ninjas;

}


