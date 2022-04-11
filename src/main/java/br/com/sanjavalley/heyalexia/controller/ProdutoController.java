package br.com.sanjavalley.heyalexia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;


import br.com.sanjavalley.heyalexia.entities.Produto;
import br.com.sanjavalley.heyalexia.exception.ResourceNotFoundException;
import br.com.sanjavalley.heyalexia.repository.ProdutoRepository;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

	@Autowired 
	private ProdutoRepository produtoRepository;
	
	@GetMapping
	private List<Produto> List(){
		
		return produtoRepository.findAll();
	}
	
	
	@GetMapping("/{id}")
	public Optional<Produto> ListarPorId(@PathVariable("id") Long id) {
		
		return  produtoRepository.findById(id) ;
	}	
    

	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public  Produto Adicionar(@Validated @RequestBody Produto produto) {
		
		return produtoRepository.save(produto);
	}
	
	@PutMapping("/{id}")
    public ResponseEntity < Produto > Atualizar(@PathVariable(value = "id") Long Id,
        @Validated @RequestBody Produto produtoBody) throws ResourceNotFoundException {
		Produto produto = produtoRepository.findById(Id)
            .orElseThrow(() -> new ResourceNotFoundException("Produto não encontrado para este id -> " + Id));
        
		produto.setProd_Nome(produtoBody.getProd_Nome());
	     
        final Produto updatedProduto = produtoRepository.save(produto);
        return ResponseEntity.ok(updatedProduto);
    }

	
	
    @DeleteMapping("/{id}")
    public Map < String, Boolean > Deletar(@PathVariable(value = "id") Long Id)
    throws ResourceNotFoundException {
        Produto produto= produtoRepository.findById(Id)
            .orElseThrow(() -> new ResourceNotFoundException("Produto não encontrado para este id -> " + Id));

        produtoRepository.delete(produto);
        Map < String, Boolean > response = new HashMap < > ();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

    
    
	
	
	
	
	
	
	
	
}
