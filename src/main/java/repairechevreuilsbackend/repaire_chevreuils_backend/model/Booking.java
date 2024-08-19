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

@Entity
public class Booking {
    private @Id
    @GeneratedValue Long bookingId;

    private LocalDate arrivalDate;
    private LocalDate departureDate;
    private LocalTime arrivalHour;
    private Boolean isLateDeparture;
    private ReservationStatus reservationStatus;
    private PaymentStatus paymentStatus;
    private double amountPaid;
    private int adultNumber;
    private int couplesAmongAdults;
    private int childNumber;
    private int babyNumber;
    private AnimalType[] animalType;
    private String animalNote;
    private Boolean isBreakfast;
    private Boolean isLunch;
    private Boolean isDiner;
    private String guestNote;
    private String adminNote;

    @ManyToMany
    @JoinTable(
        name = "booking_guest_room",
        joinColumns = @JoinColumn(name = "booking_id"),
        inverseJoinColumns = @JoinColumn(name = "guest_room_id")
    )
    private Set<GuestRoom> guestRooms = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    Booking() {}

    Booking(LocalDate arrivalDate, LocalDate departureDate, LocalTime arrivalHour,
    Boolean isLateDeparture, ReservationStatus reservationStatus, PaymentStatus paymentStatus,
    double amountPaid, int adultNumber, int couplesAmongAdults, int childNumber, int babyNumber,
    AnimalType[] animalType, String animalNote, Boolean isBreakfast, Boolean isLunch, Boolean isDiner,
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
        this.isBreakfast = isBreakfast;
        this.isLunch = isLunch;
        this.isDiner = isDiner;
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
                        
    public AnimalType[] getAnimals() {
        return this.animalType;
    }

    public String getAnimalNote() {
        return this.animalNote;
    }
    
    public Boolean getIsBreakfast() {
        return this.isBreakfast;
    }
        
    public Boolean getIsLunch() {
        return this.isLunch;
    }
            
    public Boolean getIsDiner() {
        return this.isDiner;
    }
                
    public String getGuestNote() {
        return this.guestNote;
    }

    public String getAdminNote() {
        return this.adminNote;
    }

    public void setAdminId(Long bookingId) {
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
            
    public void setIsBreakfast(Boolean isBreakfast) {
        this.isBreakfast = isBreakfast;
    }
                
    public void setIsLunch(Boolean isLunch) {
        this.isLunch = isLunch;
    }
                    
    public void setIsDiner(Boolean isDiner) {
        this.isDiner = isDiner;
    }
                        
    public void setGuestNote(String guestNote) {
        this.guestNote = guestNote;
    }
                            
    public void setAdmintNote(String adminNote) {
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
            && Objects.equals(this.isBreakfast, isBreakfast) && Objects.equals(this.isLunch, booking.isLunch)
            && Objects.equals(this.isDiner, isDiner) && Objects.equals(this.guestNote, booking.guestNote)
            && Objects.equals(this.adminNote, booking.adminNote);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.bookingId, this.arrivalDate, this.departureDate, this.arrivalHour, this.isLateDeparture, this.reservationStatus,
        this.paymentStatus, this.amountPaid, this.adultNumber, this.couplesAmongAdults, this.childNumber, this.babyNumber, this.animalType, this.animalNote,
        this.isBreakfast, this.isLunch, this.isDiner, this.guestNote, this.adminNote );
    }

    @Override
    public String toString() {
        return "Booking{" + "bookingId=" + this.bookingId + ", arrivalDate='" + this.arrivalDate + '\'' + ", departureDate='" + this.departureDate + '\'' + 
        ", arrivalHour='" + this.arrivalHour + '\'' +  ", isLateDeparture='" + this.isLateDeparture + '\'' +  ", reservationStatus='" + this.reservationStatus + '\'' + 
        ", paymentStatus='" + this.paymentStatus + '\'' +  ", amountPaid='" + this.amountPaid + '\'' +  ", adultNumber='" + this.adultNumber + '\'' + 
        ", couplesAmongAdults='" + this.couplesAmongAdults + '\'' +  ", childNumber='" + this.childNumber + '\'' +  ", babyNumber='" + this.babyNumber + '\'' + 
        ", animalType='" + this.animalType + '\'' +  ", animalNote='" + this.animalNote + '\'' +  ", isBreakfast='" + this.isBreakfast + '\'' + 
        ", isLunch='" + this.isLunch + '\'' +  ", isDiner='" + this.isDiner + '\'' +  ", guestNote='" + this.guestNote + '\'' + ", adminNote='" + this.adminNote + '\'' + '}';
    }
}
