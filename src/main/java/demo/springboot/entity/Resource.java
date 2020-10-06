package demo.springboot.entity;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * resource类
 *
 * @author zt1994
 * @date 2020/10/6 22:23
 */
@Configuration
@ConfigurationProperties(prefix = "com.opensource")
@PropertySource(value = "classpath:resource.properties")
public class Resource {

    /**
     * name
     */
    private String name;

    /**
     * 网站
     */
    private String website;

    /**
     * 语言
     */
    private String language;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
