package portal.finance.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import portal.finance.entities.FinanceEntity;
import portal.finance.entities.Person;

import java.io.Serializable;
import java.util.List;

//@Repository
//@NoRepositoryBean
@Component
public interface FinanceRepository<T extends FinanceEntity, E extends Serializable> extends JpaRepository<T, E>
{
    //@Query ("SELECT * FROM Person")
    //List<Person> FindAll();

    //@Query ("SELECT * FROM Person WHERE Id={id}")
    //Person FindById(int Id);
}
