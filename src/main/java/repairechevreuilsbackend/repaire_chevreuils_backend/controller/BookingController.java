package repairechevreuilsbackend.repaire_chevreuils_backend.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import repairechevreuilsbackend.repaire_chevreuils_backend.model.Booking;
import repairechevreuilsbackend.repaire_chevreuils_backend.repository.BookingRepository;
import repairechevreuilsbackend.repaire_chevreuils_backend.exception.BookingNotFoundException;

@RestController
public class BookingController {
    
  private final BookingRepository repository;

  BookingController(BookingRepository repository) {
    this.repository = repository;
  }

  @GetMapping("/bookings")
  List<Booking> all() {
    return repository.findAll();
  }

  @PostMapping("/bookings")
  Booking newBooking(@RequestBody Booking newBooking) {
    return repository.save(newBooking);
  }

  @GetMapping("/bookings/{bookingId}")
  Booking one(@PathVariable Long bookingId) {
    
    return repository.findById(bookingId)
      .orElseThrow(() -> new BookingNotFoundException(bookingId));
  }

  @PutMapping("/bookings/{bookingId}")
  Booking replaceBooking(@RequestBody Booking newBooking, @PathVariable Long bookingId) {
    
    return repository.findById(bookingId)
      .map(booking -> {
        booking.setArrivalDate(newBooking.getArrivalDate());
        booking.setDepartureDate(newBooking.getDepartureDate());
        booking.setArrivalHour(newBooking.getArrivalHour());
        booking.setIsLateDeparture(newBooking.getIsLateDeparture());
        booking.setReservationStatus(newBooking.getReservationStatus());
        booking.setPaymentStatus(newBooking.getPaymentStatus());
        booking.setAmountPaid(newBooking.getAmountPaid());
        booking.setAdultNumber(newBooking.getAdultNumber());
        booking.setCouplesAmongAdults(newBooking.getCouplesAmongAdults());
        booking.setChildNumber(newBooking.getChildNumber());
        booking.setBabyNumber(newBooking.getBabyNumber());
        booking.setAnimalType(newBooking.getAnimalType());
        booking.setAnimalNote(newBooking.getAnimalNote());
        booking.setIsBreakfast(newBooking.getIsBreakfast());
        booking.setIsLunch(newBooking.getIsLunch());
        booking.setIsDiner(newBooking.getIsDiner());
        booking.setGuestNote(newBooking.getGuestNote());
        booking.setAdminNote(newBooking.getAdminNote());
        return repository.save(booking);
      })
      .orElseGet(() -> {
        return repository.save(newBooking);
      });
  }

  @DeleteMapping("/bookings/{bookingId}")
  void deleteBooking(@PathVariable Long bookingId) {
    repository.deleteById(bookingId);
  }
}

