package br.com.sanjavalley.heyalexia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.sanjavalley.heyalexia.entities.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>  {
	
	

}
