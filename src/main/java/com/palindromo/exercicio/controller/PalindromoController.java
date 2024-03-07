package com.palindromo.exercicio.controller;

import com.palindromo.exercicio.domain.model.dto.PalindromoDTO;
import com.palindromo.exercicio.domain.service.ListaPalindromoService;
import com.palindromo.exercicio.domain.service.SalvaPalindromoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "Palindromo")
public class PalindromoController {

    @Autowired
    private SalvaPalindromoService salvaPalindromoService;

    @Autowired
    private ListaPalindromoService listaPalindromoService;

    @PostMapping("/palindromo")
    @Operation(summary = "Salvar Palíndromo(s)", description = "Verifica e armazena na base de dados o(s) palíndromo(s) encontrado(s)")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Dados cadastrado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Bad Request"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error - Erro inesperado no processamento de dados")
    })
    public ResponseEntity<List<PalindromoDTO>> salvarPalindromo(@RequestBody List<String> palavras) {
        return ResponseEntity.ok(this.salvaPalindromoService.salvarPalindromo(palavras));
    }

    @GetMapping("/palindromo")
    @Operation(summary = "Listar Palíndromo(s)", description = "Retorna uma lista de palíndromos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved"),
            @ApiResponse(responseCode = "404", description = "Not Found - Palíndromo não encontrado"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error - The product was not found")
    })
    public ResponseEntity<List<PalindromoDTO>> listarPalindromo(@RequestParam(required = false) String palindromo) {
        return ResponseEntity.ok(this.listaPalindromoService.listarPalindromo(palindromo));
    }
}
