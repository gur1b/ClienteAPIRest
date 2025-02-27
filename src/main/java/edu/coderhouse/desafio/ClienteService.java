package edu.coderhouse.desafio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.Optional;

//Capa de lógica
@Service
public class ClienteService {

  @Autowired
  private ClienteRepository clienteRepository;

  public Cliente crearCliente(Cliente cliente) {
    return clienteRepository.save(cliente);
  }

  public Optional<Cliente> buscarClienteById(Long idCliente) {
    return clienteRepository.findById(idCliente);


  }

  public int calculoEdad(LocalDate fecha){
    // Calcular la diferencia entre las dos fechas
    Period periodo = Period.between(fecha, LocalDate.now());

    // Devuelve los años
    return periodo.getYears();
  }

  public Optional<ClienteDTO> obtenerClientePorIdDTO(Long idCliente) { //Uso de un DTO para no modificar el cliente y trabajar de forma sencilla la comunicación con el controller. 
    return buscarClienteById(idCliente)
        .map(cliente -> new ClienteDTO(
            cliente.getNombre(),
            cliente.getApellido(),
            calculoEdad(cliente.getFechaNacimiento())
        ));
  }
}

