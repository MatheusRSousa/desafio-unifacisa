package br.com.unifacisa.desafio.dtos;

import java.io.Serializable;
import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExtratoPorPeriodoDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private Integer idConta;
	
	private Date dataInicio;
	
	private Date dataFim;

}
