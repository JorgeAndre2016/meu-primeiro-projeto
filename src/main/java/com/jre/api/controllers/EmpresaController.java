package com.jre.api.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class EmpresaController {

	@GetMapping("/api/empresa")
	@ResponseBody
	public String nameEmpresa(@RequestParam("nome") String nome) {
		return "Nome da empresa:" + nome;
	}
}
