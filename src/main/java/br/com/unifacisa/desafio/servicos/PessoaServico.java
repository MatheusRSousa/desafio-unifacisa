package br.com.unifacisa.desafio.servicos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.unifacisa.desafio.dominios.Pessoa;
import br.com.unifacisa.desafio.repositorios.PessoaRepositorio;

@Transactional
@Service
public class PessoaServico {

	@Autowired
	private PessoaRepositorio repositorio;
	
	public List<Pessoa> listar(){
		return repositorio.findAll();
	}
	
	public Pessoa buscarPessoa(Integer id) {
		Pessoa pessoa = repositorio.findById(id)
				.orElseThrow(() -> new RuntimeException("Pessoa não encontrada na base de dados"));
		
		return pessoa;
	}
	
	public Pessoa salvar(Pessoa pessoa) {
		return repositorio.save(pessoa);
	}
	
	
}
