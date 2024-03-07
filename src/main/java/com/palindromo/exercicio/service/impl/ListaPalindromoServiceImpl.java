package com.palindromo.exercicio.service.impl;

import com.palindromo.exercicio.domain.dto.PalindromoDTO;
import com.palindromo.exercicio.exception.BusinessException;
import com.palindromo.exercicio.exception.NotFoundException;
import com.palindromo.exercicio.repository.PalindromoRepository;
import com.palindromo.exercicio.service.ListaPalindromoService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

import static com.palindromo.exercicio.AppConstants.MENSAGEM_NENHUM_PALINDROMO_ENCONTRADO;
import static com.palindromo.exercicio.converter.PalindromoConverter.INSTANCE;
import static com.palindromo.exercicio.util.PredicateUtils.validar;

@Slf4j
@Service
public class ListaPalindromoServiceImpl implements ListaPalindromoService {

    @Autowired
    private PalindromoRepository palindromoRepository;

    @Override
    public List<PalindromoDTO> listarPalindromo(String palindromo) {
        log.info("Listando palídromos - {}", palindromo);
        var palindromoLista = this.palindromoRepository.listar(palindromo);
        if (!StringUtils.isBlank(palindromo)) validar(palindromoLista, CollectionUtils::isEmpty, () -> new NotFoundException(MENSAGEM_NENHUM_PALINDROMO_ENCONTRADO));
        log.info("Total encontrado: <{}>", palindromoLista.size());
        return INSTANCE.toPalindromoDTO(palindromoLista);
    }
}
