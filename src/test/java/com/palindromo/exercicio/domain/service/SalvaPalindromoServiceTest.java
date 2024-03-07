package com.palindromo.exercicio.domain.service;

import com.palindromo.exercicio.builder.PalindromoBuilder;
import com.palindromo.exercicio.domain.exception.BusinessException;
import com.palindromo.exercicio.domain.repository.PalindromoRepository;
import com.palindromo.exercicio.domain.service.impl.SalvaPalindromoServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SalvaPalindromoServiceTest {

    @InjectMocks
    private SalvaPalindromoServiceImpl mockSalvaPalindromoServiceImpl;

    @Mock
    private PalindromoRepository mockPalindromoRepository;

    @Test
    @DisplayName("Deve salvar palíndromo sem exceção")
    void deveSalvarPalindromoSemErro() {
        List<String> palavras = Arrays.asList("OSSO", "ASDF");
        when(this.mockPalindromoRepository.saveAll(any())).thenReturn(PalindromoBuilder.buildPalindromoList());
        assertDoesNotThrow(() -> this.mockSalvaPalindromoServiceImpl.salvarPalindromo(palavras));
        verify(this.mockPalindromoRepository).saveAll(any());
    }

    @Test
    @DisplayName("Deve lançar BusinessException caso o número de colunas tenha excedido o limite de 10 caracteres")
    void deveLancar_BusinessException_numeroColunasExcedido() {
        List<String> palavras = List.of("OSSOASDASDASDA");
        var expected = assertThrows(BusinessException.class, () -> this.mockSalvaPalindromoServiceImpl.salvarPalindromo(palavras));
        assertEquals("Limite de colunas excedido. Máximo 10 colunas!", expected.getMessage());
    }

    @Test
    @DisplayName("Deve lançar BusinessException caso o número de linha tenha excedido o limite de 10 caracteres")
    void deveLancar_BusinessException_numeroLinhasExcedido() {
        List<String> palavras = Arrays.asList("OSSO", "BASDF", "CASDF", "DASDF", "EASDF", "FASDF", "GASDF", "HASDF", "IASDF", "JASDF", "KASQEDF");
        var expected = assertThrows(BusinessException.class, () -> this.mockSalvaPalindromoServiceImpl.salvarPalindromo(palavras));
        assertEquals("Limite de linhas excedido. Máximo 10 linhas!", expected.getMessage());
    }
}
