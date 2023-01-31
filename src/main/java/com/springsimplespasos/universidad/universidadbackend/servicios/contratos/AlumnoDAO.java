package com.springsimplespasos.universidad.universidadbackend.servicios.contratos;

import com.springsimplespasos.universidad.universidadbackend.modelo.entidades.Persona;


public interface AlumnoDAO extends PersonaDAO{   //DAO = Data Acces Object. Es donde están los métodos para el acceso a nuestros datos en la db

    Iterable<Persona> buscarAlumnosPorNombreCarrera(String nombre);

}
