package br.com.unifacisa.desafio.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.unifacisa.desafio.dominios.Conta;
import br.com.unifacisa.desafio.servicos.ContaServico;

@RestController
@RequestMapping("/conta")
public class ContaController {

	@Autowired
	private ContaServico contaServico;
	
	@GetMapping
	public ResponseEntity<List<Conta>> listar(){
		return ResponseEntity.ok(contaServico.listarContas());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Conta> buscarConta(@PathVariable Integer id){
		return ResponseEntity.ok(contaServico.buscarConta(id));
	}
	
	@GetMapping("/consultar_saldo/{id}")
	public double consultarSaldo(@PathVariable Integer id){
		return contaServico.consultarSaldo(id);
	}
	
	@PostMapping
	public ResponseEntity<Conta> salvar(@RequestBody Conta conta){
		return ResponseEntity.status(HttpStatus.CREATED).body(contaServico.salvar(conta));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Conta> bloquearConta(@PathVariable Integer id){
		return ResponseEntity.ok(contaServico.bloquearConta(id));
	}
}
