package com.devteria.employee_service.repository;

import com.devteria.employee_service.entity.Position;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PositionRepository extends JpaRepository<Position,String> {
    boolean existsByName(String name);

}
