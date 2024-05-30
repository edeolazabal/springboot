package com.upc.relaciones;

import com.upc.relaciones.models.*;
import com.upc.relaciones.repository.CursoRepository;
import com.upc.relaciones.repository.EquipoRepository;
import com.upc.relaciones.repository.EstudianteRepository;
import com.upc.relaciones.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class RelacionesApplication /*implements CommandLineRunner */ {
    public static void main(String[] args) {
        SpringApplication.run(RelacionesApplication.class, args);
    }
/*
    @Autowired
    private PersonaRepository personaRepository;
    @Autowired
    private EquipoRepository equipoRepository;
    
    @Autowired
    private CursoRepository cursoRepository;
    
    @Autowired
    private EstudianteRepository estudianteRepository;

    public static void main(String[] args) {
        SpringApplication.run(RelacionesApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        /*
        Persona persona = new Persona("Maria");
        Dni dni = new Dni("67825678", persona);

        persona.setDni((dni));
        personaRepository.save(persona);
        */

      //  personaRepository.findAll().forEach(x -> {
      //      System.out.println(x.getNombre() + " - DNI: "+ x.getDni().getNombre());
      //  });

        // Relacion de uno a muchos
        /*
        Jugador jugador1 = new Jugador("Quispe");
        Jugador jugador2 = new Jugador("Barcos");
        Jugador jugador3 = new Jugador("Valera");
        Jugador jugador4 = new Jugador("Zambrano");

        Equipo equipo1 = new Equipo("Universitario");
        Equipo equipo2 = new Equipo("Alianza");

        jugador1.setEquipo(equipo1);
        jugador3.setEquipo(equipo1);
        jugador2.setEquipo(equipo2);
        jugador4.setEquipo(equipo2);

        List<Jugador> listaJugadores1 = new ArrayList<>();
        listaJugadores1.add(jugador1);
        listaJugadores1.add(jugador3);


        List<Jugador> listaJugadores2 = new ArrayList<>();
        listaJugadores2.add(jugador2);
        listaJugadores2.add(jugador4);

        equipo1.setJugadores(listaJugadores1);
        equipo2.setJugadores(listaJugadores2);

        Equipo eq1 = equipoRepository.save(equipo1);
        Equipo eq2 = equipoRepository.save(equipo2);

        System.out.println(eq1.getDenominacion());
        eq1.getJugadores().forEach(x -> {
            System.out.println("Jugador creado: " + x.getNombre());
        });

        System.out.println(eq2.getDenominacion());
        eq2.getJugadores().forEach(x -> {
            System.out.println("Jugador creado: " + x.getNombre());
        });

         */
        // Relacion de muchos a muchos
        /*
        Estudiante est1 = new Estudiante("Roberto");
        Estudiante est2 = new Estudiante("Rosa");
        
        Curso curso1 = new Curso("AAW");
        Curso curso2 = new Curso("Base de Datos");
        
        cursoRepository.save(curso1);
        cursoRepository.save(curso2);

        List<Curso> cursosEstudiante1 = new ArrayList<>();
        cursosEstudiante1.add(curso1);
        cursosEstudiante1.add(curso2);
        est1.setCursos(cursosEstudiante1);

        List<Curso> cursosEstudiante2 = new ArrayList<>();
        cursosEstudiante2.add(curso2);
        est2.setCursos(cursosEstudiante2);

        estudianteRepository.save(est1);
        estudianteRepository.save(est2);
*/



    }

