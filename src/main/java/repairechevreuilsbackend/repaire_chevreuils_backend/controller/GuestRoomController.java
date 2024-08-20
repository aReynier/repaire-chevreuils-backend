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
import repairechevreuilsbackend.repaire_chevreuils_backend.model.GuestRoom;
import repairechevreuilsbackend.repaire_chevreuils_backend.repository.GuestRoomRepository;
import repairechevreuilsbackend.repaire_chevreuils_backend.exception.GuestRoomNotFoundException;

@RestController
@Tag(name = "GuestRooms managment", description = "Endpoints for managing guestroom information including room availability, details, and pricing.")
class GuestRoomController {

  private final GuestRoomRepository repository;

  GuestRoomController(GuestRoomRepository repository) {
    this.repository = repository;
  }

  @GetMapping("/guestRooms")
  @Operation(
    summary = "Get list of all Guest rooms",
    description = "Retrieve a list of all available guest rooms of the guest house with their details.",
    tags = {"Admin managment"}
  )
  @ApiResponses(value = {
    @ApiResponse(responseCode = "200", description = "Guest rooms found", content = @Content(mediaType = "application/json")),
    @ApiResponse(responseCode = "404", description = "Guest rooms not found")
  })
  List<GuestRoom> all() {
    return repository.findAll();
  }

  @PostMapping("/guestRooms")
  @Operation(
    summary = "Add a new guest rooms",
    description = "Create a new guest room entry with details such as room type, features, and pricing.",
    tags = {"Admin managment"}
  )
  @ApiResponses(value = {
    @ApiResponse(responseCode = "201", description = "Guest room created successfully", content = @Content(mediaType = "application/json")),
    @ApiResponse(responseCode = "400", description = "Invalid input, guest room invalid"),
    @ApiResponse(responseCode = "409", description = "Conflict, Guest room already exists")
  })
  GuestRoom newGuestRoom(@RequestBody GuestRoom newGuestRoom) {
    return repository.save(newGuestRoom);
  }

  @GetMapping("/guestRooms/{guestRoomId}")
  @Operation(
    summary = "Retrieve Details of a Specific guest room",
    description = "Fetch details of a specific guest room identified by its ID, including information on room type, availability, and pricing.",
    tags = {"Admin managment"}
  )
  @ApiResponses(value = {
    @ApiResponse(responseCode = "200", description = "Guest room found", content = @Content(mediaType = "application/json")),
    @ApiResponse(responseCode = "404", description = "Could not find guest room with id: + guestRoomId")
  })
  GuestRoom one(@PathVariable Long guestRoomId) {
    
    return repository.findById(guestRoomId)
      .orElseThrow(() -> new GuestRoomNotFoundException(guestRoomId));
  }

  @PutMapping("/guestRooms/{guestRoomId}")
  @Operation(
    summary = "Update a guest room",
    description = "Update details of an existing guest room identified by its ID. This includes modifications to room type, features, and pricing.",
    tags = {"Admin managment"}
  )
  @ApiResponses(value = {
    @ApiResponse(responseCode = "200", description = "Guest room updated successfully", content = @Content(mediaType = "application/json")),
    @ApiResponse(responseCode = "400", description = "Invalid input, guest room invalid"),
    @ApiResponse(responseCode = "404", description = "Could not find guest room with id: + bookingId")
  })
  GuestRoom replaceGuestRoom(@RequestBody GuestRoom newGuestRoom, @PathVariable Long guestRoomId) {
    
    return repository.findById(guestRoomId)
      .map(guestRoom -> {
        guestRoom.setName(newGuestRoom.getName());
        guestRoom.setDescription(newGuestRoom.getDescription());
        guestRoom.setSurfaceArea(newGuestRoom.getSurfaceArea());
        guestRoom.setRoomType(newGuestRoom.getRoomType());
        guestRoom.setPictures(newGuestRoom.getPictures());
        guestRoom.setSingleBedNumber(newGuestRoom.getSingleBedNumber());
        guestRoom.setChildBedNumber(newGuestRoom.getChildBedNumber());
        guestRoom.setBabyBedNumber(newGuestRoom.getBabyBedNumber());
        guestRoom.setEquipment(newGuestRoom.getEquipment());
        guestRoom.setPricePerNight(newGuestRoom.getPricePerNight());
        guestRoom.setDisponibility(newGuestRoom.getDisponibility());
        guestRoom.setTouristTax(newGuestRoom.getTouristTax());
        guestRoom.setAdditionnalTax(newGuestRoom.getAdditionnalTax());
        return repository.save(guestRoom);
      })
      .orElseGet(() -> {
        return repository.save(newGuestRoom);
      });
  }

  @DeleteMapping("/guestRooms/{guestRoomId}")
  @Operation(
    summary = "Remove a guest room",
    description = "Delete a guest room entry from the system based on the provided room ID. This operation will permanently remove the room's details.",
    tags = {"Admin managment"}
  )
  @ApiResponses(value = {
    @ApiResponse(responseCode = "204", description = "Guest room deleted successfully"),
    @ApiResponse(responseCode = "404", description = "Could not find guest room with id: + guestRoomId")
  })
  void deleteGuestRoom(@PathVariable Long guestRoomId) {
    repository.deleteById(guestRoomId);
  }
}
