package com.chenjie.financial.manager.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author chenjie
 * @Date 2018/9/15 16:40
 * @Description:
 */
@ControllerAdvice(basePackages = "com.chenjie.financial.manager.controller")
public class ErrorControllerAdvice {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseEntity handleException(Exception e) {
        Map<String, Object> errorAttributes = new HashMap<>();
        String errorCode = e.getMessage();
        ErrorEnum errorEnum = ErrorEnum.getByCode(errorCode);
        errorAttributes.put("message", errorEnum.getMessage());
        errorAttributes.put("code", errorEnum.getCode());
        errorAttributes.put("canRetry",errorEnum.isCanRetry());
        errorAttributes.put("type","advice");
        return new ResponseEntity(errorAttributes, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
