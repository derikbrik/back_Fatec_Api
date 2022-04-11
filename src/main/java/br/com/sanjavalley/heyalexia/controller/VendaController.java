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


import br.com.sanjavalley.heyalexia.entities.Venda;
import br.com.sanjavalley.heyalexia.exception.ResourceNotFoundException;
import br.com.sanjavalley.heyalexia.repository.VendaRepository;

@RestController
@RequestMapping("/vendas")
public class VendaController {

	@Autowired 
	private VendaRepository vendaRepository;

	@GetMapping
	private List<Venda> List(){
		
		return vendaRepository.findAll();
	}
	
	

	@GetMapping("/{id}")
	public Optional<Venda> ListarPorId(@PathVariable("id") Long id) {
		
		return vendaRepository.findById(id) ;
	}	
    

	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public  Venda Adicionar(@Validated @RequestBody Venda venda) {
		
		return vendaRepository.save(venda);
	}
	
	@PutMapping("/{id}")
    public ResponseEntity < Venda > Atualizar(@PathVariable(value = "id") Long Id,
        @Validated @RequestBody Venda vendaBody) throws ResourceNotFoundException {
    	Venda venda = vendaRepository.findById(Id)
            .orElseThrow(() -> new ResourceNotFoundException("Venda não encontrado para este id -> " + Id));
       
    	venda.setVenda_data(vendaBody.getVenda_data());
    	venda.setVenda_Desconto(vendaBody.getVenda_Desconto());
    	venda.setCliente_id(vendaBody.getCliente_id());
    	venda.setVenda_Pagamento_id(vendaBody.getVenda_Pagamento_id());
    	
    	
        final Venda updatedvenda =vendaRepository.save(venda);
        return ResponseEntity.ok(updatedvenda);
    }

	
	
    @DeleteMapping("/{id}")
    public Map < String, Boolean > Deletar(@PathVariable(value = "id") Long Id)
    throws ResourceNotFoundException {
    	Venda venda= vendaRepository.findById(Id)
            .orElseThrow(() -> new ResourceNotFoundException("Venda não encontrado para este id -> " + Id));

    	vendaRepository.delete(venda);
        Map < String, Boolean > response = new HashMap < > ();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

	
	
}
