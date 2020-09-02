package lelandacm.com.resfulapi;

import lombok.Data;

@Data
public class UserEntity {
    private Long id ;
    private String username;
    private String password;
    private Integer age;
    private String gender;
}
