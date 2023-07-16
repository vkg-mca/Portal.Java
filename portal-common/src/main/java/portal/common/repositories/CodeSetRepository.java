package portal.common.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import portal.common.entities.CodeSet;

@Repository
public interface CodeSetRepository extends JpaRepository<CodeSet, Integer> {
}