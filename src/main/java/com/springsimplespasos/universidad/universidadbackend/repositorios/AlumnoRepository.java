package com.springsimplespasos.universidad.universidadbackend.repositorios;

import com.springsimplespasos.universidad.universidadbackend.modelo.entidades.Persona;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository("repositorioAlumnos")   //Qualifier usado en AlumnoDAOImpl
public interface AlumnoRepository extends PersonaRepository{

    //@Query("select a from Alumno a join fetch a.carrera c where a.carrera.nombre = ?1")   //Esta query se agregó en vídeo 51 min. 12 para arreglar un error relacionado al Lazy de la clase Alumno, pero a nosotros no nos dió ese error, de no could not initialize proxy [...] - no Session
    @Query("select a from Alumno a where a.carrera.nombre = ?1")
    Iterable<Persona> buscarAlumnosPorNombreCarrera(String nombre);

}
