package br.com.unifacisa.desafio.dominios;


import java.io.Serializable;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "transacao")
public class Transacao implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_transacao")
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "idConta")
	@NotNull(message = "Conta não pode ser nula")
	private Conta conta;
	
	private double valor;
	
	@Column(name = "data_transacao")
	private LocalDate dataTransacao;
}
