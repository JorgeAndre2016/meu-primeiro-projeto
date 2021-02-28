package com.jre.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

import com.jre.api.documents.Cliente;
import com.jre.api.entities.Empresa;
import com.jre.api.repositories.ClienteRepository;
import com.jre.api.repositories.EmpresaRepository;
import com.jre.api.services.EmpresaService;
import com.jre.api.utils.SenhaUtils;

@SpringBootApplication
@EnableCaching
public class MeuPrimeiroProjetoApplication {

	@Autowired
	private EmpresaRepository empresaRepository;
	
	@Autowired
	private EmpresaService empresaService;

	@Autowired
	private ClienteRepository clienteReposity;
	
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
			System.out.println("testando o cache");
			this.empresaService.testarServico();
			
			/* testando mongodb */
			
			clienteReposity.deleteAll();
			
			clienteReposity.save(new Cliente("Jorge", 30));
			clienteReposity.save(new Cliente("Isabel", 26));
			clienteReposity.save(new Cliente("Luisa", 1));
			
			System.out.println("Lista todos com findAll():");
			System.out.println("-----------------------------");
			clienteReposity.findAll().forEach(System.out::println);
			System.out.println();
			
			System.out.println("Buscando um unico cliente com findByNome('Jorge'):");
			System.out.println("-----------------------------");
			System.out.println(clienteReposity.findByNome("Jorge"));
			
			System.out.println("Clientes com idade entre 18 and 35");
			System.out.println("-----------------------------");
			clienteReposity.findByIdadeBetween(18,  35).forEach(System.out::println);
		};
	}

}
