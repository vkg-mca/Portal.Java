package portal.discovery;

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

@Slf4j
@SpringBootApplication
@ComponentScan({"portal.common.*","portal.discovery.*"})
@EntityScan({"portal.common.entities","portal.discovery.entities"})
@EnableJpaRepositories({"portal.common.repositories","portal.discovery.repositories"})
public class DiscoveryApplication {

    public static void main(String[] args)
    {
        SpringApplication.run(DiscoveryApplication.class, args);
    }
    @Bean
    public CommandLineRunner loadData(CodeSetRepository repo)
    {
        return args->
        {
            CodeSet codeset=new CodeSet();
            codeset.setCategory("SERVICE");
            codeset.setCode("NAME");
            codeset.setValue("Discovery Service");
            codeset.setDescription("Discovery MicroService");
            codeset.setCreated(new Date());
            repo.save(codeset);
        };
    }
}
