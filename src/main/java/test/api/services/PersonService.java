package test.api.services;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.core.Response;
import test.api.dtos.PersonDto;
import test.api.entities.DepartmentEntity;
import test.api.entities.PersonEntity;
import test.api.repositories.DepartmentRepository;
import test.api.repositories.PersonRepository;

import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
@Transactional
public class PersonService {
    @Inject
    PersonRepository personRepository;
    @Inject
    DepartmentRepository departmentRepository;
    public List<PersonDto> getPersons(){
        List<PersonEntity> persons=personRepository.listAll();
        return persons.stream().map(this::toDto).collect(Collectors.toList());
    }
    public PersonDto createPerson(PersonDto personDto){
        PersonEntity person=new PersonEntity();
        person.setFirstName(personDto.getFirstName());
        person.setLastName(personDto.getLastName());
        person.setPersonalNumber(personDto.getPersonalNumber());
        person.setCountry(personDto.getCountry());
        person.setLanguage(personDto.getLanguage());
        person.setDateOfBirth(personDto.getDateOfBirth());
        DepartmentEntity department = departmentRepository.findById(personDto.getDepartmentId());
        if(department==null) {
            throw new EntityNotFoundException("Department with id "+personDto.getDepartmentId()+" not found");
        };
        person.setDepartments(department);
        personRepository.persist(person);
        personDto.setId(person.getId());
        return personDto;
    }

    public List<PersonDto> getPersonsByDepartmentId(Long id){
        var persons=personRepository.findByDepartmentId(id);
        return persons.stream().map(this::toDto).collect(Collectors.toList());
    }
    private PersonDto toDto(PersonEntity personEntity) {
        PersonDto personDto = new PersonDto();
        personDto.setId(personEntity.getId());
        personDto.setFirstName(personEntity.getFirstName());
        personDto.setLastName(personEntity.getLastName());
        personDto.setLanguage(personEntity.getLanguage());
        personDto.setCountry(personEntity.getCountry());
        personDto.setPersonalNumber(personEntity.getPersonalNumber());
        personDto.setDateOfBirth(personEntity.getDateOfBirth());
        personDto.setDepartmentId(personEntity.getDepartments().getId());
        return personDto;
    }
}
