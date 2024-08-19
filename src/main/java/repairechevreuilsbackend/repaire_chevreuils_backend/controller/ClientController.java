package repairechevreuilsbackend.repaire_chevreuils_backend.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import repairechevreuilsbackend.repaire_chevreuils_backend.model.Client;
import repairechevreuilsbackend.repaire_chevreuils_backend.repository.ClientRepository;
import repairechevreuilsbackend.repaire_chevreuils_backend.exception.ClientNotFoundException;

@RestController
class ClientController {

  private final ClientRepository repository;

  ClientController(ClientRepository repository) {
    this.repository = repository;
  }

  @GetMapping("/clients")
  List<Client> all() {
    return repository.findAll();
  }

  @PostMapping("/clients")
  Client newClient(@RequestBody Client newClient) {
    return repository.save(newClient);
  }

  @GetMapping("/clients/{clientId}")
  Client one(@PathVariable Long clientId) {
    
    return repository.findById(clientId)
      .orElseThrow(() -> new ClientNotFoundException(clientId));
  }

  @PutMapping("/clients/{clientId}")
  Client replaceClient(@RequestBody Client newClient, @PathVariable Long clientId) {
    
    return repository.findById(clientId)
      .map(client -> {
        client.setFirstName(newClient.getFirstName());
        client.setLastName(newClient.getLastName());
        client.setEmail(newClient.getEmail());
        client.setPhoneNumber(newClient.getPhoneNumber());
        client.setAddressFirstLine(newClient.getAddressFirstLine());
        client.setAddressComplement(newClient.getAddressComplement());
        client.setAddressZipCode(newClient.getAddressZipCode());
        client.setAddressCity(newClient.getAddressCity());
        client.setAddressCountry(newClient.getAddressCountry());
        return repository.save(client);
      })
      .orElseGet(() -> {
        return repository.save(newClient);
      });
  }

  @DeleteMapping("/clients/{clientId}")
  void deleteClient(@PathVariable Long clientId) {
    repository.deleteById(clientId);
  }
}
