package lelandacm.com.springall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringAllApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringAllApplication.class, args);
    }

    @GetMapping("/")
    public String hello(@RequestParam(required = false, defaultValue = "world!") String name){
        return "hello " + name;
    }
}
