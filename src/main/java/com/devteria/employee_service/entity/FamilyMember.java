package com.devteria.employee_service.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "family_member")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FamilyMember {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;

    @Column(nullable = false, length = 150)
    private String fullName;

    @Column(length = 50)
    private String relation; // Cha, Mẹ, Vợ, Con,...

    private LocalDate dateOfBirth;

    @Column(length = 20)
    private String phoneNumber;

    private Boolean isDependent = false;

    @CreationTimestamp
    private LocalDateTime createdAt;
}
