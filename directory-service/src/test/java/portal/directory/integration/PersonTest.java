package portal.directory.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.testcontainers.containers.MSSQLServerContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;
import portal.directory.models.Person;

import java.util.Date;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Testcontainers
//@TestConfiguration

class PersonTest
{
	static DockerImageName sqlServerImage = DockerImageName.parse("mcr.microsoft.com/mssql/server:2017-latest").asCompatibleSubstituteFor("mcr.microsoft.com/mssql/server");
	@Container static MSSQLServerContainer sqlContainer = new MSSQLServerContainer(sqlServerImage);
	//@Container static MSSQLServerContainer sqlContainer=new MSSQLServerContainer(MSSQLServerContainer.NAME);
	//@Container static MSSQLServerContainer sqlContainer=new MSSQLServerContainer();
	@Autowired private MockMvc mockMvc;
	@Autowired private ObjectMapper objectMapper;

public PersonTest()
{
	//DockerImageName myImage = DockerImageName.parse("mcr.microsoft.com/mssql/server:2017-latest")
	//		.asCompatibleSubstituteFor("mcr.microsoft.com/mssql/server");
	//sqlContainer = new MSSQLServerContainer(myImage);
	sqlContainer.start();
	System.out.println(sqlContainer.getUsername());
	System.out.println(sqlContainer.getPassword());
	System.out.println(sqlContainer.getJdbcUrl());

	System.setProperty("spring.datasource.url", sqlContainer.getJdbcUrl());
}
	@DynamicPropertySource static void setProperties(DynamicPropertyRegistry registry)
	{
		registry.add("spring.datasource.url",sqlContainer::getJdbcUrl) ;
		registry.add("spring.datasource.username", sqlContainer::getUsername);
		registry.add("spring.datasource.password", sqlContainer::getPassword);
	}



	@Test
	@Tag("IntegrationTest")
	void shouldCreatePerson() throws Exception {

		Person personRequest = getPersonRequest();
		String person = objectMapper.writeValueAsString(personRequest);
		mockMvc.perform(MockMvcRequestBuilders.post("/api/directory")
				.contentType(MediaType.APPLICATION_JSON)
				.content(person))
				.andExpect(status().isCreated());
	}

	private Person getPersonRequest() {
		return Person.builder()
				.name("testPerson")
				.gender('M')
				.birthDate(new Date())
				.description("Test person")
				.build();
	}
	@AfterEach
	public void after(){
		sqlContainer.close();
	}
}
