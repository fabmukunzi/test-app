package test.api.services;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import test.api.dtos.DepartmentDto;
import test.api.dtos.QualificationDto;
import test.api.entities.DepartmentEntity;
import test.api.entities.QualificationEntity;
import test.api.repositories.QualificationRepository;

import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
@Transactional
public class QualificationService {
    @Inject
    QualificationRepository qualificationRepository;
    public List<QualificationDto> getQualifications(){
        return qualificationRepository.listAll().stream().map(this::toDto).collect(Collectors.toList());
    }
    public QualificationDto creatQualification(QualificationDto qualificationDto){
        var qualificationEntity=new QualificationEntity();
        qualificationEntity.setTitle(qualificationDto.getTitle());
        qualificationRepository.persist(qualificationEntity);
        qualificationDto.setId(qualificationEntity.getId());
        return qualificationDto;
    }
    public QualificationDto toDto(QualificationEntity qualificationEntity){
        var qualificationDto=new QualificationDto();
        qualificationDto.setTitle(qualificationEntity.getTitle());
        qualificationDto.setId(qualificationEntity.getId());
        return  qualificationDto;
    }
}
