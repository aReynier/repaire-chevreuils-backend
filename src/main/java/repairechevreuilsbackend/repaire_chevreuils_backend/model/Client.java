package repairechevreuilsbackend.repaire_chevreuils_backend.model;

import java.util.HashSet;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.Set;

@Entity
public class Client {
    
    private @Id
    @GeneratedValue Long clientId;

    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String addressFirstLine;
    private String addressComplement;
    private String addressZipCode;
    private String addressCity;
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
