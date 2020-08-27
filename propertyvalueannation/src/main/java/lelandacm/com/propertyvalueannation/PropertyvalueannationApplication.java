package lelandacm.com.propertyvalueannation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
/*
 * 允许开启注解对象
 */
@EnableConfigurationProperties(AcmeProperties.class)
public class PropertyvalueannationApplication {
    @Value("${root.username}")
    private String username ;
    @Value("${root.password}")
    private String password ;

    public static void main(String[] args) {
        SpringApplication.run(PropertyvalueannationApplication.class, args);
    }

    @Bean
    public void test(){
        System.out.println("username: " + username + " password: " + password);
    }

}
