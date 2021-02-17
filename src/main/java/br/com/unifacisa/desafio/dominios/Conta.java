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
@Table(name = "conta")
public class Conta implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id_conta")
	private Integer id;
	
	private double saldo;
	
	@Column(name = "limite_saque_diario")
	private double limiteSaqueDiario;
	
	@Column(name = "flag_ativo")
	private boolean flagAtivo;
	
	@Column(name = "tipo_conta")
	private Integer tipoConta;
	
	@Column(name = "data_criacao")
	private LocalDate dataCriacao;
	
	@ManyToOne
	@JoinColumn(name="id_pessoa")
	@NotNull(message = "Pessoa não pode ser nula")
	private Pessoa pessoa;
	

}
