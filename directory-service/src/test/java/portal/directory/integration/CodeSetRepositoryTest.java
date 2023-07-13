package portal.directory.integration;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import portal.directory.repositories.CodeSetRepository;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest

@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CodeSetRepositoryTest extends BaseTest{
    @Autowired private CodeSetRepository _repository;
    @Test
    @DisplayName("[MethodUnderTest:savePerson]_[Scenario:supplied person]_[ExpectedResult:personId]")
    void saveCodeSet_codeSet_codeSetId() {

        var expected_entity = new portal.directory.entities.CodeSet(1,"GENDER","F","Male",new Date(),"Feminine  Gender");
        var actual = _repository.save(expected_entity);
        assertThat(actual).usingRecursiveComparison().ignoringFields( "Created").isEqualTo(expected_entity);
    }
}
