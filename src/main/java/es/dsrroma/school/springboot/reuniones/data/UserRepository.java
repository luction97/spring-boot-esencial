package es.dsrroma.school.springboot.reuniones.data;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.dsrroma.school.springboot.reuniones.models.Usuario;


@Repository
public interface UserRepository extends JpaRepository<Usuario, Long> {

    Usuario findByUsername(String username);

}




