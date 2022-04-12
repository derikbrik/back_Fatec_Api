package br.com.sanjavalley.heyalexia.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;


@Data
@Entity
@Table(name="CLIENTE")
public class Cliente {
	
	 @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long Cliente_Id;
	
	 @Column(name="CLIENTE_NOME")
	 private String Nome;
	 
	 @Column(name="CLIENTE_SOBRENOME")
	 private String Sobrenome;
	
	 @Column(name="CLIENTE_TELEFONE")
	 private String ClienteTelefone;
	
	 
	 @Column(name="CLIENTE_EMAIL")
	 private String ClienteEmail;
	 
	 @ManyToOne(optional = true)
	 @JoinColumn(name= "Endereco_id", referencedColumnName= "Enderece_Id", nullable  =true)
	 private Endereco endereco;
	 
	 @Column(name="ENDERECO_ID")
	 private Long Endereco_Id;
	 
	 
}
