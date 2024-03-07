package com.palindromo.exercicio.domain.repository;

import com.palindromo.exercicio.domain.model.entity.Palindromo;
import jakarta.annotation.Nullable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PalindromoRepository extends JpaRepository<Palindromo, Integer> {

    @Query(value = "FROM Palindromo p WHERE (:palavra IS NULL OR p.palavra = :palavra)")
    List<Palindromo> listar(@Nullable String palavra);

}
