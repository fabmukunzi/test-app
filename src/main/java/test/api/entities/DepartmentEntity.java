package test.api.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.List;

@Entity
@Table(name = "departments")
public class DepartmentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false)
    private Long id;
    @Column(name = "name", nullable = false,unique = true)
    private String name;
    @OneToMany(mappedBy = "departments",cascade = CascadeType.ALL)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<PersonEntity> persons;

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPersons(List<PersonEntity> persons) {
        this.persons = persons;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<PersonEntity> getPersons() {
        return persons;
    }
}
