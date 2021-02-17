package br.com.unifacisa.desafio.servicos;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.unifacisa.desafio.dominios.Conta;
import br.com.unifacisa.desafio.dominios.Transacao;
import br.com.unifacisa.desafio.repositorios.TransacaoRepositorio;

@Service
@Transactional
public class TransacaoServico {
	
	@Autowired
	private TransacaoRepositorio repositorio;
	@Autowired
	private ContaServico contaServico;
	
	public List<Transacao> listar(){
		return repositorio.findAll();
	}

	public Transacao depositar(Transacao transacao) {
		Conta conta = contaServico.buscarConta(transacao.getConta().getId());
		
		if(transacao.getValor() < 0)
			throw new RuntimeException("Valor de deposito inválido");
		
		transacao.setDataTransacao(LocalDate.now());
		conta.setSaldo(conta.getSaldo() + transacao.getValor());
		
		contaServico.salvar(conta);
		
		return repositorio.save(transacao);
	}
	
	public Transacao sacar(Transacao transacao) {
		Conta conta = contaServico.buscarConta(transacao.getConta().getId());
		
		if(transacao.getValor() < 0)
			throw new RuntimeException("Valor de saque inválido");
		
		if(conta.getLimiteSaqueDiario() < transacao.getValor())
			throw new RuntimeException("Valor de saque maior que o limite diário");
		
		if(conta.getSaldo() < transacao.getValor())
			throw new RuntimeException("Valor de saque maior que o saldo");
		
		transacao.setDataTransacao(LocalDate.now());
		conta.setSaldo(conta.getSaldo() - transacao.getValor());
		
		contaServico.salvar(conta);
		
		return repositorio.save(transacao);
	}
	
	public List<Transacao> extratoTransacoesPorConta(Integer idConta){
		Conta conta = contaServico.buscarConta(idConta);
		
		return repositorio.findAllByConta(conta);
	}
	
	public List<Transacao> extratoPorPeriodo(Integer idConta, LocalDate dataInicio, LocalDate dataFim){
		Conta conta = contaServico.buscarConta(idConta);
		
		List<Transacao> transacoes = repositorio.findAllByConta(conta);
		
		List<Transacao> transacoesPorPeriodo = new ArrayList<Transacao>();
		
		for (Transacao transacao : transacoes) {
			if(transacao.getDataTransacao().isAfter(dataInicio) 
					&& transacao.getDataTransacao().isBefore(dataFim)) {
				transacoesPorPeriodo.add(transacao);	
			}else if(transacao.getDataTransacao().isEqual(dataInicio) || transacao.getDataTransacao().isEqual(dataFim)) {
				transacoesPorPeriodo.add(transacao);
			}
		}
		
		return transacoesPorPeriodo;
	}
}
