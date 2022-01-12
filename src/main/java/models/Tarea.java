/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table(name="tarea")
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Tarea implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    private String nombre;
    private String prioridad;
    private String responsable;  
}

