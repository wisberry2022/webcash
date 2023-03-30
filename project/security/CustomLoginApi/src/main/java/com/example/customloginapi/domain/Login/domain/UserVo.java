package com.example.customloginapi.domain.Login.domain;

import lombok.*;

import java.util.Date;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserVo {
    private String id;
    private String password;
    private Date assignDate;
    private String email;
}
