package demo.springboot.config;

import demo.springboot.controller.interceptor.OneInterceptor;
import demo.springboot.controller.interceptor.TwoInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 拦截器配置类
 *
 * @author zt1994
 * @date 2020/10/11 21:36
 */
@Configuration
public class MyWebMvcConfigurer implements WebMvcConfigurer {

    /**
     * 拦截器按照顺序执行
     * registry.addInterceptor(getInterceptor())//注册自定义拦截器
     * .addPathPatterns("/**")//拦截的请求路径
     * .excludePathPatterns("/error")//排除的请求路径
     * .excludePathPatterns("/static/*");
     *
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new TwoInterceptor()).addPathPatterns("/two/**")
        .addPathPatterns("/one/**");
        registry.addInterceptor(new OneInterceptor()).addPathPatterns("/one/**");
    }
}
