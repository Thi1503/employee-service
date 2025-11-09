package com.devteria.employee_service.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DepartmentResponse {
    private String id;
    private String name;
    private String description;
    private String departmentCode;
    private String headOfDepartment;
    private Integer staffCount;
    private Boolean active;
    private String companyId;
    private String companyName;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
}
