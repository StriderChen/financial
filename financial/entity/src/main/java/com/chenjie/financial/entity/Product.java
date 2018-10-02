package com.chenjie.financial.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author chenjie
 * @Date 2018/9/9 23:41
 * @Description: 产品
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product")
public class Product {

    @Id
    private String id;

    private String name;

    /**
     * @see com.chenjie.financial.entity.enums.ProductStatus
     */
    @ApiModelProperty(value = "状态",dataType = "com.chenjie.financial.entity.enums.ProductStatus")
    private String status;
    /**起投金额*/
    private BigDecimal thresholdAmount;
    /**投资步长*/
    private BigDecimal stepAmount;
    /**锁定期*/
    private Integer lockTerm;
    /**收益率,因为要与其他数相乘,所以要用BigDecimal*/
    private BigDecimal rewardRate;

    private String memo;

    private Date createAt;

    private Date updateAt;

    private String createUser;

    private String updateUser;

    public Product(String id, String name, String status, BigDecimal thresholdAmount, BigDecimal stepAmount, BigDecimal rewardRate) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.thresholdAmount = thresholdAmount;
        this.stepAmount = stepAmount;
        this.rewardRate = rewardRate;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.JSON_STYLE);
    }
}
