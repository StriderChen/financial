package com.chenjie.financial.manager.service;

import com.chenjie.financial.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Author chenjie
 * @Date 2018/9/10 17:44
 * @Description:
 */
public interface ProductService {
    /**
     * 增加一个产品
     *
     * @param product
     * @return
     */
    Product addProduct(Product product);

    /**
     * 查询单个产品
     *
     * @param id 产品编号
     * @return
     */
    Product findOne(String id);

    /**
     *
     * @param idList
     * @param minRewardRate
     * @param maxRewardRate
     * @param statusList
     * @param pageable
     * @return
     */
    Page<Product> query(List<String> idList,BigDecimal minRewardRate,BigDecimal maxRewardRate,List<String> statusList,Pageable pageable);
}
