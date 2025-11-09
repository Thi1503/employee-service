package com.devteria.employee_service.mapper;


import com.devteria.employee_service.dto.request.EmployeeCreateRequest;
import com.devteria.employee_service.dto.request.EmployeeUpdateRequest;
import com.devteria.employee_service.dto.response.EmployeeResponse;
import com.devteria.employee_service.entity.Contract;
import com.devteria.employee_service.entity.Employee;
import com.devteria.employee_service.entity.EmploymentHistory;
import com.devteria.employee_service.entity.FamilyMember;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    // Map từ CreateRequest -> Employee entity
    @Mapping(source = "positionId", target = "position.id")
    Employee toEmployee(EmployeeCreateRequest request);

    // Map từ UpdateRequest -> Employee entity (update entity)
    @Mapping(source = "positionId", target = "position.id")
    void updateEmployee(@MappingTarget Employee employee, EmployeeUpdateRequest request);

    // Map từ Employee entity -> Response DTO
    @Mapping(source = "position.id", target = "positionId")
    @Mapping(target = "contractIds", expression = "java(getContractIds(employee))")
    @Mapping(target = "familyMemberIds", expression = "java(getFamilyMemberIds(employee))")
    @Mapping(target = "employmentHistoryIds", expression = "java(getEmploymentHistoryIds(employee))")
    EmployeeResponse toEmployeeResponse(Employee employee);

    // Helper methods để map List quan hệ sang List<String> ID
    default List<String> getContractIds(Employee employee) {
        return employee.getContracts() == null ? null
                : employee.getContracts().stream().map(Contract::getId).collect(Collectors.toList());
    }

    default List<String> getFamilyMemberIds(Employee employee) {
        return employee.getFamilyMembers() == null ? null
                : employee.getFamilyMembers().stream().map(FamilyMember::getId).collect(Collectors.toList());
    }

    default List<String> getEmploymentHistoryIds(Employee employee) {
        return employee.getEmploymentHistories() == null ? null
                : employee.getEmploymentHistories().stream().map(EmploymentHistory::getId).collect(Collectors.toList());
    }
}
