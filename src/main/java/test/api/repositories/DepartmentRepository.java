package test.api.repositories;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import test.api.entities.DepartmentEntity;

@ApplicationScoped
@Transactional(Transactional.TxType.MANDATORY)
public class DepartmentRepository implements PanacheRepository<DepartmentEntity> {
}
