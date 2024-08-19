package repairechevreuilsbackend.repaire_chevreuils_backend.model;

import java.util.Objects;

import jakarta.persistence.Entity;

@Entity
public class FarmRoom extends GuestRoom {
    private String[] farmRoomEquipment;
    private int additionnalSingleBed;

    FarmRoom() {}

    FarmRoom(String name, String description, double surfaceArea, RoomType roomType,
    String[] pictures, int singleBedNumber, int childBedNumber, int babyBedNumber, String[] equipment,
    double pricePerNight, String disponibility, int touristTax, double additionnalTax,
    String[] farmRoomEquipment, int additionnalSingleBed) {
        super(name, description, surfaceArea, roomType, pictures, singleBedNumber, childBedNumber,
        babyBedNumber, equipment, pricePerNight, disponibility, touristTax, additionnalTax);
        this.farmRoomEquipment = farmRoomEquipment;
        this.additionnalSingleBed = additionnalSingleBed;
    }

    public String[] getFarmRoomEquipment() {
        return this.farmRoomEquipment;
    }

    public int getAdditionnalSingleBed() {
        return this.additionnalSingleBed;
    }

    public void setFarmRoomEquipment(String[] farmRoomEquipment) {
        this.farmRoomEquipment = farmRoomEquipment;
    }

    public void setAdditionnalSingleBed(int additionnalSingleBed) {
        this.additionnalSingleBed = additionnalSingleBed;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o)
        return true;
        if (!(o instanceof FarmRoom))
        return false;
        FarmRoom farmRoom = (FarmRoom) o;
        return Objects.equals(this.farmRoomEquipment, farmRoom.farmRoomEquipment) && Objects.equals(this.additionnalSingleBed, farmRoom.additionnalSingleBed);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.farmRoomEquipment, this.additionnalSingleBed);
    }

    @Override
    public String toString() {
        return "FarmRoom{" + ", farmRoomEquipment='" + this.farmRoomEquipment + '\'' + ", additionnalSingleBed='" + this.additionnalSingleBed + '\'' + '}';
    }
}
