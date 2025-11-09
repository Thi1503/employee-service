package com.devteria.employee_service.repository;

import com.devteria.employee_service.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String> {

    // Tìm theo code
    Optional<Employee> findByCode(String code);

    // Tìm danh sách nhân viên theo companyId
    List<Employee> findByCompanyId(String companyId);

    // Tìm danh sách nhân viên theo departmentId
    List<Employee> findByDepartmentId(String departmentId);

    // Tìm nhân viên theo accountId
    Optional<Employee> findByAccountId(String accountId);

    // Kiểm tra code đã tồn tại chưa
    boolean existsByCode(String code);
}
