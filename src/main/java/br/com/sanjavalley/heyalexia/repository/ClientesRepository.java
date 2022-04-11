package br.com.sanjavalley.heyalexia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.sanjavalley.heyalexia.entities.Cliente;

@Repository
public interface ClientesRepository extends JpaRepository<Cliente, Long> {

	@Query("select c from Cliente c where c.Nome like ?1")
	List<Cliente> findByName(String nome);
	   
}
