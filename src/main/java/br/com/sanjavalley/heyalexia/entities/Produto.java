package br.com.sanjavalley.heyalexia.entities;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;


@Data
@Entity
@Table(name="PRODUTO")
public class Produto {

	
	 @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long Prod_id;
	 
	 @Column(name="PROD_NOME")
	 private String Prod_Nome;
	 
	 @Column(name="TP_ID")
	 private Long Tp_id;
	 
	 @Column(name="PROD_VALOR")
	 private BigDecimal Prod_Valor;
	 
	 
}
