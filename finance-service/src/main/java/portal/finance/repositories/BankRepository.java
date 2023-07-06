package portal.finance.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import portal.finance.entities.Bank;

@Repository
public interface BankRepository extends JpaRepository<Bank, Integer> {
}
