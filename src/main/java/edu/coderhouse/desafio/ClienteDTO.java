package edu.coderhouse.desafio;

public class ClienteDTO {
  private String nombre;
  private String apellido;
  private int años;

  public ClienteDTO(String nombre, String apellido, int años) {
    this.nombre = nombre;
    this.apellido = apellido;
    this.años = años;
  }

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

  public int getAños() {
    return años;
  }

  public void setAños(int años) {
    this.años = años;
  }

  }