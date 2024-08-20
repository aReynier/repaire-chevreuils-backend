package repairechevreuilsbackend.repaire_chevreuils_backend.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import repairechevreuilsbackend.repaire_chevreuils_backend.model.Client;
import repairechevreuilsbackend.repaire_chevreuils_backend.repository.ClientRepository;
import repairechevreuilsbackend.repaire_chevreuils_backend.exception.ClientNotFoundException;

@RestController
@Tag(name = "Clients profiles", description = "Endpoints for client-related operations, mainly consultation.")
class ClientController {

  private final ClientRepository repository;

  ClientController(ClientRepository repository) {
    this.repository = repository;
  }

  @GetMapping("/clients")
  @Operation(
    summary = "Retrieve All Client Profiles",
    description = "Retrieve a list of all client profiles, including details such as name, contact information, and registration status.",
    tags = {"Admin managment"}
  )
  @ApiResponses(value = {
    @ApiResponse(responseCode = "200", description = "Clients found", content = @Content(mediaType = "application/json")),
    @ApiResponse(responseCode = "404", description = "Clients not found")
  })
  List<Client> all() {
    return repository.findAll();
  }

  @PostMapping("/clients")
  @Operation(
    summary = "Create a New Client Profile",
    description = "Add a new client profile, including essential details such as name and contact information.",
    tags = {"Admin managment"}
  )
  @ApiResponses(value = {
    @ApiResponse(responseCode = "201", description = "Client created successfully", content = @Content(mediaType = "application/json")),
    @ApiResponse(responseCode = "400", description = "Invalid input, client invalid"),
    @ApiResponse(responseCode = "409", description = "Conflict, client already exists")
  })
  Client newClient(@RequestBody Client newClient) {
    return repository.save(newClient);
  }

  @GetMapping("/clients/{clientId}")
  @Operation(
    summary = "Retrieve a Specific Client Profile",
    description = "Retrieve detailed information for a specific client profile identified by its ID. Includes client’s personal informations.",
    tags = {"Admin managment"}
  )
  @ApiResponses(value = {
    @ApiResponse(responseCode = "200", description = "Client found", content = @Content(mediaType = "application/json")),
    @ApiResponse(responseCode = "404", description = "Could not find client with id: + clientId")
  })
  Client one(@PathVariable Long clientId) {
    
    return repository.findById(clientId)
      .orElseThrow(() -> new ClientNotFoundException(clientId));
  }

  @PutMapping("/clients/{clientId}")
  @Operation(
    summary = "Update a Client Profile",
    description = "Modify the details of an existing client profile identified by its ID. Update information such as name, contact details, and preferences.",
    tags = {"Admin managment"}
  )
  @ApiResponses(value = {
    @ApiResponse(responseCode = "200", description = "Client updated successfully", content = @Content(mediaType = "application/json")),
    @ApiResponse(responseCode = "400", description = "Invalid input, client invalid"),
    @ApiResponse(responseCode = "404", description = "Could not find client with id: + clientId")
  })
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
  @Operation(
    summary = "Delete a Client Profile",
    description = "Remove a client profile from the system based on the provided client ID. This operation will permanently delete the client's information.",
    tags = {"Admin managment"}
  )
  @ApiResponses(value = {
    @ApiResponse(responseCode = "204", description = "Client deleted successfully"),
    @ApiResponse(responseCode = "404", description = "Could not find client with id: + clientId")
  })
  void deleteClient(@PathVariable Long clientId) {
    repository.deleteById(clientId);
  }
}
