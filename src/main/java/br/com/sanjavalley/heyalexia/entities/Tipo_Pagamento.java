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
@Table(name="TIPO_PAGAMENTO")
public class Tipo_Pagamento {

	 @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long Tipo_Pag_Id;
	 
	 @Column(name="TIPO_PAG_NOME")
	 private String Tipo_Pag_Nome;
}
