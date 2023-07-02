package portal.finance;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.After;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.testcontainers.containers.MSSQLR2DBCDatabaseContainer;
import org.testcontainers.containers.MSSQLServerContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;
import portal.finance.models.Person;

import java.util.Date;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Testcontainers
//@TestConfiguration

class FinanceApplicationTests
{
	static DockerImageName sqlServerImage = DockerImageName.parse("mcr.microsoft.com/mssql/server:2017-latest").asCompatibleSubstituteFor("mcr.microsoft.com/mssql/server");
	@Container static MSSQLServerContainer sqlContainer = new MSSQLServerContainer(sqlServerImage);
	//@Container static MSSQLServerContainer sqlContainer=new MSSQLServerContainer(MSSQLServerContainer.NAME);
	//@Container static MSSQLServerContainer sqlContainer=new MSSQLServerContainer();
	@Autowired private MockMvc mockMvc;
	@Autowired private ObjectMapper objectMapper;

public FinanceApplicationTests()
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
	void shouldCreatePerson() throws Exception {

		Person personRequest = getPersonRequest();
		String person = objectMapper.writeValueAsString(personRequest);
		mockMvc.perform(MockMvcRequestBuilders.post("/api/person")
				.contentType(MediaType.APPLICATION_JSON)
				.content(person))
				.andExpect(status().isCreated());
	}

	private Person getPersonRequest() {
		return Person.builder()
				.Name("testPerson")
				.Gender('M')
				.BirthDate(new Date())
				.Description("Test person")
				.build();
	}
	@After
	public void after(){
		sqlContainer.close();
	}
}
