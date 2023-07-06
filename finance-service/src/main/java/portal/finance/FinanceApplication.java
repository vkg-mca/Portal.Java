package portal.finance;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import portal.finance.entities.*;
import portal.finance.repositories.*;

import java.util.Date;

@SpringBootApplication
public class FinanceApplication {

	public static void main(String[] args)
	{
		SpringApplication.run(FinanceApplication.class, args);
	}

	@Bean
	public CommandLineRunner loadData(PersonRepository personRepo,BankRepository bankRepo)
	{
		return args->
		{
			Person person=new Person();
			person.setName("admin");
			person.setBirthDate(new Date());
			person.setCreated(new Date());
			person.setDescription("Default person entry");
			personRepo.save(person);

			Bank bank=new Bank();
			bank.setName("admin");
			bank.setTAN("Default TAN");
			bank.setPAN("Default PAN");
			bank.setCreated(new Date());
			bank.setDescription("Default person entry");
			bankRepo.save(bank);

		};
	}

}
