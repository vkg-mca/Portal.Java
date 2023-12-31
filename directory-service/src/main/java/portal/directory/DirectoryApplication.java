package portal.directory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import portal.common.entities.CodeSet;
import portal.common.repositories.CodeSetRepository;
import portal.directory.entities.Person;
import portal.directory.repositories.PersonRepository;

import java.util.Date;

@SpringBootApplication
@ComponentScan({"portal.common.*","portal.directory.*"})
@EntityScan({"portal.common.entities","portal.directory.entities"})
@EnableJpaRepositories({"portal.common.repositories","portal.directory.repositories"})

public class DirectoryApplication {

	public static void main(String[] args)
	{
		SpringApplication.run(DirectoryApplication.class, args);
	}

	@Bean
	public CommandLineRunner loadData(CodeSetRepository codesetRepo, PersonRepository repo)
	{
		return args->
		{
			CodeSet codeset=new CodeSet();
			codeset.setCategory("SERVICE");
			codeset.setCode("NAME");
			codeset.setValue("Directory Service");
			codeset.setDescription("Directory MicroService");
			codeset.setCreated(new Date());
			codesetRepo.save(codeset);

			Person person=new Person();
			person.setName("admin");
			person.setGender('M');
			person.setBirthDate(new Date());
			person.setCreated(new Date());
			person.setDescription("Default person entry");
			repo.save(person);
		};
	}

}
