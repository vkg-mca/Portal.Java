package portal.directory.unit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import portal.directory.repositories.PersonRepository;
import portal.directory.services.PersonService;
import portal.directory.translators.PersonTranslator;

import java.util.Date;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class PersonServiceTest {
    @Mock private PersonRepository _repository ;//= Mockito.mock(PersonRepository.class);
    @Mock private PersonTranslator _translator;//=Mockito.mock(PersonTranslator.class );
    @Captor ArgumentCaptor<portal.directory.entities.Person> person_entity;
    @Captor ArgumentCaptor<portal.directory.models.Person> person_model;
    PersonService service;
    @BeforeEach
    public void setup(){
        service = new PersonService(_repository,_translator);
    }
    
    @Test
    @DisplayName("Given_Preconditions_When_StateUnderTest_Then_ExpectedBehavior — Behavior-Driven Development (BDD)")
    void GIVEN_person_WHEN_passingPersonId_THEN_getPerson() {

        var expected_entity = new portal.directory.entities.Person(1,"Name",'M',new Date(),new Date(),"Description");
        Mockito.when(_repository.findById(expected_entity.getId())).thenReturn(Optional.of(expected_entity));

        var expected_model= new portal.directory.models.Person(1,"Name",'M', new Date(),new Date(),"Description");
        Mockito.when(_translator.Translate(Mockito.any(portal.directory.entities.Person.class))).thenReturn(expected_model);


        var actual = service.GetPerson(expected_entity.getId());

        //assertNotNull(actual);
        assertThat(actual.getName()).isEqualTo(expected_model.getName());
        assertThat(actual.getId()).isEqualTo(expected_model.getId());
    }

    @Test
    @DisplayName("[MethodUnderTest]_[Scenario]_[ExpectedResult]")
    void getPerson_personIds_personList() {
    }

    @Test
    @DisplayName("[MethodUnderTest:savePerson]_[Scenario:supplied person]_[ExpectedResult:personId]")
    void savePerson_person_personId() {

        var expected_model= new portal.directory.models.Person(1,"Name",'M', new Date(),new Date(),"Description");
        var expected_entity = new portal.directory.entities.Person(1,"Name",'M',new Date(),new Date(),"Description");

        Mockito.when(_repository.save(expected_entity)).thenReturn(expected_entity);
        Mockito.when(_translator.Translate(Mockito.any(portal.directory.models.Person.class))).thenReturn(expected_entity);


        var actual = service.SavePerson(expected_model) ;

        Mockito.verify(_repository,Mockito.times(1) ).save(person_entity.capture());
        assertThat(actual).isEqualTo(1);
        assertThat(person_entity.getValue().getId()).isEqualTo(expected_model.getId());
        //assertThat(expected_model).usingRecursiveComparison().ignoringFields("Id").isEqualTo(expected_entity);
    }

    @Test
    void updatePerson() {
    }

    @Test
    void deletePerson() {
    }
}