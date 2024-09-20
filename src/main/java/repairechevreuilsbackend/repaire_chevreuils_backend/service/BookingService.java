package repairechevreuilsbackend.repaire_chevreuils_backend.service;

import repairechevreuilsbackend.repaire_chevreuils_backend.repository.BookingRepository;

public class BookingService {
    private final BookingRepository repository;

    BookingService(BookingRepository repository) {
    this.repository = repository;
  }
}
