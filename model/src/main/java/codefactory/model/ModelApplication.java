package codefactory.model;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ModelApplication {

	public static void main(String[] args)
	{
		System.out.printf("Hello and welcome!");
		SpringApplication.run(ModelApplication.class, args);

	}

}
