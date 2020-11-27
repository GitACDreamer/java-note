package com.lelandacm.jdbc;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

@Data
@ApiModel("用户信息")
public class UserEntity {
    @ApiModelProperty("id")
    private Long id;

    @Length(min = 4, max = 80)
    @ApiModelProperty("用户名")
    private String username;

    @Pattern(regexp = "^(?![a-zA-Z]+$)(?![A-Z0-9]+$)(?![A-Z\\W_]+$)(?![a-z0-9]+$)(?![a-z\\W_]+$)(?![0-9\\W_]+$)" +
            "[a-zA-Z0-9\\W_]{8,}$")
    @ApiModelProperty("密码")
    private String password;

    @ApiModelProperty("姓名")
    @Length(min = 2, max = 80)
    private String name ;

    @Email
    @ApiModelProperty("电子邮箱")
    private String email;

    @ApiModelProperty("手机号")
    @Pattern(regexp = "^1\\d{10}$")
    private String telephone;

    @Min(value = 1)
    @Max(value = 150)
    @ApiModelProperty("年龄")
    private Integer age;

    @ApiModelProperty("性别")
    private String gender;
}
