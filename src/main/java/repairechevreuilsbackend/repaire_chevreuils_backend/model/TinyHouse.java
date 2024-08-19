package repairechevreuilsbackend.repaire_chevreuils_backend.model;

import java.util.Arrays;
import java.util.Objects;

import jakarta.persistence.Entity;

@Entity
public class TinyHouse extends GuestRoom {
    private String[] tinyHouseEquipment;

    TinyHouse() {}

    TinyHouse(String name, String description, double surfaceArea, RoomType roomType,
    String[] pictures, int singleBedNumber, int childBedNumber, int babyBedNumber, String[] equipment,
    double pricePerNight, String disponibility, int touristTax, double additionnalTax,
    String[] tinyHouseEquipment, int additionnalSingleBed) {
        super(name, description, surfaceArea, roomType, pictures, singleBedNumber, childBedNumber,
        babyBedNumber, equipment, pricePerNight, disponibility, touristTax, additionnalTax);
        this.tinyHouseEquipment = tinyHouseEquipment;
    }

    public String[] getTinyHouseEquipment() {
        return this.tinyHouseEquipment;
    }

    public void setTinyHouseEquipment(String[] tinyHouseEquipment) {
        this.tinyHouseEquipment = tinyHouseEquipment;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o)
        return true;
        if (!(o instanceof TinyHouse))
        return false;
        TinyHouse TinyHouse = (TinyHouse) o;
        return Objects.equals(this.tinyHouseEquipment, TinyHouse.tinyHouseEquipment);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(this.tinyHouseEquipment);
    }

    @Override
    public String toString() {
        return "TinyHouse{" + ", TinyHouseEquipment='" + this.tinyHouseEquipment + '}';
    }
}
