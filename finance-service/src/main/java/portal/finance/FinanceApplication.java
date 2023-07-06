package portal.finance;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import portal.finance.entities.*;
import portal.finance.repositories.*;

import java.util.Date;
import java.util.Objects;

@Slf4j
@SpringBootApplication
@PropertySource(ignoreResourceNotFound = true, value = "classpath:application.properties")

public class FinanceApplication {

	public static void main(String[] args)
	{
		SpringApplication.run(FinanceApplication.class, args);
	}


	@Value("${spring.application.mode}")
	private String mode;

	@Bean
	public CommandLineRunner loadData(PersonRepository personRepo,BankRepository bankRepo)
	{
		log.info("Service is running in {} mode",mode);
		//System.out.println(mode);
		if(!Objects.equals(mode, "PROD"))
		{
			return null;
		}

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
