package com.jre.api.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/api")
public class Versionamento {

	/**
	 *  Versionamento da API pela url, define versao v1
	 * @param nome
	 * @return
	 */
	@GetMapping("/v1/versionamento")
	public ResponseEntity<String> olaNomeV1(@RequestParam("nome") String nome) {
		return ResponseEntity.ok(String.format("API v1, ola %s!", nome));
	}
	
	/**
	 *  Versionamento da API pela url, define versao v2
	 * @param nome
	 * @return
	 */
	@GetMapping("/v2/versionamento")
	public ResponseEntity<String> olaNomeV2(@RequestParam("nome") String nome) {
		return ResponseEntity.ok(String.format("API v2, ola %s!", nome));
	}
	
	/**
	 *  Versionamento da API pela Header "X-API-Version", define versao v1
	 * @param nome
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, headers = "X-API-Version=v1", value = "/versionamento")
	public ResponseEntity<String> olaNomeHeaderV1(@RequestParam("nome") String nome) {
		return ResponseEntity.ok(String.format("API Header v1, ola %s!", nome));
	}
	
	/**
	 *  Versionamento da API pela Header "X-API-Version", define versao v2
	 * @param nome
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, headers = "X-API-Version=v2", value = "/versionamento")
	public ResponseEntity<String> olaNomeHeaderV2(@RequestParam("nome") String nome) {
		return ResponseEntity.ok(String.format("API Header v2, ola %s!", nome));
	}
}
