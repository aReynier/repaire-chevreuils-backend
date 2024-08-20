package repairechevreuilsbackend.repaire_chevreuils_backend.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import repairechevreuilsbackend.repaire_chevreuils_backend.model.GuestRoom;
import repairechevreuilsbackend.repaire_chevreuils_backend.repository.GuestRoomRepository;
import repairechevreuilsbackend.repaire_chevreuils_backend.exception.GuestRoomNotFoundException;

@RestController
class GuestRoomController {

  private final GuestRoomRepository repository;

  GuestRoomController(GuestRoomRepository repository) {
    this.repository = repository;
  }

  @GetMapping("/guestRooms")
  List<GuestRoom> all() {
    return repository.findAll();
  }

  @PostMapping("/guestRooms")
  GuestRoom newGuestRoom(@RequestBody GuestRoom newGuestRoom) {
    return repository.save(newGuestRoom);
  }

  @GetMapping("/guestRooms/{guestRoomId}")
  GuestRoom one(@PathVariable Long guestRoomId) {
    
    return repository.findById(guestRoomId)
      .orElseThrow(() -> new GuestRoomNotFoundException(guestRoomId));
  }

  @PutMapping("/guestRooms/{guestRoomId}")
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
  void deleteGuestRoom(@PathVariable Long guestRoomId) {
    repository.deleteById(guestRoomId);
  }
}
