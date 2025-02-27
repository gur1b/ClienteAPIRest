package edu.coderhouse.desafio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.Optional;

//Controller: Encargada de manejar todos los request que reciba la aplicación para la ruta /cliente.
@RestController
@RequestMapping("/cliente")
public class ClienteController {
  @Autowired
  private ClienteService clienteService;

  //Logica del GET
  @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
  public ResponseEntity<?> getClienteById(@PathVariable(name = "id") Long id) {
    Optional<ClienteDTO> cliente = clienteService.obtenerClientePorIdDTO(id);
    if(cliente.isPresent()){
      return ResponseEntity.ok(cliente);
    }else{
      return ResponseEntity.notFound().build();
    }
  }
  //Logica del POST
  @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
  public ResponseEntity<?> guardarCliente(@RequestBody Cliente cliente) {
    try {
      Cliente clienteGuardado =  clienteService.crearCliente(cliente);
      return ResponseEntity.created(URI.create("")).body(clienteGuardado);
    } catch (Exception e) {
      e.printStackTrace();
      return ResponseEntity.internalServerError().body(null);
    }
  }}
