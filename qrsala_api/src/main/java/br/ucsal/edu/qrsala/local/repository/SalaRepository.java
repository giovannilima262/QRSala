package br.ucsal.edu.qrsala.local.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.ucsal.edu.qrsala.local.entity.Sala;

@Repository
public interface SalaRepository extends JpaRepository<Sala, Long> {

    @Query("SELECT sala FROM Sala sala WHERE sala.nome = :nome and sala.diaSemana = :semana order by sala.horarioInicio")
    public List<Sala> obterPorNomeAndSemana(@Param("nome") String nome, @Param("semana") Integer semana);
    
    @Query("SELECT distinct sala.nome FROM Sala sala WHERE sala.diaSemana = :semana ")
    public List<String> obterSalaDistinctPorSemana(@Param("semana") Integer semana);

    @Query("SELECT distinct sala.diaSemana FROM Sala sala")
    public List<Integer> obterDistinctSemana();
}
