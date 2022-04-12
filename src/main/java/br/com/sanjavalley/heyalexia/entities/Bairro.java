package br.com.sanjavalley.heyalexia.entities;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Bairro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Bairro_Id;
	
	@Column(name="BAIRRO_NOME")
	private String Bairro_Nome;
	
	@Column(name="CIDADE_ID")
	private Long Cidade_Id;
	
}
