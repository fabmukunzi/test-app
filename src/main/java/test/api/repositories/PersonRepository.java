package test.api.repositories;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import test.api.entities.PersonEntity;

import java.util.List;

@ApplicationScoped
@Transactional(Transactional.TxType.MANDATORY)
public class PersonRepository implements PanacheRepository<PersonEntity> {
    public List<PersonEntity> findByDepartmentId(Long departmentId) {
        return list("departments.id", departmentId);
    }
}
