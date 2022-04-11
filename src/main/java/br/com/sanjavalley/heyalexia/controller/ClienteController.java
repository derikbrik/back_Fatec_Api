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

import br.com.sanjavalley.heyalexia.entities.Cliente;
import br.com.sanjavalley.heyalexia.exception.ResourceNotFoundException;
import br.com.sanjavalley.heyalexia.repository.ClientesRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired 
	private ClientesRepository clienteRepository;
	

	
	@GetMapping
	public List<Cliente> List()	
	{
		
		return clienteRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Optional<Cliente> ListarPorId(@PathVariable("id") Long cliente_id) {
		
		return  clienteRepository.findById(cliente_id) ;
	}	
    
	
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public  Cliente Adicionar(@Validated @RequestBody Cliente cliente) {
		System.out.println(cliente.toString());
		
		return clienteRepository.save(cliente);
	}
	
	@PutMapping("/{id}")
    public ResponseEntity < Cliente > Atualizar(@PathVariable(value = "id") Long cliente_Id,
        @Validated @RequestBody Cliente clienteBody) throws ResourceNotFoundException {
        Cliente cliente = clienteRepository.findById(cliente_Id)
            .orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado para este id -> " + cliente_Id));
        
         System.out.println("Body-> " + cliente.toString());
        cliente.setNome(clienteBody.getNome());
        cliente.setSobrenome(clienteBody.getSobrenome());
        cliente.setEndereco_Id(clienteBody.getEndereco_Id());
        cliente.setClienteEmail(clienteBody.getClienteEmail());
        cliente.setClienteTelefone(clienteBody.getClienteTelefone());
        
        
        final Cliente updatedCliente = clienteRepository.save(cliente);
        return ResponseEntity.ok(updatedCliente);
    }

	
	
    @DeleteMapping("/{id}")
    public Map < String, Boolean > deleteCliente(@PathVariable(value = "id") Long cliente_Id)
    throws ResourceNotFoundException {
        Cliente cliente = clienteRepository.findById(cliente_Id)
            .orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado para este id -> " + cliente_Id));

        clienteRepository.delete(cliente);
        Map < String, Boolean > response = new HashMap < > ();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

    
    
	

	
}
