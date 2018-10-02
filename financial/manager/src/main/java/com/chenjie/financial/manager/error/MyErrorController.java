package com.chenjie.financial.manager.error;

import org.springframework.boot.autoconfigure.web.BasicErrorController;
import org.springframework.boot.autoconfigure.web.ErrorAttributes;
import org.springframework.boot.autoconfigure.web.ErrorProperties;
import org.springframework.boot.autoconfigure.web.ErrorViewResolver;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * @Author chenjie
 * @Date 2018/9/14 16:59
 * @Description:
 */
public class MyErrorController extends BasicErrorController {

    public MyErrorController(ErrorAttributes errorAttributes, ErrorProperties errorProperties, List<ErrorViewResolver> errorViewResolvers) {
        super(errorAttributes, errorProperties, errorViewResolvers);
    }

    /*{
        x "timestamp": "2018-09-14 17:23:30",
        x "status": 500,
        x "error": "Internal Server Error",
        x "exception": "java.lang.IllegalArgumentException",
        "message": "编号不可为空",
        x "path": "/financial/manager/products"
        +code
    }*/


    @Override
    protected Map<String, Object> getErrorAttributes(HttpServletRequest request, boolean includeStackTrace) {
        Map<String, Object> errorAttributes = super.getErrorAttributes(request, includeStackTrace);
        errorAttributes.remove("timestamp");
        errorAttributes.remove("status");
        errorAttributes.remove("error");
        errorAttributes.remove("exception");
        errorAttributes.remove("path");
        String errorCode = (String) errorAttributes.get("message");
        ErrorEnum errorEnum = ErrorEnum.getByCode(errorCode);
        errorAttributes.put("message", errorEnum.getMessage());
        errorAttributes.put("code", errorEnum.getCode());
        errorAttributes.put("canRetry",errorEnum.isCanRetry());
        return errorAttributes;
    }
}
