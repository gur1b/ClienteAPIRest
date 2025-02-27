package edu.coderhouse.desafio;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "CLIENTE")
public class Cliente {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getApellido() {
    return apellido;
  }

  public void setApellido(String apellido) {
    this.apellido = apellido;
  }

  @Column(name = "NOMBRE")
  private String nombre;

  @Column(name = "APELLIDO")
  private String apellido;

  //Tipo: "YYYY-MM-DD"
  @Column(name = "FECHA_NACIMIENTO")
  private LocalDate fechaNacimiento;

  public Cliente(){}
  public Cliente(String nombre, String apellido, LocalDate fecha) {
    this.nombre = nombre;
    this.apellido = apellido;
    this.fechaNacimiento = fecha;
  }

  public LocalDate getFechaNacimiento() {
    return fechaNacimiento;
  }

  public void setFechaNacimiento(LocalDate fechaNacimiento) {
    this.fechaNacimiento = fechaNacimiento;
  }
}