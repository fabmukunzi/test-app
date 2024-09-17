package test.api.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="persons")
public class PersonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable = false)
    private long id;
    @Column(name = "first_name", nullable = false)
    private String firstName;
    @Column(name = "last_name", nullable = false)
    private String lastName;
    @Column(name = "date_of_birth", nullable = false)
    private String dateOfBirth;
    @Column(name = "personal_number", nullable = true)
    private String personalNumber;
    @Column(name = "country", nullable = false)
    private String country;
    @Column(name = "language", nullable = false)
    private String language;
    @ManyToOne()
    @JoinColumn(name = "department_id", nullable = false)
    private DepartmentEntity departments;
    @ManyToMany()
    @JoinTable(
            name="person_qualification",
            joinColumns = @JoinColumn(name = "person_id"),
            inverseJoinColumns = @JoinColumn(name = "qualification_id"))
    private List<QualificationEntity> qualifications;

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setPersonalNumber(String personalNumber) {
        this.personalNumber = personalNumber;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setDepartments(DepartmentEntity departments) {
        this.departments = departments;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getPersonalNumber() {
        return personalNumber;
    }

    public String getCountry() {
        return country;
    }

    public String getLanguage() {
        return language;
    }

    public DepartmentEntity getDepartments() {
        return departments;
    }

    public List<QualificationEntity> getQualifications() {
        return qualifications;
    }
}
