package com.devteria.employee_service.service;


import com.devteria.employee_service.client.CompanyServiceClient;
import com.devteria.employee_service.client.DepartmentServiceClient;
import com.devteria.employee_service.client.IdentityServiceClient;
import com.devteria.employee_service.dto.request.EmployeeCreateRequest;
import com.devteria.employee_service.dto.request.EmployeeUpdateRequest;
import com.devteria.employee_service.dto.response.EmployeeResponse;
import com.devteria.employee_service.entity.Employee;
import com.devteria.employee_service.exception.AppException;
import com.devteria.employee_service.exception.ErrorCode;
import com.devteria.employee_service.mapper.EmployeeMapper;
import com.devteria.employee_service.repository.EmployeeRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class EmployeeService {

    EmployeeRepository employeeRepository;
    EmployeeMapper employeeMapper;

    // Nếu dùng Feign hoặc RestTemplate để gọi organization-service / identity-service

     CompanyServiceClient companyServiceClient;
    DepartmentServiceClient departmentServiceClient;
    IdentityServiceClient identityServiceClient;

    public EmployeeResponse createEmployee(EmployeeCreateRequest request) {
        log.info("In method createEmployee with code={}", request.getCode());

        if (employeeRepository.existsByCode(request.getCode())) {
            throw new AppException(ErrorCode.EMPLOYEE_EXISTED);
        }

        // Optional: kiểm tra companyId, departmentId, accountId hợp lệ
        if (request.getCompanyId() != null && !companyServiceClient.existsById(request.getCompanyId()).getResult()) {
            throw new AppException(ErrorCode.COMPANY_NOT_FOUND);
        }

        if (request.getDepartmentId() != null && !departmentServiceClient.existsById(request.getDepartmentId()).getResult()) {
            throw new AppException(ErrorCode.DEPARTMENT_NOT_FOUND);
        }

//        if (request.getAccountId() != null && !identityServiceClient.existsById(request.getAccountId())) {
//            throw new AppException(ErrorCode.ACCOUNT_NOT_FOUND);
//        }

        Employee employee = employeeMapper.toEmployee(request);
        Employee saved = employeeRepository.save(employee);

        return employeeMapper.toEmployeeResponse(saved);
    }

    public List<EmployeeResponse> getAllEmployees() {
        log.info("In method getAllEmployees");
        return employeeRepository.findAll()
                .stream()
                .map(employeeMapper::toEmployeeResponse)
                .toList();
    }

    public EmployeeResponse getEmployeeById(String id) {
        log.info("In method getEmployeeById with id={}", id);

        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.EMPLOYEE_NOT_FOUND));

        return employeeMapper.toEmployeeResponse(employee);
    }

    public EmployeeResponse updateEmployee(String id, EmployeeUpdateRequest request) {
        log.info("In method updateEmployee with id={}", id);

        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.EMPLOYEE_NOT_FOUND));

//        // Optional: kiểm tra các ID liên kết
//        if (request.getDepartmentId() != null && !departmentServiceClient.existsById(request.getDepartmentId()).getResult()) {
//            throw new AppException(ErrorCode.DEPARTMENT_NOT_FOUND);
//        }


//        if (request.getAccountId() != null && !identityServiceClient.existsById(request.getAccountId())) {
//            throw new AppException(ErrorCode.ACCOUNT_NOT_FOUND);
//        }

        employeeMapper.updateEmployee(employee, request);
        Employee updated = employeeRepository.save(employee);

        return employeeMapper.toEmployeeResponse(updated);
    }

    public void deleteEmployeeById(String id) {
        log.info("In method deleteEmployeeById with id={}", id);

        if (!employeeRepository.existsById(id)) {
            throw new AppException(ErrorCode.EMPLOYEE_NOT_FOUND);
        }

        employeeRepository.deleteById(id);
    }
}
