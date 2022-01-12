/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Repository.java to edit this template
 */
package com.cesur.helloSpringBoot;

import java.util.List;
import javax.persistence.NamedQuery;
import models.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author FranciscoRomeroGuill
 */
public interface TareaRepository extends JpaRepository<Tarea, Long> {

   /* las busquedas directa sobre los atributos ya estan creadas por defecto */
   public List<Tarea> findByResponsable(String name);
   
   /* 
   si queremos personalizar una busqueda personalizada la podemos hacer 
   desde la clase o aqui con la anotación @Query
   https://www.tutorialspoint.com/spring_boot_jpa/spring_boot_jpa_named_queries.htm   
   */
   @Query(value = "SELECT e FROM Tarea e WHERE responsable = ?1")
   public List<Tarea> findByResponsable2(String res);
    
}
