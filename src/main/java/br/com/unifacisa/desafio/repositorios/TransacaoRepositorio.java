package br.com.unifacisa.desafio.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.unifacisa.desafio.dominios.Conta;
import br.com.unifacisa.desafio.dominios.Transacao;

@Repository
public interface TransacaoRepositorio extends JpaRepository<Transacao, Integer>{

	List<Transacao> findAllByConta(Conta conta); 
}
