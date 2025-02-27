package edu.coderhouse.desafio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Capa de datos: Se conecta a la DB
@Repository
public interface ClienteRepository extends JpaRepository<Cliente,Long>
{
}
