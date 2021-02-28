package com.jre.api.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.jre.api.documents.Cliente;

public interface ClienteRepository extends MongoRepository<Cliente, String> {

	Cliente findByNome(String nome);
	
	@Query("{ 'idade' : { $gt: ?0, $lt: ?1 } }")
	List<Cliente> findByIdadeBetween(int idadeInicial, int idadeFinal);
}
