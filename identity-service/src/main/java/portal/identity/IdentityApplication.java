package portal.identity;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import portal.common.entities.CodeSet;
import portal.common.repositories.CodeSetRepository;

import java.util.Date;
import java.util.Objects;

@SpringBootApplication
@ComponentScan({"portal.common.*","portal.identity.*"})
@EntityScan({"portal.common.entities","portal.identity.entities"})
@EnableJpaRepositories({"portal.common.repositories","portal.identity.repositories"})
public class IdentityApplication {

    public static void main(String[] args)
    {
        SpringApplication.run(IdentityApplication.class, args);
    }
    @Bean
    public CommandLineRunner loadData(CodeSetRepository repo)
    {
        return args->
        {
            CodeSet codeset=new CodeSet();
            codeset.setCategory("SERVICE");
            codeset.setCode("NAME");
            codeset.setValue("Identity Service");
            codeset.setDescription("Identity MicroService");
            codeset.setCreated(new Date());
            repo.save(codeset);
        };
    }
}
