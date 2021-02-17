package com.rafaelsantiago.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rafaelsantiago.cursomc.domain.enums.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente,Integer> {
}
