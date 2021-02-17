package br.com.unifacisa.desafio.dominios;

import java.io.Serializable;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "pessoa")
public class Pessoa implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id_pessoa")
	private Integer id;
	
	
	private String nome;
	
	@NotNull(message = "Cpf não pode ser nulo")
	@Column(unique = true)
	private String cpf;
	
	@Column(name = "data_nascimento")
	private Date dataNascimento; 
}
