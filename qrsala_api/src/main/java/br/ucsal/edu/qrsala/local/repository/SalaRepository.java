package br.ucsal.edu.qrsala.local.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.ucsal.edu.qrsala.local.entity.Sala;

@Repository
public interface SalaRepository extends JpaRepository<Sala, Long> {

    @Query("SELECT sala FROM Sala sala")
    public List<Sala> obterTodos();

    @Query("SELECT distinct sala.nome FROM Sala sala")
    public List<String> obterDistinctNome();


    @Query("SELECT sala FROM Sala sala WHERE sala.nome = :nome")
    public List<Sala> obterSalasPorNome(@Param("nome") String nome);
}
