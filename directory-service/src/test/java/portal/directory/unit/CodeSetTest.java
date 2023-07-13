package portal.directory.unit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.jdbc.Sql;
import portal.directory.repositories.CodeSetRepository;
import portal.directory.repositories.PersonRepository;
import portal.directory.services.CodeSetService;
import portal.directory.services.PersonService;
import portal.directory.translators.CodeSetTranslator;
import portal.directory.translators.PersonTranslator;

import java.util.Date;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class CodeSetTest {
    @Mock private CodeSetRepository _repository ;//= Mockito.mock(PersonRepository.class);
    @Mock private CodeSetTranslator _translator;//=Mockito.mock(PersonTranslator.class );
    @Captor ArgumentCaptor<portal.directory.entities. CodeSet> entity;
    @Captor ArgumentCaptor<portal.directory.models.Person> model;
    CodeSetService service;
    @BeforeEach
    public void setup(){
        service = new CodeSetService(_repository,_translator);
    }
    
    @Test
    @DisplayName("Given_Preconditions_When_StateUnderTest_Then_ExpectedBehavior — Behavior-Driven Development (BDD)")
    void GIVEN_codeset_WHEN_passingCodeSetId_THEN_getCodeSet() {

        var expected_entity = new portal.directory.entities.CodeSet(1,"GENDER","M","Male",new Date(),"Masculine Gender");
        Mockito.when(_repository.findById(expected_entity.getId())).thenReturn(Optional.of(expected_entity));

        var expected_model= new portal.directory.models.CodeSet(1,"GENDER","M","Male",new Date(),"Masculine Gender");
        Mockito.when(_translator.Translate(Mockito.any(portal.directory.entities.CodeSet.class))).thenReturn(expected_model);


        var actual = service.GetCodeSet(expected_entity.getId());

        //assertNotNull(actual);
        assertThat(actual.getCode()).isEqualTo(expected_model.getCode());
        assertThat(actual.getId()).isEqualTo(expected_model.getId());
    }

    @Test
    @DisplayName("[MethodUnderTest]_[Scenario]_[ExpectedResult]")
    void getCodeSet_codeSetIds_codeSetList() {
    }

    @Test
    @DisplayName("[MethodUnderTest:savePerson]_[Scenario:supplied person]_[ExpectedResult:personId]")
    void saveCodeSet_codeset_codeSetId() {

        var expected_model= new portal.directory.models.CodeSet(1,"GENDER","F","Male",new Date(),"Feminine  Gender");
        var expected_entity = new portal.directory.entities.CodeSet(1,"GENDER","F","Male",new Date(),"Feminine  Gender");

        Mockito.when(_repository.save(expected_entity)).thenReturn(expected_entity);
        Mockito.when(_translator.Translate(Mockito.any(portal.directory.models.CodeSet.class))).thenReturn(expected_entity);

        var actual = service.SaveCodeSet(expected_model) ;

        Mockito.verify(_repository,Mockito.times(1) ).save(entity.capture());
        assertThat(actual).isEqualTo(1);
        assertThat(entity.getValue().getId()).isEqualTo(expected_model.getId());
        //assertThat(expected_model).usingRecursiveComparison().ignoringFields("Id").isEqualTo(expected_entity);
    }

    @Test
    @Sql("classpath:seed-data.sql")
    @DisplayName("[MethodUnderTest:saveCodeSet]_[Scenario:supplied codeset seed file]_[ExpectedResult:codeSetId]")
    void saveCodeSet_codeSetSeedSql_codeSetId() {

       var entity = _repository.findById(1);
        assertThat(entity).isNotEmpty();
    }


    @Test
    void updatePerson() {
    }

    @Test
    void deletePerson() {
    }
}