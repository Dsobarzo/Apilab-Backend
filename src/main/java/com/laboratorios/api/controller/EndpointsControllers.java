package com.laboratorios.api.controller;

import com.laboratorios.api.models.CarrerasModels;
import com.laboratorios.api.models.LaboratoriosModels;
import com.laboratorios.api.models.ProfesoresModels;
import com.laboratorios.api.models.ReservasModels;
import com.laboratorios.api.repository.CarrerasRepository;
import com.laboratorios.api.repository.LaboratoriosRepository;
import com.laboratorios.api.repository.ProfesoresRepository;
import com.laboratorios.api.repository.ReservasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
public class EndpointsControllers {

    @Autowired
    private LaboratoriosRepository laboratoriosRepository;

    @Autowired
    private CarrerasRepository carrerasRepository;

    @Autowired
    private ProfesoresRepository profesoresRepository;

    @Autowired
    private ReservasRepository reservasRepository;

    @GetMapping(path = "/api")
    public String estadoserver(){
        return "Server backend laboratorios responde";

    }
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(path = "/obtenerlaboratorios")
    public List<LaboratoriosModels> obtenerlaboratorio(){

        return laboratoriosRepository.findAll();
    }

    @PostMapping(path = "guardarlaboratorio")
    public String guardarlaboratorio(@RequestBody LaboratoriosModels guardar){
        laboratoriosRepository.save(guardar);
        return "Laboratorio Guardado con Exito!!!";
    }

    @PutMapping(path = "modificarlaboratorio/{id}")
    public String modificarlaboratorio(@PathVariable long id, @RequestBody LaboratoriosModels modificar){
        LaboratoriosModels modificado = laboratoriosRepository.findById(id).get();
        modificado.setNombre(modificar.getNombre());
        modificado.setUbicacion(modificar.getUbicacion());
        modificado.setCapacidad(modificar.getCapacidad());
        laboratoriosRepository.save(modificado);
        return "Laboratorio:" + id + " Modificado con Exito!!";
    }

    @DeleteMapping(path = "borrarlaboratorio/{id}")
    public String borrarlaboratorio(@PathVariable long id){
        LaboratoriosModels borrado = laboratoriosRepository.findById(id).get();
        laboratoriosRepository.delete(borrado);
        return "Laboratorio:" + id + " Borrado con Exito!!" ;
    }
    //#################### EndPoint Carreras #############################

    @GetMapping(path = "/obtenercarreras")
    public List<CarrerasModels> obtenercarreras(){
        return carrerasRepository.findAll();
    }

    @PostMapping(path = "/guardarcarrera")
    public String guardarcarrera(@RequestBody CarrerasModels guardar){
        carrerasRepository.save(guardar);
        return "Carrera Guardada Con Exito!!!";
    }

    @PutMapping(path = "modificarcarrera/{id}")
    public String modificarcarrera(@PathVariable long id, @RequestBody CarrerasModels modificar){
        CarrerasModels modificado = carrerasRepository.findById(id).get();
        modificado.setCarrera(modificar.getCarrera());
        carrerasRepository.save(modificado);
        return "Carrera:"+ id +" Modificada con Exito!!!";
    }

    @DeleteMapping(path = "borrarcarrera/{id}")
    public String borrarcarrera(@PathVariable long  id){
        CarrerasModels borrado = carrerasRepository.findById(id).get();
        carrerasRepository.delete(borrado);
        return "Carrera:"+ id + "Borrada con Exito!!";
    }

    //############################# EndPoint Profesores ########################################
    @GetMapping(path = "/obtenerprofesores")
    public List<ProfesoresModels> obtenerprofesores(){
        return profesoresRepository.findAll();
    }

    @PostMapping(path = "/guardarprofesor")
    public String guardarprofesor(@RequestBody ProfesoresModels guardar){
        profesoresRepository.save(guardar);
        return "Profesor Guardado Con Exito!!!";
    }

    @PutMapping(path = "modificarprofesor/{id}")
    public String modificarprofesor(@PathVariable long id, @RequestBody ProfesoresModels modificar){
        ProfesoresModels modificado = profesoresRepository.findById(id).get();
        modificado.setNombre(modificar.getNombre());
        modificado.setApellido(modificar.getApellido());
        modificado.setEmail(modificar.getEmail());
        modificado.setId_carrera(modificar.getId_carrera());
        profesoresRepository.save(modificado);
        return "Profesor:"+ id +" Modificada con Exito!!!";
    }

    @DeleteMapping(path = "borrarprofesor/{id}")
    public String borrarprofesor(@PathVariable long  id){
        ProfesoresModels borrado = profesoresRepository.findById(id).get();
        profesoresRepository.delete(borrado);
        return "Profesor:"+ id + "Borrada con Exito!!";
    }

    //################################## EndPoint Reservas ###############################

    @GetMapping(path = "/obtenerreservas")
    public List<ReservasModels> obtenerreservas(){return reservasRepository.findAll();
    }

    @PostMapping(path = "guardarreserva")
    public String guardarreserva(@RequestBody ReservasModels guardar){
        reservasRepository.save(guardar);
        return "Reserva Guardada con exito !!";
    }

    @PutMapping(path = "modificarreserva/{id}")
    public String modificarreserva(@PathVariable long id, @RequestBody ReservasModels modificar){
        ReservasModels modificado = reservasRepository.findById(id).get();
        modificado.setId_laboratorios(modificar.getId_laboratorios());
        modificado.setId_profesores(modificar.getId_profesores());
        modificado.setFecha_reserva(modificar.getFecha_reserva());
        modificado.setBloque(modificar.getBloque());
        modificado.setEstado(modificar.getEstado());
        reservasRepository.save(modificado);
        return "Reserva:"+ id +" Modificada con Exito!!!";
    }

    @GetMapping(path = "/obtenerreserva/fecha")
    public List<ReservasModels> obtenerporfecha(@RequestParam ("fecha") @DateTimeFormat(pattern = "yyyy-mm-dd")LocalDate fecha){
        List<ReservasModels> resultados = reservasRepository.findAll();
        return reservasRepository.findAll();
    }



}
