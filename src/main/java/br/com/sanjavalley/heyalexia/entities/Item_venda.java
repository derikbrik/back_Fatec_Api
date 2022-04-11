package br.com.sanjavalley.heyalexia.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;


@Data
@Entity
@Table(name="ITEM_VENDA")
public class Item_venda {

	 @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long Itv_ID;
	
	 @Column(name="PROD_ID")
	 private Long Prod_Id;
	
	 @Column(name="VENDA_ID")
	 private Long Venda_Id;
	
	 @Column(name="ITV_QUANTIDADE")
	 private Long Itv_Quantidade;
	
	 @Column(name="ITV_VALOR")
	 private Long Itv_Valor;
	
}
