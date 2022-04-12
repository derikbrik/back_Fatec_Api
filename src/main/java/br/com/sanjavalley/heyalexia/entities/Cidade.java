package br.com.sanjavalley.heyalexia.entities;

import javax.persistence.Column;
import javax.persistence.Id;

public class Cidade {

	@Id
	private long Cidade_Id;
		
	@Column(name="CIDADE_NOME")
	private String Cidade_Nome;
	
	@Column(name="EST_ID")
	private long Est_Id;
	
	
	
}
