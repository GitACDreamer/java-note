package lelandacm.com.localdatetime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;

@SpringBootApplication
public class LocaldatetimeApplication {

    public static void main(String[] args) {
        SpringApplication.run(LocaldatetimeApplication.class, args);
    }

    @RestController
    public static class LocalDatetimeController{
        @GetMapping("/user")
        public UserDto user(UserDto userDto) throws Exception{
            return  userDto ;
        }
    }

    /**
     * {
     *     "username": "root",
     *     "birthday": "1991-01-01",
     *     "updateTime": "2020-10-08T11:11:11"
     * }
     */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
     public static class UserDto {
        private String username;
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
        private LocalDate birthday;
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
        private LocalDateTime updateTime ;
    }
}
