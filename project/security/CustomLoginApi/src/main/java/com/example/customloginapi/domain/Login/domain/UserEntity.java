package com.example.customloginapi.domain.Login.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class UserEntity {
    @Id
    private String id;
    private String password;
    private Date assignDate;
    private String email;

    public UserVo getEntity() {
        return UserVo.builder()
                .id(id).password(password).assignDate(assignDate).email(email)
                .build();
    }
}
