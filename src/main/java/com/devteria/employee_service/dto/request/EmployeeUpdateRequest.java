package com.devteria.employee_service.dto.request;

import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeUpdateRequest {
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
    private String departmentId;
    private String positionId;
    private BigDecimal salaryBasic;
    private String extraInfo;
    private String accountId;
}
