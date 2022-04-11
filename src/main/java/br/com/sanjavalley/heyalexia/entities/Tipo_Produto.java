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
@Table(name="TIPO_PRODUTO")
public class Tipo_Produto {

	
	 @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long TP_Id;
	 
	 
	 @Column(name="TP_NOME")
	 private String Tp_Nome;
	 
}
