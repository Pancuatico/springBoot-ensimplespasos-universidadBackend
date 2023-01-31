package com.springsimplespasos.universidad.universidadbackend.repositorios;


import com.springsimplespasos.universidad.universidadbackend.modelo.entidades.Persona;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

public interface ProfesorRepository extends PersonaRepository{

    /*String myQuery = "select ca.nombre, pr.* from profesores pr " +
            "inner join profesor_carrera pc on pc.profesor_id = pr.persona_id " +
            "inner join carreras ca on ca.id = pc.carrera_id" +
            "where ca.nombre = ?1";*/

    @Query("select p from Profesor p join fetch p.carreras c where c.nombre = ?1")
    Iterable<Persona> findProfesoresByCarrera(String carrera);

}
