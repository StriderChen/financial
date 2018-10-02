package com.chenjie.financial.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author chenjie
 * @Date 2018/9/9 23:40
 * @Description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "saller_order")
public class Order {

    @Id
    private String orderId;

    /**渠道id*/
    private String chanId;

    private String chanUserId;

    /**
     * @see com.chenjie.financial.entity.enums.OrderType
     */
    private String orderType;

    private String productId;

    private BigDecimal amount;

    private String outerOrderId;

    /**
     * @see com.chenjie.financial.entity.enums.OrderStatus
     */
    private String orderStatus;

    private String memo;

    private Date createAt;

    private Date updateAt;

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.JSON_STYLE);
    }
}
