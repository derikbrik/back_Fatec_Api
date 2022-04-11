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


import br.com.sanjavalley.heyalexia.entities.Item_venda;
import br.com.sanjavalley.heyalexia.exception.ResourceNotFoundException;

import br.com.sanjavalley.heyalexia.repository.Item_vendaRepository;

@RestController
@RequestMapping("/item-venda")
public class Item_vendaController {

	@Autowired 
	private Item_vendaRepository item_vendaRepository;
	
	@GetMapping
	private List<Item_venda> List()
	{
		return item_vendaRepository.findAll();
	}
	
	
	@GetMapping("/{id}")
	public Optional<Item_venda> ListarPorId(@PathVariable("id") Long item_venda_id) {
		
		return  item_vendaRepository.findById(item_venda_id) ;
	}	
    

	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public  Item_venda Adicionar(@Validated @RequestBody Item_venda item_venda) {
		
		return item_vendaRepository.save(item_venda);
	}
	
	@PutMapping("/{id}")
    public ResponseEntity < Item_venda > Atualizar(@PathVariable(value = "id") Long Id,
        @Validated @RequestBody Item_venda item_vendaBody) throws ResourceNotFoundException {
        Item_venda item_venda = item_vendaRepository.findById(Id)
            .orElseThrow(() -> new ResourceNotFoundException("Item não encontrado para este id -> " + Id));
        
        item_venda.setProd_Id(item_vendaBody.getProd_Id());
        item_venda.setVenda_Id(item_vendaBody.getVenda_Id());
        item_venda.setItv_Quantidade(item_vendaBody.getItv_Quantidade());
        item_venda.setItv_Valor(item_vendaBody.getItv_Valor());
        
      
        final Item_venda updatedItem_venda = item_vendaRepository.save(item_venda);
        return ResponseEntity.ok(updatedItem_venda);
    }

	
	
    @DeleteMapping("/{id}")
    public Map < String, Boolean > deleteItem_venda(@PathVariable(value = "id") Long Id)
    throws ResourceNotFoundException {
        Item_venda item_venda= item_vendaRepository.findById(Id)
            .orElseThrow(() -> new ResourceNotFoundException("Item não encontrado para este id -> " + Id));

        item_vendaRepository.delete(item_venda);
        Map < String, Boolean > response = new HashMap < > ();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

    
    
	
	
	
	
	
	
}
