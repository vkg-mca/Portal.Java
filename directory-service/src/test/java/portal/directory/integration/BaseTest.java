package portal.directory.integration;

import org.testcontainers.containers.MySQLContainer;

public class BaseTest {
    static MySQLContainer mySqlContainer = new MySQLContainer("mysql:latest")
            .withDatabaseName("directory-service-test-db")
            .withUsername("root")
            .withPassword("doniv@0DGB");
    static{
        mySqlContainer.start();
    }

}
