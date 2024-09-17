package test.api.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "qualifications")
public class QualificationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false)
    private long id;
    @Column(name = "title",nullable = false,unique = true)
    private String title;
    @ManyToMany(mappedBy = "qualifications",cascade = CascadeType.ALL)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Set<PersonEntity> persons= new HashSet<>();
    public void setTitle(String title) {
        this.title = title;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setPersons(Set<PersonEntity> persons) {
        this.persons = persons;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Set<PersonEntity> getPersons() {
        return persons;
    }
}
