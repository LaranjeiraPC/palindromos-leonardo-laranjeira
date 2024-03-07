package com.palindromo.exercicio.service.impl;

import com.palindromo.exercicio.domain.dto.PalindromoDTO;
import com.palindromo.exercicio.domain.model.Palindromo;
import com.palindromo.exercicio.exception.BusinessException;
import com.palindromo.exercicio.repository.PalindromoRepository;
import com.palindromo.exercicio.service.SalvaPalindromoService;
import com.palindromo.exercicio.util.PalavraUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Objects;

import static com.palindromo.exercicio.AppConstants.*;
import static com.palindromo.exercicio.converter.PalindromoConverter.INSTANCE;
import static com.palindromo.exercicio.util.PredicateUtils.validar;

@Slf4j
@Service
public class SalvaPalindromoServiceImpl implements SalvaPalindromoService {

    @Autowired
    private PalindromoRepository palindromoRepository;

    public List<PalindromoDTO> salvarPalindromo(List<String> palavras) {
        log.info("Validando palíndromo");
        validar(palavras, PalavraUtils::verificarColunas, () -> new BusinessException(MENSAGEM_ERROR_COLUNA));
        validar(palavras, PalavraUtils::verificarLinhas, () -> new BusinessException(MENSAGEM_ERROR_LINHA));

        var palindromos = this.definirPalindromo(palavras);
        validar(palindromos, CollectionUtils::isEmpty, () -> new BusinessException(MENSAGEM_NENHUM_PALINDROMO_ENCONTRADO));

        log.info("Salvando dados. Total: <{}>", palindromos.size());
        var savedPalindromo = this.palindromoRepository.saveAll(palindromos);
        return INSTANCE.toPalindromoDTO(savedPalindromo);
    }

    private List<Palindromo> definirPalindromo(List<String> palavras) {
        log.info("Verificando existência de palíndromo");
        return palavras.stream()
                .filter(Objects::nonNull)
                .map(this::verificarPalindromo)
                .filter(Objects::nonNull)
                .map(contrario -> Palindromo.builder().palavra(contrario).build())
                .toList();
    }

    private String verificarPalindromo(String palavra) {
        StringBuilder contrario = new StringBuilder();
        for (int i = (palavra.length() - 1); i >= 0; i--) contrario.append(palavra.charAt(i));
        return (contrario.toString().equalsIgnoreCase(palavra)) ? contrario.toString() : null;
    }

}