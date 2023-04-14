package kodlama.io.customermanager.repository;

import kodlama.io.customermanager.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository  extends JpaRepository<Customer, Integer> {
    boolean existsByNationalIdentity(String nationalIdentity);
    boolean existsById(int id);
}
