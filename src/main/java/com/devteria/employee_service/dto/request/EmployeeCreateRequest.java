package com.devteria.employee_service.dto.request;

import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeCreateRequest {
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
    private String positionId; // chỉ truyền ID, map sang entity bên service
    private BigDecimal salaryBasic;
    private String extraInfo;
}
