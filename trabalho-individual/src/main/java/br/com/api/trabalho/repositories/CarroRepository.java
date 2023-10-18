package br.com.api.trabalho.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.api.trabalho.entities.Carro;

@Repository
public interface CarroRepository extends JpaRepository<Carro, Integer>{

}
