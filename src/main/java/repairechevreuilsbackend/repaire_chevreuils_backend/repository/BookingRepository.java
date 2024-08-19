package repairechevreuilsbackend.repaire_chevreuils_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import repairechevreuilsbackend.repaire_chevreuils_backend.model.Booking;

interface BookingRepository extends JpaRepository<Booking, Long> {
    
}
