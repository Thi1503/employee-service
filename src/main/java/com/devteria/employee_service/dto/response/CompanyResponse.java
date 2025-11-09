package com.devteria.employee_service.dto.response;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CompanyResponse {

    private String id;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;

    private Integer staffAmount;
    private String defaultRoleForStaff;
    private Boolean isUseIcare;
    private Boolean active;
    private Boolean checkInit;

    private String name;
    private String email;
    private String phoneNumber;
    private String taxCode;
    private String representative;
    private String registedAddress;
    private String address;

    private Boolean updateRelationship;
    private Integer availableContract;
    private String companyCode;

    /** Trường dữ liệu mở rộng JSON */
    private String extraInfo;
}
