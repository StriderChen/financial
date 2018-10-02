package com.chenjie.financial.manager.error;

import lombok.Data;

/**
 * @Author chenjie
 * @Date 2018/9/14 17:45
 * @Description: 错误种类
 */
public enum ErrorEnum {
    /**
     * 编号不可为空
     */
    ID_NOT_NULL("F001","编号不可为空",false),
    /**
     * 未知异常
     */
    UNKNOWN("999","未知异常",false);
    private String code;
    private String message;
    private boolean canRetry;

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public boolean isCanRetry() {
        return canRetry;
    }

    ErrorEnum(String code, String message, boolean canRetry) {
        this.code = code;
        this.message = message;
        this.canRetry = canRetry;
    }

    public static ErrorEnum getByCode(String code) {
        for (ErrorEnum errorEnum : ErrorEnum.values()) {
            if (errorEnum.code.equals(code)) {
                return errorEnum;
            }
        }
        return UNKNOWN;
    }
}
