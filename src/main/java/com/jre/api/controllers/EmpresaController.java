package com.jre.api.controllers;

import org.apache.tomcat.jni.Error;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jre.api.dtos.EmpresaDto;
import com.jre.api.responses.Response;

@Controller
public class EmpresaController {

	@GetMapping("/api/empresa")
	@ResponseBody
	public String nameEmpresa(@RequestParam("nome") String nome) {
		return "Nome da empresa:" + nome;
	}
	
	@PostMapping("/api/empresa")
	@ResponseBody
	public ResponseEntity<Response<EmpresaDto>> cadastrar(@RequestBody EmpresaDto empresaDto, BindingResult result) {
		Response<EmpresaDto> response = new Response<EmpresaDto>();
		
		if (result.hasErrors()) {
//			result.getAllErrors().forEach(error => response.getErrors().add(error.getDefaultMessage()));
//			return ResponseEntity.badRequest().body(response);
		}
		
		empresaDto.setId(1L);
		response.setData(empresaDto);
		
		return ResponseEntity.ok(response);
	}
}
