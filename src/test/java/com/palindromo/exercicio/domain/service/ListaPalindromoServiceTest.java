package com.palindromo.exercicio.domain.service;

import com.palindromo.exercicio.builder.PalindromoBuilder;
import com.palindromo.exercicio.domain.exception.NotFoundException;
import com.palindromo.exercicio.domain.repository.PalindromoRepository;
import com.palindromo.exercicio.domain.service.impl.ListaPalindromoServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ListaPalindromoServiceTest {

    @InjectMocks
    private ListaPalindromoServiceImpl mockListaPalindromoServiceImpl;

    @Mock
    private PalindromoRepository mockPalindromoRepository;

    @Test
    @DisplayName("Deve consultar um palíndromo sem exceção")
    void deveConsultarPalindromoSemErro() {
        when(this.mockPalindromoRepository.listar(anyString())).thenReturn(PalindromoBuilder.buildPalindromoList());
        assertDoesNotThrow(() -> this.mockListaPalindromoServiceImpl.listarPalindromo("OSSO"));
    }

    @Test
    @DisplayName("Deve listar todos os palíndromo sem exceção")
    void deveListarPalindromoSemErro() {
        when(this.mockPalindromoRepository.listar(null)).thenReturn(PalindromoBuilder.buildPalindromoList());
        assertDoesNotThrow(() -> this.mockListaPalindromoServiceImpl.listarPalindromo(null));
    }

    @Test
    @DisplayName("Deve lançar NotFoundException caso parâmetro de consulta informado e nenhum registro encontrado")
    void deveLancar_NotFoundException_parametroInformadoEListaVazia() {
        when(this.mockPalindromoRepository.listar(anyString())).thenReturn(Collections.emptyList());
        assertThrows(NotFoundException.class, () -> this.mockListaPalindromoServiceImpl.listarPalindromo("OSSO"));
    }
}
