package com.lelandacm.globalexception;

import lombok.Data;

@Data
public class UserEntity {
    private Long id;

    private String username;

    private String password;

    private String email;

    private String telephone;

    private Integer age;

    private String gender;
}
