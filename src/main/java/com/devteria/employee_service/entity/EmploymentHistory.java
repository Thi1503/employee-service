package com.devteria.employee_service.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "employment_history")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmploymentHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;

    @Column(length = 50)
    private String type; // TRANSFER, PROMOTION, LEAVE, RETURN

    @Column(length = 36)
    private String oldDepartmentId;

    @Column(length = 36)
    private String newDepartmentId;

    @Column(length = 36)
    private String oldPositionId;

    @Column(length = 36)
    private String newPositionId;

    @Column(length = 255)
    private String note;

    private LocalDate effectiveDate;

    @CreationTimestamp
    private LocalDateTime createdAt;
}
