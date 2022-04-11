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


import br.com.sanjavalley.heyalexia.entities.Tipo_Pagamento;
import br.com.sanjavalley.heyalexia.exception.ResourceNotFoundException;
import br.com.sanjavalley.heyalexia.repository.Tipo_PagamentoRepository;

@RestController
@RequestMapping("/tipos-pagamentos")
public class Tipo_PagamentoController {

	@Autowired 
	private Tipo_PagamentoRepository tipo_PagamentoRepository;

	@GetMapping
	private List<Tipo_Pagamento> List(){
		
		return tipo_PagamentoRepository.findAll();
	}
	
	

	@GetMapping("/{id}")
	public Optional<Tipo_Pagamento> ListarPorId(@PathVariable("id") Long id) {
		
		return  tipo_PagamentoRepository.findById(id) ;
	}	
    

	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public  Tipo_Pagamento Adicionar(@Validated @RequestBody Tipo_Pagamento tipo_Pagamento) {
		
		return tipo_PagamentoRepository.save(tipo_Pagamento);
	}
	
	@PutMapping("/{id}")
    public ResponseEntity < Tipo_Pagamento > Atualizar(@PathVariable(value = "id") Long Id,
        @Validated @RequestBody Tipo_Pagamento tipo_PagamentoBody) throws ResourceNotFoundException {
    	Tipo_Pagamento tipo_Pagamento = tipo_PagamentoRepository.findById(Id)
            .orElseThrow(() -> new ResourceNotFoundException("Tipo_Pagamento não encontrado para este id -> " + Id));
        
    	tipo_Pagamento.setTipo_Pag_Nome(tipo_PagamentoBody.getTipo_Pag_Nome());
    	
        final Tipo_Pagamento updatedtipo_Pagamento = tipo_PagamentoRepository.save(tipo_Pagamento);
        return ResponseEntity.ok(updatedtipo_Pagamento);
    }

	
	
    @DeleteMapping("/{id}")
    public Map < String, Boolean > Deletar(@PathVariable(value = "id") Long Id)
    throws ResourceNotFoundException {
    	Tipo_Pagamento tipo_Pagamento= tipo_PagamentoRepository.findById(Id)
            .orElseThrow(() -> new ResourceNotFoundException("Tipo_Pagamento não encontrado para este id -> " + Id));

    	tipo_PagamentoRepository.delete(tipo_Pagamento);
        Map < String, Boolean > response = new HashMap < > ();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

    
    
	
	
	
	
	
	
	
}
