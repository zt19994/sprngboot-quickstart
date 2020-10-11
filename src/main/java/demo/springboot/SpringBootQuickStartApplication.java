package demo.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * SpringBootQuickStartApplication
 * <p>
 * EnableScheduling 开启定时任务
 *
 * @author zt1994
 */
@EnableScheduling
@SpringBootApplication
public class SpringBootQuickStartApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootQuickStartApplication.class, args);
    }

}
