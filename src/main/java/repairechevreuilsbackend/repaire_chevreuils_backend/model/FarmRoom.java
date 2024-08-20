package repairechevreuilsbackend.repaire_chevreuils_backend.model;

import java.util.Objects;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;

@Entity
public class FarmRoom extends GuestRoom {
    @Schema(description = "Additionnal equimnent of the farm rooms.", example = "Jolie vue")
    private String[] farmRoomEquipment;
    @Schema(description = "Number of additionnal adult bed the guest asked for.", example = "1")
    private int additionnalSingleBedNumber;

    FarmRoom() {}

    FarmRoom(String name, String description, double surfaceArea, RoomType roomType,
    String[] pictures, int singleBedNumber, int childBedNumber, int babyBedNumber, String[] equipment,
    double pricePerNight, String disponibility, int touristTax, double additionnalTax,
    String[] farmRoomEquipment, int additionnalSingleBedNumber) {
        super(name, description, surfaceArea, roomType, pictures, singleBedNumber, childBedNumber,
        babyBedNumber, equipment, pricePerNight, disponibility, touristTax, additionnalTax);
        this.farmRoomEquipment = farmRoomEquipment;
        this.additionnalSingleBedNumber = additionnalSingleBedNumber;
    }

    public String[] getFarmRoomEquipment() {
        return this.farmRoomEquipment;
    }

    public int getAdditionnalSingleBedNumber() {
        return this.additionnalSingleBedNumber;
    }

    public void setFarmRoomEquipment(String[] farmRoomEquipment) {
        this.farmRoomEquipment = farmRoomEquipment;
    }

    public void setAdditionnalSingleBedNumber(int additionnalSingleBedNumber) {
        this.additionnalSingleBedNumber = additionnalSingleBedNumber;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o)
        return true;
        if (!(o instanceof FarmRoom))
        return false;
        FarmRoom farmRoom = (FarmRoom) o;
        return Objects.equals(this.farmRoomEquipment, farmRoom.farmRoomEquipment) && Objects.equals(this.additionnalSingleBedNumber, farmRoom.additionnalSingleBedNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.farmRoomEquipment, this.additionnalSingleBedNumber);
    }

    @Override
    public String toString() {
        return "FarmRoom{" + ", farmRoomEquipment='" + this.farmRoomEquipment + '\'' + ", additionnalSingleBedNumber='" + this.additionnalSingleBedNumber + '\'' + '}';
    }
}
