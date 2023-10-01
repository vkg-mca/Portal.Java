package portal.common.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import portal.common.entities.CodeSet;

import java.util.List;
import java.util.Optional;

@Repository
public interface CodeSetRepository extends JpaRepository<CodeSet, Integer> {
    List<CodeSet> findByCategory(String category);
    List<CodeSet> findByCode(String code);
    Optional<CodeSet> findByCategoryAndCode(String category, String code);
}
