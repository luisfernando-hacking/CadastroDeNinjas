package dev.java10x.CadastroDeNinjas.Missoes.Repository;

import dev.java10x.CadastroDeNinjas.Missoes.Model.MissoesModel;
import org.springframework.data.jpa.repository.JpaRepository;


                        //  classe que o ORM vai ficar escaneando, o tipo do id
public interface MissoesRepository extends JpaRepository<MissoesModel, Long> {       // o JPA é uma abstração das querys do banco de dados



}
