package com.springsimplespasos.universidad.universidadbackend.repositorios;

import com.springsimplespasos.universidad.universidadbackend.modelo.entidades.Carrera;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
//import org.springframework.stereotype.Repository;

//@Repository no es necesario, ya que spring lo identifica automáticamente al extender de CrudRepository o los otros dos Repository de spring, dejando nuestro CarreraRepository como un bean llamado carreraRepository por defecto
//@Repository("carreraRepo") pero si sería necesario si quisiéramos definirle un qualifier a este bean
public interface CarreraRepository extends CrudRepository<Carrera, Integer> {

    //A continuación se generarán métodos equivalentes a las querys que están comentadas justo arriba

    //@Query("select c from Carrera c where c.nombre like %?1%")
    Iterable<Carrera> findCarrerasByNombreContains(String nombre);

    //@Query("select c from Carrera c where upper(c.nombre) like upper(%?1%)")
    Iterable<Carrera> findCarrerasByNombreContainsIgnoreCase(String nombre);

    //@Query("select c from Carrera c where c.cantidadAnios > ?1")
    Iterable<Carrera> findCarrerasByCantidadAniosAfter(Integer cantidadAnios);  //Buscar carreras por cantidad de años mayor que

}
