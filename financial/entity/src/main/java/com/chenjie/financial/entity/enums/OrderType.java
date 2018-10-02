package com.chenjie.financial.entity.enums;

/**
 * @Author chenjie
 * @Date 2018/9/10 10:06
 * @Description:
 */
public enum OrderType {

    /**订单类型--申购*/
    APPLY("申购"),

    /**订单类型--赎回*/
    REDEEM("赎回");

    private String desc;

    OrderType(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
