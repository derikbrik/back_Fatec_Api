package br.com.sanjavalley.heyalexia.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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


import br.com.sanjavalley.heyalexia.entities.Tipo_Produto;
import br.com.sanjavalley.heyalexia.exception.ResourceNotFoundException;
import br.com.sanjavalley.heyalexia.repository.Tipo_ProdutoRepository;

@RestController
@RequestMapping("/tipos-produtos")
public class Tipo_ProdutoController {
	
	@Autowired 
	private Tipo_ProdutoRepository tipo_ProdutoRepository;

	@GetMapping
	private List<Tipo_Produto> List(){
		
		return tipo_ProdutoRepository.findAll();
	}
	
	
	


	@GetMapping("/{id}")
	public Optional<Tipo_Produto> ListarPorId(@PathVariable("id") Long id) {
		
		return  tipo_ProdutoRepository.findById(id) ;
	}	
    

	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public  Tipo_Produto Adicionar(@Validated @RequestBody Tipo_Produto tipo_Produto) {
		
		return tipo_ProdutoRepository.save(tipo_Produto);
	}
	
	@PutMapping("/{id}")
    public ResponseEntity < Tipo_Produto > Atualizar(@PathVariable(value = "id") Long Id,
        @Validated @RequestBody Tipo_Produto tipo_ProdutoBody) throws ResourceNotFoundException {
    	Tipo_Produto tipo_Produto = tipo_ProdutoRepository.findById(Id)
            .orElseThrow(() -> new ResourceNotFoundException("Tipo_Produto não encontrado para este id -> " + Id));
        
    	
    	tipo_Produto.setTp_Nome(tipo_ProdutoBody.getTp_Nome());
    	
        final Tipo_Produto updatedtipo_Produto = tipo_ProdutoRepository.save(tipo_Produto);
        return ResponseEntity.ok(updatedtipo_Produto);
    }

	
	
    @DeleteMapping("/{id}")
    public Map < String, Boolean > Deletar(@PathVariable(value = "id") Long Id)
    throws ResourceNotFoundException {
    	Tipo_Produto tipo_Produto= tipo_ProdutoRepository.findById(Id)
            .orElseThrow(() -> new ResourceNotFoundException("Tipo_Produto não encontrado para este id -> " + Id));

    	tipo_ProdutoRepository.delete(tipo_Produto);
        Map < String, Boolean > response = new HashMap < > ();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

}
