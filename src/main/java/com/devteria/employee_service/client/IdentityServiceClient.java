package com.devteria.employee_service.client;

import com.devteria.employee_service.dto.response.ApiResponse;
import com.devteria.employee_service.dto.response.UserResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "identity", url = "http://localhost:8080/identity")
public interface IdentityServiceClient {

//    @GetMapping("/users/{userId}")
//    Boolean existsById(@PathVariable("userId") String userId);

    @GetMapping("/users/{userId}")
    ApiResponse<UserResponse> getUser(@PathVariable("userId") String userId);
}
