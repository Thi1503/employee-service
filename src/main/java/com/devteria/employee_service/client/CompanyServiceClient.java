package com.devteria.employee_service.client;

import com.devteria.employee_service.dto.response.ApiResponse;
import com.devteria.employee_service.dto.response.CompanyResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "organization", url = "http://localhost:8081/organization")
public interface CompanyServiceClient {

    // Kiểm tra tồn tại: gọi đúng endpoint và kiểu trả về
    @GetMapping("/company/{companyId}/exists")
    ApiResponse<Boolean> existsById(@PathVariable("companyId") String companyId);

    // Lấy chi tiết công ty: nhận đúng kiểu object trả về từ ApiResponse
    @GetMapping("/company/{companyId}")
    ApiResponse<CompanyResponse> getById(@PathVariable("companyId") String companyId);
}
