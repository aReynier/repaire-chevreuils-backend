package repairechevreuilsbackend.repaire_chevreuils_backend.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

import java.util.Set;

import io.swagger.v3.oas.annotations.media.Schema;

@Entity
@Schema(description = "Represents a booking made by a client for a guestroom.")
public class Booking {
    private @Id
    @Schema(description = "Unique identifier for the booking.", example = "0")
    @GeneratedValue Long bookingId;
    @Schema(description = "client's date of arrival", example = "2024-08-20")
    private LocalDate arrivalDate;
    @Schema(description = "client's date of departure", example = "2024-08-21")
    private LocalDate departureDate;
    @Schema(description = "Scheduled hour of arrival.", example = "16:00")
    private LocalTime arrivalHour;
    @Schema(description = "Indicates if the client opted for a late departure.", example = "true")
    private Boolean isLateDeparture;
    @Schema(description = "Current status of the reservation. Possible values: PENDING, CONFIRMED, CHECKED_IN, CHECKED_OUT, CANCELED_BY_GUEST, CANCELED_BY_HOTEL, NO_SHOW, MODIFIED, COMPLETED", example = "PENDING")
    private ReservationStatus reservationStatus;
    @Schema(description = "Current status of the payment. Possible values: PENDING, PARTIALLY_PAID, PAID, FAILED, REFUNDED", example = "PENDING")
    private PaymentStatus paymentStatus;
    @Schema(description = "Amount paid by the client until now", example = "50.00")
    private double amountPaid;
    @Schema(description = "Number of adult guests included in the booking.", example = "3")
    private int adultNumber;
    @Schema(description = "Number of couples among the adult guests.", example = "1")
    private int couplesAmongAdults;
    @Schema(description = "Number of children included in the booking.", example = "1")
    private int childNumber;
    @Schema(description = "Number of babies included in the booking.", example = "1")
    private int babyNumber;
    @Schema(description = "Number and species of animals accompanying the guests. Species could include DOG, CAT, BIRD, RODENT, OTHER.", example = "[\"DOG\", \"DOG\", \"OTHER\"]")
    private AnimalType[] animalType;
    @Schema(description = "Special notes or considerations regarding the animals.", example = "L'un de mes chiens est allergique aux laitages.")
    private String animalNote;
    @Schema(description = "The number of breakfasts the guests will have during their stay. Free option", example = "0")
    private int breakfastNumber;
    @Schema(description = "The number of lunchs the guests will have during their stay. Payment at the end of the stay, separatly from room payment", example = "0")
    private int lunchNumber;
    @Schema(description = "The number of diners the guests will have during their stay. Payment at the end of the stay, separatly from room payment", example = "0")
    private int dinerNumber;
    @Schema(description = "Additional notes provided by the guest.", example = "J'ai une petite tortue avec moi.")
    private String guestNote;
    @Schema(description = "Notes added by the owner regarding the guest or their stay.", example = "Le visiteur a une petite tortue avec lui, prévoir de la salade.")
    private String adminNote;

    @ManyToMany
    @JoinTable(
        name = "booking_guest_room",
        joinColumns = @JoinColumn(name = "booking_id"),
        inverseJoinColumns = @JoinColumn(name = "guest_room_id")
    )
    private Set<GuestRoom> guestRooms = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = true)
    private Client client;

    public Booking() {}

    Booking(LocalDate arrivalDate, LocalDate departureDate, LocalTime arrivalHour,
    Boolean isLateDeparture, ReservationStatus reservationStatus, PaymentStatus paymentStatus,
    double amountPaid, int adultNumber, int couplesAmongAdults, int childNumber, int babyNumber,
    AnimalType[] animalType, String animalNote, int breakfastNumber, int lunchNumber, int dinerNumber,
    String guestNote, String adminNote) {
        this.arrivalDate = arrivalDate;
        this.departureDate = departureDate;
        this.arrivalHour = arrivalHour;
        this.isLateDeparture = isLateDeparture;
        this.reservationStatus = reservationStatus;
        this.paymentStatus = paymentStatus;
        this.amountPaid = amountPaid;
        this.adultNumber = adultNumber;
        this.couplesAmongAdults = couplesAmongAdults;
        this.childNumber = childNumber;
        this.babyNumber = babyNumber;
        this.animalType = animalType;
        this.animalNote = animalNote;
        this.adultNumber = adultNumber;
        this.breakfastNumber = breakfastNumber;
        this.lunchNumber = lunchNumber;
        this.dinerNumber = dinerNumber;
        this.guestNote = guestNote;
        this.adminNote = adminNote;
    }

    public enum AnimalType {
        CAT,
        DOG,
        RODENT,
        BIRD,
        OTHER
    }

    public enum ReservationStatus {
        PENDING,
        CONFIRMED,
        CHECKED_IN,
        CHECKED_OUT,
        CANCELED_BY_GUEST,
        CANCELED_BY_HOTEL,
        NO_SHOW,
        MODIFIED,
        COMPLETED
    }

    public enum PaymentStatus {
        PENDING,
        PARTIALLY_PAID,
        PAID,
        FAILED,
        REFUNDED
    }

    public Long getBookingId() {
        return this.bookingId;
    }

    public LocalDate getArrivalDate() {
        return this.arrivalDate;
    }

    public LocalDate getDepartureDate() {
        return this.departureDate;
    }

    public LocalTime getArrivalHour() {
        return this.arrivalHour;
    }

    public Boolean getIsLateDeparture() {
        return this.isLateDeparture;
    }

    public ReservationStatus getReservationStatus() {
        return this.reservationStatus;
    }

    public PaymentStatus getPaymentStatus() {
        return this.paymentStatus;
    }
    
    public double getAmountPaid() {
        return this.amountPaid;
    }
        
    public int getAdultNumber() {
        return this.adultNumber;
    }
            
    public int getCouplesAmongAdults() {
        return this.couplesAmongAdults;
    }
                
    public int getChildNumber() {
        return this.childNumber;
    }
                    
    public int getBabyNumber() {
        return this.babyNumber;
    }
                        
    public AnimalType[] getAnimalType() {
        return this.animalType;
    }

    public String getAnimalNote() {
        return this.animalNote;
    }
    
    public int getBreakfastNumber() {
        return this.breakfastNumber;
    }
        
    public int getLunchNumber() {
        return this.lunchNumber;
    }
            
    public int getDinerNumber() {
        return this.dinerNumber;
    }
                
    public String getGuestNote() {
        return this.guestNote;
    }

    public String getAdminNote() {
        return this.adminNote;
    }

    public void setBookingId(Long bookingId) {
        this.bookingId = bookingId;
    }
    
    public void setArrivalDate(LocalDate arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }

    public void setArrivalHour(LocalTime arrivalHour) {
        this.arrivalHour = arrivalHour;
    }

    public void setIsLateDeparture(Boolean isLateDeparture) {
        this.isLateDeparture = isLateDeparture;
    }

    public void setReservationStatus(ReservationStatus reservationStatus) {
        this.reservationStatus = reservationStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
    
    public void setAmountPaid(double amountPaid) {
        this.amountPaid = amountPaid;
    }

    public void setAdultNumber(int adultNumber) {
        this.adultNumber = adultNumber;
    }
    
    public void setCouplesAmongAdults(int couplesAmongAdults) {
        this.couplesAmongAdults = couplesAmongAdults;
    }
        
    public void setChildNumber(int childNumber) {
        this.childNumber = childNumber;
    }

    public void setBabyNumber(int babyNumber) {
        this.babyNumber = babyNumber;
    }
    
    public void setAnimalType(AnimalType[] animalType) {
        this.animalType = animalType;
    }
        
    public void setAnimalNote(String animalNote) {
        this.animalNote = animalNote;
    }
            
    public void setBreakfastNumber(int breakfastNumber) {
        this.breakfastNumber = breakfastNumber;
    }
                
    public void setLunchNumber(int lunchNumber) {
        this.lunchNumber = lunchNumber;
    }
                    
    public void setDinerNumber(int dinerNumber) {
        this.dinerNumber = dinerNumber;
    }
                        
    public void setGuestNote(String guestNote) {
        this.guestNote = guestNote;
    }
                            
    public void setAdminNote(String adminNote) {
        this.adminNote = adminNote;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o)
        return true;
        if (!(o instanceof Booking))
        return false;
        Booking booking = (Booking) o;
        return Objects.equals(this.bookingId, booking.bookingId) && Objects.equals(this.arrivalDate, booking.arrivalDate)
            && Objects.equals(this.departureDate, booking.departureDate) && Objects.equals(this.arrivalHour, booking.arrivalHour)
            && Objects.equals(this.isLateDeparture, booking.isLateDeparture) && Objects.equals(this.reservationStatus, booking.reservationStatus)
            && Objects.equals(this.paymentStatus, booking.paymentStatus) && Objects.equals(this.amountPaid, booking.amountPaid)
            && Objects.equals(this.adultNumber, booking.adultNumber) && Objects.equals(this.couplesAmongAdults, booking.couplesAmongAdults)
            && Objects.equals(this.childNumber, childNumber) && Objects.equals(this.babyNumber, booking.babyNumber)
            && Objects.equals(this.animalType, animalType) && Objects.equals(this.animalNote, booking.animalNote)
            && Objects.equals(this.breakfastNumber, breakfastNumber) && Objects.equals(this.lunchNumber, booking.lunchNumber)
            && Objects.equals(this.dinerNumber, dinerNumber) && Objects.equals(this.guestNote, booking.guestNote)
            && Objects.equals(this.adminNote, booking.adminNote);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.bookingId, this.arrivalDate, this.departureDate, this.arrivalHour, this.isLateDeparture, this.reservationStatus,
        this.paymentStatus, this.amountPaid, this.adultNumber, this.couplesAmongAdults, this.childNumber, this.babyNumber, this.animalType, this.animalNote,
        this.breakfastNumber, this.lunchNumber, this.dinerNumber, this.guestNote, this.adminNote );
    }

    @Override
    public String toString() {
        return "Booking{" + "bookingId=" + this.bookingId + ", arrivalDate='" + this.arrivalDate + '\'' + ", departureDate='" + this.departureDate + '\'' + 
        ", arrivalHour='" + this.arrivalHour + '\'' +  ", isLateDeparture='" + this.isLateDeparture + '\'' +  ", reservationStatus='" + this.reservationStatus + '\'' + 
        ", paymentStatus='" + this.paymentStatus + '\'' +  ", amountPaid='" + this.amountPaid + '\'' +  ", adultNumber='" + this.adultNumber + '\'' + 
        ", couplesAmongAdults='" + this.couplesAmongAdults + '\'' +  ", childNumber='" + this.childNumber + '\'' +  ", babyNumber='" + this.babyNumber + '\'' + 
        ", animalType='" + this.animalType + '\'' +  ", animalNote='" + this.animalNote + '\'' +  ", breakfastNumber='" + this.breakfastNumber + '\'' + 
        ", lunchNumber='" + this.lunchNumber + '\'' +  ", dinerNumber='" + this.dinerNumber + '\'' +  ", guestNote='" + this.guestNote + '\'' + ", adminNote='" + this.adminNote + '\'' + '}';
    }
}
