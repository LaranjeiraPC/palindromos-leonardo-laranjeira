package com.palindromo.exercicio.domain.service;

import com.palindromo.exercicio.domain.model.dto.PalindromoDTO;

import java.util.List;

public interface ListaPalindromoService {
    List<PalindromoDTO> listarPalindromo(String palindromo);
}
