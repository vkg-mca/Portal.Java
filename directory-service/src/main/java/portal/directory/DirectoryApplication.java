package portal.directory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import portal.directory.entities.Person;
import portal.directory.repositories.PersonRepository;

import java.util.Date;

@SpringBootApplication
public class DirectoryApplication {

	public static void main(String[] args)
	{
		SpringApplication.run(DirectoryApplication.class, args);
	}

	@Bean
	public CommandLineRunner loadData(PersonRepository repo)
	{
		return args->
		{
			Person person=new Person();
			person.setName("admin");
			person.setBirthDate(new Date());
			person.setCreated(new Date());
			person.setDescription("Default person entry");
			repo.save(person);
		};
	}

}
