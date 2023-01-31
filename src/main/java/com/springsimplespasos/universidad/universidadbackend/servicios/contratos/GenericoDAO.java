package com.springsimplespasos.universidad.universidadbackend.servicios.contratos;

import com.springsimplespasos.universidad.universidadbackend.modelo.entidades.Carrera;

import java.util.Optional;

public interface GenericoDAO<E> {       //Interfaz que nos permite definir nuestros métodos más comunes, que se usarán en otros DAO's por medio de herencia.    //DAO = Data Acces Object. Es donde están los métodos para el acceso a nuestros datos en la db

    Optional<E> findById(Integer id);   //Buscar un registro por id
    E save(E entidad);                  //Guardar un registro
    Iterable<E> findAll();              //Buscar todos los registros
    void deleteById(Integer id);        //Borrar un registro

}
