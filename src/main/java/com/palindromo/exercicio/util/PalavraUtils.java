package com.palindromo.exercicio.util;

import lombok.experimental.UtilityClass;

import java.util.List;
import java.util.Objects;

@UtilityClass
public class PalavraUtils {

    public static final int LIMITE_COLUNA = 10;
    public static final int LIMITE_LINHA = 10;

    public static boolean verificarLinhas(List<String> listaPalavras) {
        return listaPalavras.size() > LIMITE_LINHA;
    }

    public static boolean verificarColunas(List<String> listaPalavras) {
        return listaPalavras.stream()
                .filter(Objects::nonNull)
                .anyMatch(palavra -> palavra.length() > LIMITE_COLUNA);
    }
}
