package com.palindromo.exercicio.workflow.converter;

import com.palindromo.exercicio.domain.model.dto.PalindromoDTO;
import com.palindromo.exercicio.domain.model.entity.Palindromo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PalindromoConverter {
    PalindromoConverter INSTANCE = Mappers.getMapper(PalindromoConverter.class);

    PalindromoDTO toPalindromoDTO(Palindromo palindromo);

    List<PalindromoDTO> toPalindromoDTO(List<Palindromo> palindromos);

}
