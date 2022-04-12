package br.com.sanjavalley.heyalexia.entities;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Endereco {
	
	 @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long Endereco_Id;
	
	 @Column(name="BAIRRO_ID")
	 private String Bairro_Id;
	 
	 @Column(name="LOGRADOURO")
	 private String Logradouro;
	 
	 @Column(name="ENDERECO_NUMERO")
	 private String Endereco_Numero;
	 
	 @Column(name="ENDERECO_COMPLEMENTO")
	 private String Endereco_Complemento;
	 
	  

}
