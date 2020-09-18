package demo.springboot.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * people 配置
 *
 * @author zt1994 2020/9/17 12:02
 */
@Component
public class PeopleProperties {

    /**
     * 名称
     */
    @Value("${demo.people.name}")
    private String name;

    /**
     * 年龄
     */
    @Value("${demo.people.age}")
    private String age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
