package repairechevreuilsbackend.repaire_chevreuils_backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import repairechevreuilsbackend.repaire_chevreuils_backend.model.Admin;
import repairechevreuilsbackend.repaire_chevreuils_backend.repository.AdminRepository;
import repairechevreuilsbackend.repaire_chevreuils_backend.exception.AdminNotFoundException;

@RestController
@Tag(name = "Admin dashboard", description = "Endpoints for managing administrative functions such as booking management and guestrooms managment.")
class AdminController {

  private final AdminRepository repository;

  AdminController(AdminRepository repository) {
    this.repository = repository;
  }

  @PostMapping("/admins")
  @Operation(
    summary = "Admin Login",
    description = "Authenticate the admin user with email and password."
  )
  @ApiResponses(value = {
    @ApiResponse(responseCode = "201", description = "Admin created successfully", content = @Content(mediaType = "application/json")),
    @ApiResponse(responseCode = "400", description = "Invalid input, admin invalid"),
    @ApiResponse(responseCode = "409", description = "Conflict, admin already exists")
  })
  Admin loginAdmin() {
    System.out.println("Admin login endpoint is currently in development.");
    return new Admin();
  }

  @GetMapping("/admins/{adminId}")
  @Operation(
    summary = "Retrieve Admin Information",
    description = "Fetch details of the admin user including their email. This endpoint is for display purposes only and should be protected."
  )
  @ApiResponses(value = {
    @ApiResponse(responseCode = "200", description = "Admin found", content = @Content(mediaType = "application/json")),
    @ApiResponse(responseCode = "404", description = "Could not find admin with id: + adminId")
  })
  Admin one(@PathVariable Long adminId) {
    
    return repository.findById(adminId)
      .orElseThrow(() -> new AdminNotFoundException(adminId));
  }
}
