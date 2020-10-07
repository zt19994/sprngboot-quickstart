package demo.springboot.exception;

import demo.springboot.entity.JsonResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * 自定义ajax异常处理助手类
 *
 * @author zt1994
 * @date 2020/10/7 20:44
 */
@RestControllerAdvice
public class MyAjaxExceptionHandler {

    /**
     * 默认异常处理
     *
     * @param req
     * @param e
     * @return
     * @throws Exception
     */
    @ExceptionHandler(value = Exception.class)
    public JsonResult defaultErrorHandler(HttpServletRequest req,
                                          Exception e) throws Exception {

        e.printStackTrace();
        return JsonResult.errorException(e.getMessage());
    }
}
