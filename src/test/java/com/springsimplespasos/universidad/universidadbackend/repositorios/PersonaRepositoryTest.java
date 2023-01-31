package com.springsimplespasos.universidad.universidadbackend.repositorios;

import com.springsimplespasos.universidad.universidadbackend.datos.DatosDummy;
import com.springsimplespasos.universidad.universidadbackend.modelo.entidades.Empleado;
import com.springsimplespasos.universidad.universidadbackend.modelo.entidades.Persona;
import com.springsimplespasos.universidad.universidadbackend.modelo.entidades.Profesor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static com.springsimplespasos.universidad.universidadbackend.datos.DatosDummy.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class PersonaRepositoryTest {

    @Autowired
    @Qualifier("repositorioAlumnos")
    PersonaRepository alumnoRepository;

    @Autowired
    @Qualifier("empleadoRepository")
    PersonaRepository empleadoRepository;

    @Autowired
    @Qualifier("profesorRepository")
    PersonaRepository profesorRepository;

    @Test
    void buscarPorNombreYApellido() {
        //Given
        Persona save = empleadoRepository.save(empleado01());  //DatosDummy fue extraído de manera estática para no tener que llamarlo cada vez que se quiera guardar uno de sus datos

        //When
        Optional<Persona> expected = empleadoRepository.buscarPorNombreYApellido(empleado01().getNombre(), empleado01().getApellido());

        //Then
        assertThat(expected.get()).isInstanceOf(Empleado.class);
        assertThat(expected.get()).isEqualTo(save);

    }

    @Test
    void buscarPorDni() {
        //Given
        Persona save = profesorRepository.save(profesor01());//DatosDummy fue extraído de manera estática para no tener que llamarlo cada vez

        //When
        Optional<Persona> expected = profesorRepository.buscarPorDni(profesor01().getDni());

        //Then
        assertThat(expected.get()).isInstanceOf(Profesor.class);              //Validamos que la instancia sea de profesor
        assertThat(expected.get()).isEqualTo(save);                     //Validamos que el expected sea igual al guardado
        assertThat(expected.get().getDni()).isEqualTo(save.getDni());   //validamos que el dni del expected sea igual al dni del guardado

    }

    @Test
    void buscarPersonaPorApellido() {
        //Given
        Iterable<Persona> personas = alumnoRepository.saveAll(
                Arrays.asList(
                        alumno01(),
                        alumno02(),
                        alumno03()
        ));

        //When
        String apellido= "Benitez";
        List<Persona> expected = (List<Persona>) alumnoRepository.buscarPersonaPorApellido(apellido);   //Se castea a lista acá para no tener que hacer el casteo en el assertThat

        //Then
        assertThat(expected.size() == 2).isTrue();

    }
}