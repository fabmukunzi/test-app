package test.api.services;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.core.Response;
import test.api.dtos.DepartmentDto;
import test.api.entities.DepartmentEntity;
import test.api.repositories.DepartmentRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@ApplicationScoped
@Transactional
public class DepartmentService {
    @Inject
    DepartmentRepository departmentRepository;
    public DepartmentDto creatDepartment(DepartmentDto departmentDto){
        var departmentEntity=new DepartmentEntity();
        departmentEntity.setName(departmentDto.getName());
        departmentRepository.persist(departmentEntity);
        departmentDto.setId(departmentEntity.getId());
        return departmentDto;
    }

    public List<DepartmentDto> getDepartments(){
        var departments=departmentRepository.listAll().stream().map(this::toDto).collect(Collectors.toList());
        return  departments;
    }

    public DepartmentDto getDepartmentById(Long id){
        var department= departmentRepository.findById(id);
        return toDto(department);
    }

    public boolean deleteDepartmentById(Long id){
        return departmentRepository.deleteById(id);
    }

    public DepartmentDto toDto(DepartmentEntity departmentEntity){
        var departmentDto=new DepartmentDto();
        departmentDto.setName(departmentEntity.getName());
        departmentDto.setId(departmentEntity.getId());
        return  departmentDto;
    }
}
