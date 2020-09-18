package demo.springboot.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * @author zt1994 2020/9/17 16:35
 */
@Entity
public class User implements Serializable {

    /**
     * id
     */
    @Id
    @GeneratedValue
    private Long id;

    /**
     * 名称
     */
    @NotEmpty(message = "姓名不能为空")
    @Size(min = 2, max = 8, message = "姓名长度必须大于 2 且小于 20 字")
    private String name;

    /**
     * 年龄
     */
    @NotNull(message = "年龄不能为空")
    @Min(value = 0, message = "年龄大于0")
    @Max(value = 200, message = "年龄不大于200")
    private Integer age;

    /**
     * 出生时间
     */
    @NotEmpty(message = "出生时间不能为空")
    private String birthday;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", birthday='" + birthday + '\'' +
                '}';
    }
}
