package codefactory.logger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LoggerApplication {

	public static void main(String[] args)
	{
		System.out.printf("Hello and welcome!");
		SpringApplication.run(LoggerApplication.class, args);
	}

}
