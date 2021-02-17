package br.com.unifacisa.desafio.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.unifacisa.desafio.dominios.Conta;

@Repository
public interface ContaRepositorio extends JpaRepository<Conta, Integer>{

}
