package repairechevreuilsbackend.repaire_chevreuils_backend.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import repairechevreuilsbackend.repaire_chevreuils_backend.model.Admin;
import repairechevreuilsbackend.repaire_chevreuils_backend.repository.AdminRepository;
import repairechevreuilsbackend.repaire_chevreuils_backend.exception.AdminNotFoundException;

@RestController
class AdminController {

  private final AdminRepository repository;

  AdminController(AdminRepository repository) {
    this.repository = repository;
  }

  @GetMapping("/admins")
  List<Admin> all() {
    return repository.findAll();
  }

  @PostMapping("/admins")
  Admin newAdmin(@RequestBody Admin newAdmin) {
    return repository.save(newAdmin);
  }

  @GetMapping("/admins/{adminId}")
  Admin one(@PathVariable Long adminId) {
    
    return repository.findById(adminId)
      .orElseThrow(() -> new AdminNotFoundException(adminId));
  }

  @PutMapping("/admins/{adminId}")
  Admin replaceAdmin(@RequestBody Admin newAdmin, @PathVariable Long adminId) {
    
    return repository.findById(adminId)
      .map(admin -> {
        admin.setEmail(newAdmin.getEmail());
        admin.setPassword(newAdmin.getPassword());
        return repository.save(admin);
      })
      .orElseGet(() -> {
        return repository.save(newAdmin);
      });
  }

  @DeleteMapping("/admins/{adminId}")
  void deleteAdmin(@PathVariable Long adminId) {
    repository.deleteById(adminId);
  }
}
