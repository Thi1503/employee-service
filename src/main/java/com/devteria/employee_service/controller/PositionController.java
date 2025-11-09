package com.devteria.employee_service.controller;

import com.devteria.employee_service.dto.request.PositionCreateRequest;
import com.devteria.employee_service.dto.request.PositionUpdateRequest;
import com.devteria.employee_service.dto.response.ApiResponse;
import com.devteria.employee_service.dto.response.PositionResponse;
import com.devteria.employee_service.service.PositionService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "position")
@RestController
@RequestMapping("/position")
@RequiredArgsConstructor
@Slf4j
public class PositionController {

    private final PositionService positionService;


    @PostMapping
    public ApiResponse<PositionResponse> createPosition(@RequestBody PositionCreateRequest request) {
        log.info("POST /api/position - createPosition");
        return ApiResponse.<PositionResponse>builder()
                .result(positionService.createPosition(request))
                .build();
    }


    @GetMapping
    public ApiResponse<List<PositionResponse>> getAllPositions() {
        log.info("GET /api/position - getAllPositions");
        return ApiResponse.<List<PositionResponse>>builder()
                .result(positionService.getAllPositions())
                .build();
    }


    @GetMapping("/{id}")
    public ApiResponse<PositionResponse> getPositionById(@PathVariable String id) {
        log.info("GET /api/position/{} - getPositionById", id);
        return ApiResponse.<PositionResponse>builder()
                .result(positionService.getPositionById(id))
                .build();
    }


    @PutMapping("/{id}")
    public ApiResponse<PositionResponse> updatePosition(
            @PathVariable String id,
            @RequestBody PositionUpdateRequest request
    ) {
        log.info("PUT /api/position/{} - updatePosition", id);
        return ApiResponse.<PositionResponse>builder()
                .result(positionService.updatePosition(id, request))
                .build();
    }


    @DeleteMapping("/{id}")
    public ApiResponse<Void> deletePosition(@PathVariable String id) {
        log.info("DELETE /api/position/{} - deletePosition", id);
        positionService.deletePositionById(id);
        return ApiResponse.<Void>builder()
                .message("Xóa chức vụ thành công")
                .build();
    }
}
