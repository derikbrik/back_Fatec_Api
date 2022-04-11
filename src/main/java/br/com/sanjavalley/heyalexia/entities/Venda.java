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
@Table(name="VENDA")
public class Venda {
	
	 @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long Venda_Id;
	 
	 @Column(name="CLIENTE_ID")
	 private Long Cliente_id;
	 
	
	 @Column(name="VENDA_DATA")
	 private java.sql.Timestamp Venda_data;
	 
	 @Column(name="VENDA_PAGAMENTO_ID")
	 private Long Venda_Pagamento_id;
	 
	 @Column(name="VENDA_DESCONTO")
	 private BigDecimal Venda_Desconto;
 
}



