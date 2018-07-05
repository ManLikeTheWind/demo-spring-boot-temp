package com.dongxiang.demospringboot10globalexception.config;

import com.dongxiang.demospringboot10globalexception.exception.CustomException;
import com.dongxiang.demospringboot10globalexception.exception.ErrorResponseEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * author:dongxiang
 * data:2018/7/5 15:49
 * email:dongxiang_android_sdk2@aliyun.com
 * description:
 * function:
 * using: 
 * note: 
 * <p>全局异常处理</p>
 * <li>1.@ControllerAdvic 捕获Controller层抛出的异常，如果添加@ResponseBody，则信息返回为Json格式</li>
 * <li>@RestControllerAdvice 相当于@ControllerAdvice + @ResponseBody 结合 </li>
 * <li>@ExceptionHandler 统一处理一种类的异常，减少代码重复率，降低复杂度</li>
 * <p/><p/>
 * <p>全局异常的使用</p>
 * <li>1.创建一个GlobalExceptionHandler 类</li>
 * <li>2.并添加，@RestControllerAdvice注解 就可以定义出异常通知类了</li>
 * <li>3.然后在定义的方法中添加上@ExceptionHandler 即可实现异常捕获</li>
 */
@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {CustomException.class})
    public ErrorResponseEntity customExceptionHandler(HttpServletRequest request, HttpServletResponse response, final Exception e){
        response.setStatus(HttpStatus.BAD_REQUEST.value());
        CustomException exception= (CustomException) e;
        return new ErrorResponseEntity(exception.getCode(), exception.getMessage());
    }

    @ExceptionHandler(value = {RuntimeException.class})
    public ErrorResponseEntity runtimeExceptionHandler(HttpServletRequest request,HttpServletResponse response,final Exception e){
        response.setStatus(HttpStatus.BAD_REQUEST.value());
        RuntimeException exception= (RuntimeException) e;
        return new ErrorResponseEntity(response.getStatus(), "异常信息："+exception.getMessage());
    }


    /**  通用的接口异常处理方法*/
    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body,
                                                             HttpHeaders headers, HttpStatus status,
                                                             WebRequest request) {
        if (ex instanceof MethodArgumentNotValidException){
            MethodArgumentNotValidException exception= (MethodArgumentNotValidException) ex;
            ErrorResponseEntity entity=new ErrorResponseEntity(status.value(),exception.getBindingResult().getAllErrors().get(0).getDefaultMessage());
            return new ResponseEntity<>(entity,status);
        }
        if (ex instanceof MethodArgumentTypeMismatchException){
            MethodArgumentTypeMismatchException exception= (MethodArgumentTypeMismatchException) ex;
            logger.error("参数转换失败，方法："+exception.getParameter().getMethod().getName()
                                    +"，参数："+exception.getName()
                                    +",信息："+exception.getLocalizedMessage());
            ErrorResponseEntity entity=new ErrorResponseEntity(status.value(),"参数转换失败");
            return  new ResponseEntity<>(entity,status);
        }

        return new ResponseEntity<>(new ErrorResponseEntity(status.value(),"异常信息："+ex.getMessage()),status);
    }
}
