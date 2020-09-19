package demo.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("demo.springboot.dao")
public class SpringBootQuickStartApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootQuickStartApplication.class, args);
    }

}
