package repairechevreuilsbackend.repaire_chevreuils_backend.model;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

import java.util.HashSet;
import java.util.Set;

@Entity
public class GuestRoom {
    private @Id
    @GeneratedValue Long guestRoomId;

    private String name;
    private String description;
    private double surfaceArea;
    private RoomType roomType;
    private String[] pictures;
    private int singleBedNumber;
    private int childBedNumber;
    private int babyBedNumber;
    private String[] equipment;
    private double pricePerNight;
    private String disponibility;
    private int touristTax;
    private double additionnalTax;

    @ManyToMany
    private Set<Booking> bookings = new HashSet<>();

    GuestRoom() {}

    GuestRoom(String name, String description, double surfaceArea, RoomType roomType,
    String[] pictures, int singleBedNumber, int childBedNumber, int babyBedNumber, String[] equipment,
    double pricePerNight, String disponibility, int touristTax, double additionnalTax) {
        this.name = name;
        this.description = description;
        this.surfaceArea = surfaceArea;
        this.roomType = roomType;
        this.pictures = pictures;
        this.singleBedNumber = singleBedNumber;
        this.childBedNumber = childBedNumber;
        this.babyBedNumber = babyBedNumber;
        this.equipment = equipment;
        this.pricePerNight = pricePerNight;
        this.disponibility = disponibility;
        this.touristTax = touristTax;
        this.additionnalTax = additionnalTax;
    }

    public enum RoomType {
        FARM_ROOM,
        TINY_HOUSE
    }

    public Long getGuestRoom() {
        return this.guestRoomId;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public double getSurfaceArea() {
        return this.surfaceArea;
    }

    public RoomType getRoomType() {
        return this.roomType;
    }
    
    public String[] getPictures() {
        return this.pictures;
    }
    
    public int getSingleBedNumber() {
        return this.singleBedNumber;
    }
    
    public int getChildBedNumber() {
        return this.childBedNumber;
    }

    public int getBabyBedNumber() {
        return this.babyBedNumber;
    }

    public String[] getEquipment() {
        return this.equipment;
    }
    
    public double getPricePerNight() {
        return this.pricePerNight;
    }
    
    public String getDisponibility() {
        return this.disponibility;
    }

    public int getTouristTax() {
        return this.touristTax;
    }

    public double getAdditionnalTaxTax() {
        return this.additionnalTax;
    }

    public void setguestRoomId(Long guestRoomId) {
        this.guestRoomId = guestRoomId;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public void setSurfaceArea(double surfaceArea) {
        this.surfaceArea = surfaceArea;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    public void setPictures(String[] pictures) {
        this.pictures = pictures;
    }
    
    public void setSingleBedNumber(int singleBedNumber) {
        this.singleBedNumber = singleBedNumber;
    }
    
    public void setChildBedNumber(int childBedNumber) {
        this.childBedNumber = childBedNumber;
    }
    
    public void setBabyBedNumber(int babyBedNumber) {
        this.babyBedNumber = babyBedNumber;
    }
    
    public void setEquipment(String[] equipment) {
        this.equipment = equipment;
    }

    public void setPricePerNight(double pricePerNight) {
        this.pricePerNight = pricePerNight;
    }
    
    public void setDisponibility(String disponibility) {
        this.disponibility = disponibility;
    }
    
    public void setTouristTax(int touristTax) {
        this.touristTax = touristTax;
    }
    
    public void setAdditionnalTax(int additionnalTax) {
        this.additionnalTax = additionnalTax;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o)
        return true;
        if (!(o instanceof GuestRoom))
        return false;
        GuestRoom guestRoom = (GuestRoom) o;
        return Objects.equals(this.guestRoomId, guestRoom.guestRoomId) && Objects.equals(this.name, guestRoom.name)
            && Objects.equals(this.description, guestRoom.description) && Objects.equals(this.surfaceArea, guestRoom.surfaceArea)
            && Objects.equals(this.surfaceArea, guestRoom.surfaceArea) && Objects.equals(this.roomType, guestRoom.roomType)
            && Objects.equals(this.pictures, guestRoom.pictures) && Objects.equals(this.singleBedNumber, guestRoom.singleBedNumber)
            && Objects.equals(this.childBedNumber, guestRoom.childBedNumber) && Objects.equals(this.babyBedNumber, guestRoom.babyBedNumber)
            && Objects.equals(this.equipment, guestRoom.equipment) && Objects.equals(this.pricePerNight, guestRoom.pricePerNight)
            && Objects.equals(this.disponibility, guestRoom.disponibility) && Objects.equals(this.touristTax, guestRoom.touristTax)
            && Objects.equals(this.additionnalTax, guestRoom.additionnalTax);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.guestRoomId, this.name, this.description, this.surfaceArea, this.roomType, this.pictures, this.singleBedNumber,
        this.childBedNumber, this.babyBedNumber, this.equipment, this. pricePerNight, this.disponibility, this.touristTax, this.additionnalTax);
    }

    @Override
    public String toString() {
        return "GuestRoom{" + "guestRoomId=" + this.guestRoomId + ", name='" + this.name + '\'' + ", description='" + this.description + '\'' + 
        ", surfaceArea='" + this.surfaceArea + '\'' + ", roomType='" + this.roomType + '\'' + ", pictures='" + this.pictures + '\'' + 
        ", singleBedNumber='" + this.singleBedNumber + '\'' + ", childBedNumber='" + this.childBedNumber + '\'' + ", babyBedNumber='" + this.babyBedNumber + '\'' + 
        ", equipment='" + this.equipment + '\'' + ", pricePerNight='" + this.pricePerNight + '\'' + ", disponibility='" + this.disponibility + '\'' + 
         ", touristTax='" + this.touristTax + '\'' +  ", additionnalTax='" + this.additionnalTax + '\'' + '}';
    }
}
