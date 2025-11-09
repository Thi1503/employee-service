package com.devteria.employee_service.service;

import com.devteria.employee_service.dto.request.PositionCreateRequest;
import com.devteria.employee_service.dto.request.PositionUpdateRequest;
import com.devteria.employee_service.dto.response.PositionResponse;
import com.devteria.employee_service.entity.Position;
import com.devteria.employee_service.exception.AppException;
import com.devteria.employee_service.exception.ErrorCode;
import com.devteria.employee_service.mapper.PositionMapper;
import com.devteria.employee_service.repository.PositionRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class PositionService {

    PositionRepository positionRepository;
    PositionMapper positionMapper;

    public PositionResponse createPosition(PositionCreateRequest request) {
        log.info("In method createPosition with name={}", request.getName());

        // Kiểm tra trùng tên chức vụ (nếu cần)
        if (positionRepository.existsByName(request.getName())) {
            throw new AppException(ErrorCode.POSITION_EXISTED);
        }

        Position position = positionMapper.toPosition(request);
        Position saved = positionRepository.save(position);
        return positionMapper.toPositionResponse(saved);
    }


    public List<PositionResponse> getAllPositions() {
        log.info("In method getAllPositions");
        return positionRepository.findAll()
                .stream()
                .map(positionMapper::toPositionResponse)
                .toList();
    }


    public PositionResponse getPositionById(String id) {
        log.info("In method getPositionById with id={}", id);

        Position position = positionRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.POSITION_NOT_FOUND));

        return positionMapper.toPositionResponse(position);
    }


    public PositionResponse updatePosition(String id, PositionUpdateRequest request) {
        log.info("In method updatePosition with id={}", id);

        Position position = positionRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.POSITION_NOT_FOUND));

        positionMapper.updatePosition(position, request);
        Position updated = positionRepository.save(position);
        return positionMapper.toPositionResponse(updated);
    }


    public void deletePositionById(String id) {
        log.info("In method deletePositionById with id={}", id);

        if (!positionRepository.existsById(id)) {
            throw new AppException(ErrorCode.POSITION_NOT_FOUND);
        }

        positionRepository.deleteById(id);
    }
}
