package com.springsimplespasos.universidad.universidadbackend.repositorios;

import com.springsimplespasos.universidad.universidadbackend.modelo.entidades.Alumno;
import com.springsimplespasos.universidad.universidadbackend.modelo.entidades.Carrera;
import com.springsimplespasos.universidad.universidadbackend.modelo.entidades.Persona;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Arrays;
import java.util.List;

import static com.springsimplespasos.universidad.universidadbackend.datos.DatosDummy.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class AlumnoRepositoryTest {

    @Autowired
    @Qualifier("repositorioAlumnos")
    PersonaRepository alumnoRepository;

    @Autowired
    CarreraRepository carreraRepository;

    @Test
    void buscarAlumnosPorNombreCarrera() {
        //Given
        Iterable<Persona> personas = alumnoRepository.saveAll(      //Guardo alumnos
                Arrays.asList(
                        alumno01(),
                        alumno02(),
                        alumno03()
                ));

        Carrera save = carreraRepository.save(carrera01(false));         //Guardo una carrera

        personas.forEach(alumno -> ((Alumno)alumno).setCarrera(save));  //A cada alumno le seteo esa carrera. Si no se castea alumno no se podría usar el método setCarrera

        alumnoRepository.saveAll(personas);         //Guardo esos alumnos con esas carreras, asi tenemos asociados los alumnos con las carreras

        //When
        String carreraNombre = "Ingenieria en Sistemas";
        List<Persona> expected = (List<Persona>) ((AlumnoRepository)alumnoRepository).buscarAlumnosPorNombreCarrera(carreraNombre);

        //Then
        assertThat(expected.size() == 3).isTrue();  //Si hay tres personas con la carrera, dará true

    }

    @Test
    void buscarAlumnosPorNombreCarreraSinValores() {
        //Given
        Iterable<Persona> personas = alumnoRepository.saveAll(      //Guardo alumnos
                Arrays.asList(
                        alumno01(),
                        alumno02(),
                        alumno03()
                ));

        Carrera save = carreraRepository.save(carrera01(false));         //Guardo una carrera

        personas.forEach(alumno -> ((Alumno)alumno).setCarrera(save));  //A cada alumno le seteo esa carrera. Si no se castea alumno no se podría usar el método setCarrera

        alumnoRepository.saveAll(personas);         //Guardo esos alumnos con esas carreras, asi tenemos asociados los alumnos con las carreras

        //When
        String carreraNombre = "Ingenieria en Alimentos";
        List<Persona> expected = (List<Persona>) ((AlumnoRepository)alumnoRepository).buscarAlumnosPorNombreCarrera(carreraNombre);

        //Then
        assertThat(expected.isEmpty()).isTrue();    //Si está vacío el expected, dará correcto

    }

}