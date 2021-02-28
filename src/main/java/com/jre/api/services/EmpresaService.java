package com.jre.api.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class EmpresaService {

	private static final Logger log = LoggerFactory.getLogger(EmpresaService.class);

	@Cacheable("exemploCache")
	public void testarServico() {
		log.info("@@ exec");
		System.out.println("### Executando serviço de teste!!!");
	}
}
