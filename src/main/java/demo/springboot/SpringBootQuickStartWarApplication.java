package demo.springboot;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * war 配置
 *
 * @author zt1994 2020/10/6 11:15
 */
public class SpringBootQuickStartWarApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {

        //ProjectApplication为原来的启动类
        return builder.sources(SpringBootQuickStartApplication.class);

    }

}
