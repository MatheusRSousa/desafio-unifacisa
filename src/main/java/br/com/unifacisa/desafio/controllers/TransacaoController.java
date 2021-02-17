package br.com.unifacisa.desafio.controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.unifacisa.desafio.dominios.Transacao;
import br.com.unifacisa.desafio.servicos.TransacaoServico;

@RestController
@RequestMapping("/transacao")
public class TransacaoController {
	
	@Autowired
	private TransacaoServico transacaoServico;
	
	@GetMapping
	public ResponseEntity<List<Transacao>> listar(){
		return ResponseEntity.ok(transacaoServico.listar());
	}
	
	@GetMapping("/extrato/{idConta}")
	public ResponseEntity<List<Transacao>> extratoTransacoesPorConta(@PathVariable Integer idConta){
		return ResponseEntity.ok(transacaoServico.extratoTransacoesPorConta(idConta));
	}
	
	
	@GetMapping("/extrato/{idConta}/{dataInicio}/{dataFim}")
	public ResponseEntity<List<Transacao>> extratoPorPeriodo(@PathVariable Integer idConta,
			@PathVariable @DateTimeFormat(pattern="yyyy-MM-dd")
			 LocalDate dataInicio, @PathVariable @DateTimeFormat(pattern="yyyy-MM-dd") LocalDate dataFim){
		return ResponseEntity.ok(transacaoServico.extratoPorPeriodo(idConta, dataInicio, dataFim));
	}
	
	@PostMapping("/sacar")
	public ResponseEntity<Transacao> sacar(@RequestBody Transacao transacao){
		return ResponseEntity.ok(transacaoServico.sacar(transacao));
	}
	
	@PostMapping("/depositar")
	public ResponseEntity<Transacao> depositar(@RequestBody Transacao transacao){
		return ResponseEntity.ok(transacaoServico.depositar(transacao));
	}
}
