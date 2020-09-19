package demo.springboot.controller;

import demo.springboot.config.PeopleProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * hello controller
 *
 * @author zt1994 2020/9/17 11:15
 */
@RestController
public class HelloController {

    @Autowired
    private PeopleProperties peopleProperties;


    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String sayHello() {
        return "Hello World!";
    }


    @RequestMapping(value = "/people", method = RequestMethod.GET)
    public String peopleInfo() {
        return "people:" + peopleProperties.getName() + " age:" + peopleProperties.getAge() + "!";
    }

}
