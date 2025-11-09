package com.devteria.employee_service.controller;

import com.devteria.employee_service.dto.request.EmployeeCreateRequest;
import com.devteria.employee_service.dto.request.EmployeeUpdateRequest;
import com.devteria.employee_service.dto.response.EmployeeResponse;
import com.devteria.employee_service.service.EmployeeService;
import com.devteria.employee_service.dto.response.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "employee")
@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class EmployeeController {

    EmployeeService employeeService;

    @PostMapping
    public ApiResponse<EmployeeResponse> createEmployee(@RequestBody EmployeeCreateRequest request) {
        EmployeeResponse response = employeeService.createEmployee(request);
        return ApiResponse.<EmployeeResponse>builder()
                .result(response)
                .build();
    }

    @GetMapping
    public ApiResponse<List<EmployeeResponse>> getEmployees() {
        List<EmployeeResponse> responses = employeeService.getAllEmployees();
        return ApiResponse.<List<EmployeeResponse>>builder()
                .result(responses)
                .build();
    }

    @GetMapping("/{id}")
    public ApiResponse<EmployeeResponse> getEmployee(@PathVariable("id") String id) {
        EmployeeResponse response = employeeService.getEmployeeById(id);
        return ApiResponse.<EmployeeResponse>builder()
                .result(response)
                .build();
    }

    @PutMapping("/{id}")
    public ApiResponse<EmployeeResponse> updateEmployee(@PathVariable("id") String id,
                                                        @RequestBody EmployeeUpdateRequest request) {
        EmployeeResponse response = employeeService.updateEmployee(id, request);
        return ApiResponse.<EmployeeResponse>builder()
                .result(response)
                .build();
    }

    @DeleteMapping("/{id}")
    public ApiResponse<String> deleteEmployee(@PathVariable("id") String id) {
        employeeService.deleteEmployeeById(id);
        return ApiResponse.<String>builder()
                .result("Employee has been deleted")
                .build();
    }
}