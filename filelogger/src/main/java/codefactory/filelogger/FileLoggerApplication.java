package codefactory.filelogger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FileLoggerApplication {

	public static void main(String[] args)
	{
		System.out.printf("Hello and welcome!");
		SpringApplication.run(FileLoggerApplication.class, args);
	}

}
