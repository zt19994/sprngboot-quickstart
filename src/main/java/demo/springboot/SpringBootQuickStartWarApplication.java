package demo.springboot;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

public class SpringBootQuickStartWarApplication extends SpringBootServletInitializer {

    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {

        //ProjectApplication为原来的启动类
        return builder.sources(SpringBootQuickStartApplication.class);

    }

}
