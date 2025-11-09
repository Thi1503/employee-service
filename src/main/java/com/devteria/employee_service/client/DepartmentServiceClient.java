package com.devteria.employee_service.client;

import com.devteria.employee_service.dto.response.ApiResponse;
import com.devteria.employee_service.dto.response.DepartmentResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "organization-service", url = "http://localhost:8081/organization")
public interface DepartmentServiceClient {

    @GetMapping("/department/{departmentId}/exists")
    ApiResponse<Boolean> existsById(@PathVariable("departmentId") String departmentId);


    // Hoặc trả về chi tiết department
    @GetMapping("/department/{id}")
    ApiResponse<DepartmentResponse> getById(@PathVariable("id") String departmentId);
}


