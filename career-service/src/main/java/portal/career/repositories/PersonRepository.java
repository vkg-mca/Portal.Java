package portal.career.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import portal.career.entities.Person;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person,Integer>
{
    List<Person> findByGender(Character gender);
    List<Person> findByIdAndGender(int id, Character gender);
    List<Person> findByIdOrGenderOrderByIdAsc(int id, Character gender);

    //@Query ("SELECT * FROM Person WHERE Id={id}")
    //Person FindById(int Id);
}
