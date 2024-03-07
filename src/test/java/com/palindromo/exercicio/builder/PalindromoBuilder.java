package com.palindromo.exercicio.builder;

import com.palindromo.exercicio.domain.model.entity.Palindromo;
import lombok.experimental.UtilityClass;

import java.util.Collections;
import java.util.List;

@UtilityClass
public class PalindromoBuilder {

    public static List<Palindromo> buildPalindromoList() {
        return Collections.singletonList(buildPalindromo());
    }

    public static Palindromo buildPalindromo() {
        return Palindromo.builder()
                .id(1)
                .palavra("OSSO")
                .build();
    }
}
