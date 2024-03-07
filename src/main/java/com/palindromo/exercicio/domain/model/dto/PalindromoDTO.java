package com.palindromo.exercicio.domain.model.dto;

import lombok.*;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PalindromoDTO implements Serializable {
    private String palavra;
}
