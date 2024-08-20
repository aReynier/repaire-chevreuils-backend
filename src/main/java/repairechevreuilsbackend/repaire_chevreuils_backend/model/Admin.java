package repairechevreuilsbackend.repaire_chevreuils_backend.model;

import java.util.Objects;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
@Schema(description = "Represents an admin user in the system.")
public class Admin {
    private @Id
    @Schema(description = "Unique identifier of the admin.", example = "1")
    @GeneratedValue Long adminId;
    
    @Schema(description = "Admin's email address.", example = "admin@example.com")
    private String email;

    @Schema(description = "Admin's password.", example = "securePassword123")
    private String password;

    public Admin() {}

    Admin(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public Long getAdminId() {
        return this.adminId;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setAdminId(Long adminId) {
        this.adminId = adminId;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o)
        return true;
        if (!(o instanceof Admin))
        return false;
        Admin admin = (Admin) o;
        return Objects.equals(this.adminId, admin.adminId) && Objects.equals(this.email, admin.email)
            && Objects.equals(this.password, admin.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.adminId, this.email, this.password);
    }

    @Override
    public String toString() {
        return "Admin{" + "adminId=" + this.adminId + ", email='" + this.email + '\'' + ", password='" + this.password + '\'' + '}';
    }
}
