/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Controller.java to edit this template
 */
package com.cesur.helloSpringBoot;

import java.util.Date;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author FranciscoRomeroGuill
 */
@Controller
public class TareaController {

    @Autowired
    private TareaRepository repositorio;
    
    @RequestMapping("/web")
    public String main(Model model) {
        model.addAttribute("tareas", repositorio.findAll() );
        return "listado-tareas";
    }

    @RequestMapping("/web/responsable/{responsable}")
    public String responsable(@PathVariable String responsable, Model model) {
        model.addAttribute("tareas", repositorio.findByResponsable2(responsable));
        return "listado-tareas";
    }    
    
    @RequestMapping("/web/{id}")
    public String one(@PathVariable Long id, Model model) {
        model.addAttribute("tarea", repositorio.getById(id) );
        model.addAttribute("fecha", new Date() );
        return "tarea";
    }
    
    
}
