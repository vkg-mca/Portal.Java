package codefactory.common;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CommonApplication {

	public static void main(String[] args)
	{
		System.out.printf("Hello and welcome!");
		SpringApplication.run(CommonApplication.class, args);

	}

}
