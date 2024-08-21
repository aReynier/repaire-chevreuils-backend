package repairechevreuilsbackend.repaire_chevreuils_backend.model;

import java.util.HashSet;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.Set;

import io.swagger.v3.oas.annotations.media.Schema;

@Entity
@Schema(description = "Represents the guest who made a booking.")
public class Client {
    
    private @Id
    @Schema(description = "Unique identifier of the guest making the booking.", example = "0")
    @GeneratedValue Long clientId;

    @Schema(description = "First name of the guest making the booking.", example = "Jacques")
    private String firstName;
    @Schema(description = "Last name of the guest making the booking.", example = "Durant")
    private String lastName;
    @Schema(description = "Email address of the guest making the booking.", example = "Jacques.durant@mail.fr")
    private String email;
    @Schema(description = "Phone number of the guest making the booking, including country code.", example = "+33 3 33 33 33 33")
    private String phoneNumber;
    @Schema(description = "Primary address line of the guest making the booking.", example = "53 rue Solférino")
    private String addressFirstLine;
    @Schema(description = "Additional address information, such as apartment or suite number.", example = "appartement 2")
    private String addressComplement;
    @Schema(description = "ZIP code or postal code of the guest's address.", example = "59000")
    private String addressZipCode;
    @Schema(description = "City of the guest's address.", example = "Lille")
    private String addressCity;
    @Schema(description = "Country of the guest's address.", example = "France")
    private String addressCountry;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Booking> bookings = new HashSet<>();

    Client() {}

    Client(String firstName, String lastName, String email, String phoneNumber,
    String addressFirstLine, String addressComplement, String addressZipCode,
    String addressCity, String addressCountry) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.addressFirstLine = addressFirstLine;
        this.addressComplement = addressComplement;
        this.addressZipCode = addressZipCode;
        this.addressCity = addressCity;
        this.addressCountry = addressCountry;
    }

    public Long getClientId() {
        return this.clientId;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }
    
    public String getAddressFirstLine() {
        return this.addressFirstLine;
    }

    public String getAddressComplement() {
        return this.addressComplement;
    }

    public String getAddressZipCode() {
        return this.addressZipCode;
    }

    public String getAddressCity() {
        return this.addressCity;
    }

    public String getAddressCountry() {
        return this.addressCountry;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
    public void setAddressFirstLine(String addressFirstLine) {
        this.addressFirstLine = addressFirstLine;
    }

    public void setAddressComplement(String addressComplement) {
        this.addressComplement = addressComplement;
    }

    public void setAddressZipCode(String addressZipCode) {
        this.addressZipCode = addressZipCode;
    }

    public void setAddressCity(String addressCity) {
        this.addressCity = addressCity;
    }

    public void setAddressCountry(String addressCountry) {
        this.addressCountry = addressCountry;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o)
        return true;
        if (!(o instanceof Client))
        return false;
        Client client = (Client) o;
        return Objects.equals(this.clientId, client.clientId) && Objects.equals(this.firstName, client.firstName)
            && Objects.equals(this.lastName, client.lastName) && Objects.equals(this.email, client.email)
            && Objects.equals(this.phoneNumber, client.phoneNumber) && Objects.equals(this.addressFirstLine, client.addressFirstLine)
            && Objects.equals(this.addressComplement, client.addressComplement) && Objects.equals(this.addressZipCode, client.addressZipCode)
            && Objects.equals(this.addressCity, client.addressCity) && Objects.equals(this.addressCountry, client.addressCountry);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.clientId, this.firstName, this.lastName, this.email, this.phoneNumber, this.addressFirstLine, this.addressComplement,
        this.addressZipCode, this.addressCity, this.addressCountry);
    }

    @Override
    public String toString() {
        return "Client{" + "clientId=" + this.clientId + ", firstName='" + this.firstName + '\'' + ", lastName='" + this.lastName + '\'' + ", email='" +
        this.email + '\'' + ", phoneNumber='" + this.phoneNumber + '\'' + ", addressFirstLine='" + this.addressFirstLine + '\'' +", addressComplement='" + this.addressComplement + '\'' +
        ", addressZipCode='" + this.addressZipCode + '\'' + ", addressCity='" + this.addressCity + '\'' + ", addressCountry='" + this.addressCountry + '\'' + '}';
    }
}
