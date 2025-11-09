package com.devteria.employee_service.dto.request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PositionUpdateRequest {

    private String name;

    private String description;

    private Boolean active;

}
