package portal.career;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import portal.career.entities.Person;
import portal.career.repositories.PersonRepository;
import portal.common.entities.CodeSet;
import portal.common.repositories.CodeSetRepository;
import portal.common.services.CodeSetService;

import java.util.Date;

@SpringBootApplication
@ComponentScan({"portal.common.*","portal.career.*"})
@EntityScan({"portal.common.entities","portal.career.entities"})
@EnableJpaRepositories({"portal.common.repositories","portal.career.repositories"})

public class CareerApplication {

    public static void main(String[] args)
    {
        SpringApplication.run(CareerApplication.class, args);
    }

    @Bean
    public CommandLineRunner loadData(CodeSetRepository repo)
    {
        return args->
        {
            CodeSet codeset=new CodeSet();
            codeset.setCategory("SERVICE");
            codeset.setCode("NAME");
            codeset.setValue("Career Service");
            codeset.setDescription("Career MicroService");
            codeset.setCreated(new Date());
            repo.save(codeset);
        };
    }

}
