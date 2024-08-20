package repairechevreuilsbackend.repaire_chevreuils_backend.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import repairechevreuilsbackend.repaire_chevreuils_backend.model.Booking;
import repairechevreuilsbackend.repaire_chevreuils_backend.repository.BookingRepository;
import repairechevreuilsbackend.repaire_chevreuils_backend.exception.BookingNotFoundException;

@RestController
@Tag(name = "Booking operations", description = "Endpoints for handling room reservations, booking modifications, and cancellations.")
public class BookingController {
    
  private final BookingRepository repository;

  BookingController(BookingRepository repository) {
    this.repository = repository;
  }

  @GetMapping("/bookings")
  @Operation(
    summary = "Retrieve All Bookings",
    description = "Retireve a list of all bookings, including details such as booking ID, client information, room details, and booking status.",
    tags = {"Admin managment"}
  )
  @ApiResponses(value = {
    @ApiResponse(responseCode = "200", description = "Bookings found", content = @Content(mediaType = "application/json")),
    @ApiResponse(responseCode = "404", description = "Bookings not found")
  })
  List<Booking> all() {
    return repository.findAll();
  }

  @PostMapping("/bookings")
  @Operation(
    summary = "Create a New Booking",
    description = "Add a new booking entry to the system. Include details such as client ID, room ID, booking dates, and any special requests.",
    tags = {"Admin managment"}
  )
  @ApiResponses(value = {
    @ApiResponse(responseCode = "201", description = "Booking created successfully", content = @Content(mediaType = "application/json")),
    @ApiResponse(responseCode = "400", description = "Invalid input, booking invalid"),
    @ApiResponse(responseCode = "409", description = "Conflict, booking already exists")
  })
  ResponseEntity<?> newBooking(@RequestBody Booking newBooking) {
    try {
      Booking savedBooking = repository.save(newBooking);
      return ResponseEntity.status(HttpStatus.CREATED).body(savedBooking);
    } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error creating booking: " + e.getMessage());
    }
  }

  @GetMapping("/bookings/{bookingId}")
  @Operation(
    summary = "Retrieve Details of a Specific Booking",
    description = "Get detailed information for a specific booking identified by its ID. Includes details on client, room, dates, and booking status.",
    tags = {"Admin managment"}
  )
  @ApiResponses(value = {
    @ApiResponse(responseCode = "200", description = "Booking found", content = @Content(mediaType = "application/json")),
    @ApiResponse(responseCode = "404", description = "Could not find booking with id: + bookingId")
  })
  Booking one(@PathVariable Long bookingId) {
    
    return repository.findById(bookingId)
      .orElseThrow(() -> new BookingNotFoundException(bookingId));
  }

  @PutMapping("/bookings/{bookingId}")
  @Operation(
    summary = "Update an Existing Booking",
    description = "Modify the details of an existing booking identified by its ID. Update information such as room assignment, booking dates, or special requests.",
    tags = {"Admin managment"}
  )
  @ApiResponses(value = {
    @ApiResponse(responseCode = "200", description = "Booking updated successfully", content = @Content(mediaType = "application/json")),
    @ApiResponse(responseCode = "400", description = "Invalid input, booking invalid"),
    @ApiResponse(responseCode = "404", description = "Could not find booking with id: + bookingId")
  })
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
        booking.setBreakfastNumber(newBooking.getBreakfastNumber());
        booking.setLunchNumber(newBooking.getLunchNumber());
        booking.setDinerNumber(newBooking.getDinerNumber());
        booking.setGuestNote(newBooking.getGuestNote());
        booking.setAdminNote(newBooking.getAdminNote());
        return repository.save(booking);
      })
      .orElseGet(() -> {
        return repository.save(newBooking);
      });
  }

  @DeleteMapping("/bookings/{bookingId}")
  @Operation(
    summary = "Cancel a Booking",
    description = "Cancel a booking identified by its ID. This operation will update the booking status to 'canceled' and may involve room availability adjustments.",
    tags = {"Admin managment"}
  )
  @ApiResponses(value = {
    @ApiResponse(responseCode = "204", description = "Booking deleted successfully"),
    @ApiResponse(responseCode = "404", description = "Could not find booking with id: + bookingId")
  })
  void deleteBooking(@PathVariable Long bookingId) {
    repository.deleteById(bookingId);
  }
}

