package codefactory.finance.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import codefactory.finance.entities.FinanceEntity;

import java.io.Serializable;

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
