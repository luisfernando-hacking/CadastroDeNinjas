package dev.java10x.CadastroDeNinjas.Ninjas.Repository;

import dev.java10x.CadastroDeNinjas.Ninjas.Model.NinjaModel;
import org.springframework.data.jpa.repository.JpaRepository;

//  JPA  --> shortcuts para querys em forma de métodos
public interface NinjaRepository extends JpaRepository<NinjaModel, Long> {
    // tem varios metodos padroes muito usados, mas podemos criar os nossos
}
