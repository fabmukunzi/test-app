package test.api.repositories;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import test.api.entities.QualificationEntity;

@ApplicationScoped
@Transactional(Transactional.TxType.MANDATORY)
public class QualificationRepository implements PanacheRepository<QualificationEntity> {
}
