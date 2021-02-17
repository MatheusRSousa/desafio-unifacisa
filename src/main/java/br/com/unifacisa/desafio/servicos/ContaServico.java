package br.com.unifacisa.desafio.servicos;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.unifacisa.desafio.dominios.Conta;
import br.com.unifacisa.desafio.repositorios.ContaRepositorio;

@Service
@Transactional
public class ContaServico {
	
	@Autowired
	private ContaRepositorio contaRepositorio;
	
	public List<Conta> listarContas(){
		return contaRepositorio.findAll();
	}
	
	public Conta buscarConta(Integer id) {
		Conta conta = contaRepositorio.findById(id).orElseThrow(() -> new RuntimeException("Conta não encontrada"));
		return conta;
	}
	
	public double consultarSaldo(Integer id) {
		Conta conta = contaRepositorio.findById(id).orElseThrow(() -> new RuntimeException("Conta não encontrada"));
		
		return conta.getSaldo();
	}
	
	public Conta salvar(Conta conta) {
		conta.setDataCriacao(LocalDate.now());
		return contaRepositorio.save(conta);
	}
	
	public Conta bloquearConta(Integer id) {
		Conta conta = contaRepositorio.findById(id).orElseThrow(() -> new RuntimeException("Conta não existe"));
		
		if(!conta.isFlagAtivo())
			throw new RuntimeException("A conta já está bloqueada!");
		
		conta.setFlagAtivo(false);
		
		return contaRepositorio.save(conta);
	}
	
}
