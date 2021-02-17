package com.jre.api;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
class MeuPrimeiroProjetoApplicationTests {

	@Value("${paginacao.qtd_por_pagina}")
	public int qtdPorPagina;
	
	@Test
	public void contextLoads() {
	}
	
	@Test
	public void testarValorPaginacaoArquivoTeste() {
		assertEquals(1000, this.qtdPorPagina);
	}

}
