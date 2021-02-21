package com.jre.api.dtos;

public class EmpresaDto {
	
	private Long Id;
	private String razaoSocial;
	private String cnpj;
	
	public EmpresaDto() {
		
	}
	
	public Long getId() {
		return Id;
	}
	
	public void setId(Long id) {
		Id = id;
	}
	
	// @NotEmpty(message = "Razao social nao pode ser vazia")
	// @Length(min = 5, max = 200, message = "Razao social deve conter entre 5 e 200 caracteres"
	public String getRazaoSocial() {
		return razaoSocial;
	}
	
	public void setRazaoSocial(String razao_social) {
		this.razaoSocial = razao_social;
	}
	
	// @NotEmpty(message = "Razao social nao pode ser vazia")
	// @CNPJ(message = "CNPJ invalido")
	public String getCnpj() {
		return cnpj;
	}
	
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	@Override
	public String toString() {
		return "EmpresaDto [Id=" + Id + ", razaoSocial=" + razaoSocial + ", cnpj=" + cnpj + "]";
	}
}
