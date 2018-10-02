package com.chenjie.financial.entity.enums;

import lombok.Data;

/**
 * @Author chenjie
 * @Date 2018/9/10 0:11
 * @Description:
 */
public enum ProductStatus {

    /**审核中状态*/
    AUDITING("审核中"),

    /**销售中*/
    IN_SELL("销售中"),

    /**暂停销售*/
    LOCKED("暂停销售"),

    /**已结束销售*/
    FINISHED("已结束");

    private String desc;

    ProductStatus(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
