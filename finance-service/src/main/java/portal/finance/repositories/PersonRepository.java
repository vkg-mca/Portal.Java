package portal.finance.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import portal.finance.entities.Bank;
import portal.finance.entities.Person;

import java.util.List;

@Repository public interface PersonRepository extends JpaRepository<Person,Integer>{}
//@Query ("SELECT * FROM Person")
//List<Person> FindAll();

//@Query ("SELECT * FROM Person WHERE Id={id}")
//Person FindById(int Id);