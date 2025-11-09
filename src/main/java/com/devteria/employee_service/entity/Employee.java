package com.devteria.employee_service.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "employee")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(nullable = false, unique = true, length = 50)
    private String code;

    @Column(nullable = false, length = 150)
    private String fullName;

    @Column(length = 10)
    private String gender; // MALE, FEMALE, OTHER

    private LocalDate dateOfBirth;

    @Column(length = 50)
    private String phoneNumber;

    @Column(length = 150)
    private String email;

    @Column(length = 255)
    private String address;

    @Column(length = 20)
    private String citizenId;

    private LocalDate issuedDate;

    @Column(length = 150)
    private String issuedPlace;

    private LocalDate startWorkDate;

    private LocalDate endWorkDate;

    @Column(length = 50)
    private String employmentStatus; // ACTIVE, INACTIVE, ON_LEAVE, TERMINATED

    @Column(length = 36)
    private String companyId; // từ organization-service

    @Column(length = 36)
    private String departmentId; // từ organization-service

    @Column(length = 36)
    private String accountId; // từ identity-service (liên kết tài khoản đăng nhập)

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "position_id")
    private Position position;

    private BigDecimal salaryBasic;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Contract> contracts;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FamilyMember> familyMembers;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<EmploymentHistory> employmentHistories;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @Column(columnDefinition = "JSON")
    private String extraInfo;
}
