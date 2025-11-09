package com.devteria.employee_service.dto.response;

import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeResponse {
    private String id;
    private String code;
    private String fullName;
    private String gender;
    private LocalDate dateOfBirth;
    private String phoneNumber;
    private String email;
    private String address;
    private String citizenId;
    private LocalDate issuedDate;
    private String issuedPlace;
    private LocalDate startWorkDate;
    private LocalDate endWorkDate;
    private String employmentStatus;
    private String companyId;
    private String departmentId;
    private String accountId;
    private String positionId;
    private BigDecimal salaryBasic;
    private List<String> contractIds;
    private List<String> familyMemberIds;
    private List<String> employmentHistoryIds;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String extraInfo;
}
