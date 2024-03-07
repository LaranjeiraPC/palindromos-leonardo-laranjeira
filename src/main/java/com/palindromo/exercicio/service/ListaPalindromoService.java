package com.palindromo.exercicio.service;

import com.palindromo.exercicio.domain.dto.PalindromoDTO;

import java.util.List;

public interface ListaPalindromoService {
    List<PalindromoDTO> listarPalindromo(String palindromo);
}
