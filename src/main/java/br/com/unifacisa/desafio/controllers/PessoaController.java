package br.com.unifacisa.desafio.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.unifacisa.desafio.dominios.Pessoa;
import br.com.unifacisa.desafio.servicos.PessoaServico;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

	@Autowired
	private PessoaServico pessoaServico;
	
	@GetMapping
	public ResponseEntity<List<Pessoa>> listar(){
		return ResponseEntity.ok(pessoaServico.listar());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Pessoa> buscarPessoa(@PathVariable Integer id){
		return ResponseEntity.ok(pessoaServico.buscarPessoa(id));
	}
	
	@PostMapping
	public ResponseEntity<Pessoa> salvarPessoa(@RequestBody Pessoa pessoa){
		return ResponseEntity.status(HttpStatus.CREATED).body(pessoaServico.salvar(pessoa));
	}
	
	
	
}
