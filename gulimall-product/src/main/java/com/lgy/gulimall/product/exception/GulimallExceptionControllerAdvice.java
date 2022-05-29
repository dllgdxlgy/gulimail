package com.lgy.gulimall.product.exception;

import com.lgy.common.exception.BizCodeEnum;
import com.lgy.common.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

/**
 * 集中处理所有异常
 */
//统一处理异常,其中的参数是指所有的包下面的异常都会统一处理
@Slf4j
//@ResponseBody  //以 json 的方式写出去
//@ControllerAdvice(basePackages = "com.lgy.gulimall.product.controller")
@RestControllerAdvice(basePackages = "com.lgy.gulimall.product.controller") // 等于前面的两个注解和
public class GulimallExceptionControllerAdvice {


    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public R handleVaildException(MethodArgumentNotValidException e){
        log.error("数据校验出现问题：{},异常类型：{}",e.getMessage(),e.getClass());
        BindingResult bindingResult = e.getBindingResult();
        Map<String,String> errormap = new HashMap<>();
        bindingResult.getFieldErrors().forEach((fieldError) -> {
            //FieldError : 获取到的参数提示
            errormap.put(fieldError.getField(),fieldError.getDefaultMessage());
        });
        return R.error(BizCodeEnum.VAILD_EXCEPTION.getCode(),BizCodeEnum.VAILD_EXCEPTION.getMsg()).put("data",errormap);
    }

    @ExceptionHandler(value = Throwable.class)
    public R handleException(Throwable throwable){

        return R.error(BizCodeEnum.UNKNOW_EXCEPTION.getCode(), BizCodeEnum.UNKNOW_EXCEPTION.getMsg());
    }
}
