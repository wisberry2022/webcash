package com.example.customloginapi.domain.Login.domain;

import lombok.*;

import java.util.Date;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class RequestDto {
    private String id;
    private String password;
    private Date assignDate;
    private String email;
}
