package com.jre.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.jre.api.entities.Empresa;
import com.jre.api.repositories.EmpresaRepository;
import com.jre.api.services.EmpresaService;
import com.jre.api.utils.SenhaUtils;

@SpringBootApplication
public class MeuPrimeiroProjetoApplication {

	@Autowired
	private EmpresaRepository empresaRepository;
	
	@Autowired
	private EmpresaService empresaService;
	
	@Value("${paginacao.qtd_por_pagina}")
	public int qtdPortPagina;
	
	public static void main(String[] args) {
		SpringApplication.run(MeuPrimeiroProjetoApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner() {
		return args -> {
			
			/* testando configurações de ambiente */
			System.out.println("### Quantidade de elementos por página = " + this.qtdPortPagina);
			
			/* testando configurações do BCrypt */
//			String senhaEncoded = SenhaUtils.gerarBCrypt("123456");
//			System.out.println("Senha encoded: " + senhaEncoded);
			
//			senhaEncoded = SenhaUtils.gerarBCrypt("123456");
//			System.out.println("Senha encoded novamente: " + senhaEncoded);
			
//			System.out.println("Senha válida: " + SenhaUtils.senhaValida("123456", senhaEncoded));
			
			/* testando configurações do repository */
			Empresa empresa = new Empresa();
			empresa.setRazaoSocial("JRE");
			empresa.setCnpj("42333222000121");
			
			this.empresaRepository.save(empresa);
			
			List<Empresa> empresas = this.empresaRepository.findAll();
			
			empresas.forEach(System.out::println);
			
//			Empresa empresaDB = this.empresaRepository.findOne(1L);
//			System.out.println("Empresa por ID: " + empresaDB);
			
			empresa.setRazaoSocial("JRE 2");
			this.empresaRepository.save(empresa);
			
			Empresa empresaCNPJ = this.empresaRepository.findByCnpj("42333222000121");
			System.out.println("Empresa por CNPJ: " + empresaCNPJ);
			
//			this.empresaRepository.delete(1L);
//			empresas = this.empresaRepository.findAll();
//			System.out.println("Empresas: " + empresas.size());
			
			/* testando um service */
			this.empresaService.testarServico();
		};
	}

}
