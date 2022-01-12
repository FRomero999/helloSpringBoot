/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/RestController.java to edit this template
 */
package com.cesur.helloSpringBoot;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import models.Tarea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;

/**
 *
 * @author FranciscoRomeroGuill
 */
@RestController
@RequestMapping("/biblioteca")
public class TareaRestController {

    @Autowired
    private TareaRepository repositorio;

    @GetMapping()
    public List<models.Tarea> list() {
        return repositorio.findAll();
    }

    @GetMapping("/{id}")
    public models.Tarea get(@PathVariable Long id) {
        return repositorio.getById(id);
    }      
    
    @PostMapping
    public models.Tarea update(@ModelAttribute Tarea input) {
        System.out.println("post");
        System.out.println(input);
        repositorio.save(input);
        return input;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<models.Tarea> delete(@PathVariable Long id) {

        if (repositorio.existsById(id)) {
            Tarea borrada = repositorio.getById(id);
            repositorio.deleteById(id);
            return new ResponseEntity<Tarea>(borrada, HttpStatus.ACCEPTED);

        }else{
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Error message")
    public void handleError() {
    }

}
