package com.laboratorios.api.controller;

import com.laboratorios.api.models.CarrerasModels;
import com.laboratorios.api.models.LaboratoriosModels;
import com.laboratorios.api.repository.CarrerasRepository;
import com.laboratorios.api.repository.LaboratoriosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class EndpointsControllers {

    @Autowired
    private LaboratoriosRepository laboratoriosRepository;

    @Autowired
    private CarrerasRepository carrerasRepository;

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


}
