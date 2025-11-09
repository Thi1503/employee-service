package com.devteria.employee_service.mapper;

import com.devteria.employee_service.dto.request.PositionCreateRequest;
import com.devteria.employee_service.dto.request.PositionUpdateRequest;
import com.devteria.employee_service.dto.response.PositionResponse;
import com.devteria.employee_service.entity.Position;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface PositionMapper {

    // Map từ request -> entity
    Position toPosition(PositionCreateRequest request);

    // Map từ entity -> response
    PositionResponse toPositionResponse(Position position);

    // Update entity bằng request update
    void updatePosition(@MappingTarget Position position, PositionUpdateRequest request);
}
