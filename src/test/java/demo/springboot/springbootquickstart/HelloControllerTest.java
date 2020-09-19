package demo.springboot.springbootquickstart;

import demo.springboot.controller.HelloController;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author zt1994 2020/9/17 13:21
 */
public class HelloControllerTest {

    @Test
    public void testSayHello() {
        assertEquals("Hello World!",new HelloController().sayHello());
    }
}
