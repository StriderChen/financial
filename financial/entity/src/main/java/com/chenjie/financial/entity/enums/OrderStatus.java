package com.chenjie.financial.entity.enums;

/**
 * @Author chenjie
 * @Date 2018/9/10 10:09
 * @Description:
 */
public enum OrderStatus {

    /**订单状态--初始化*/
    INIT("初始化"),

    /**订单装填--处理中*/
    PROCESS("处理中"),

    /**订单状态--成功*/
    SUCCESS("成功"),

    /**订单状态--失败*/
    FAIL("失败");

    private String desc;

    OrderStatus(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
