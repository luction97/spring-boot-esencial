package es.dsrroma.school.springboot.reuniones.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.dsrroma.school.springboot.reuniones.models.Persona;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long>{

}
