package com.chenjie.financial.manager.controller;

import com.chenjie.financial.entity.Product;
import com.chenjie.financial.manager.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author chenjie
 * @Date 2018/9/9 22:14
 * @Description:
 */
@RestController
@RequestMapping(value = "/products")
@Slf4j
@Api(tags = "product",description = "产品相关")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping(value = "hello")
    public String hello() {
        return "欢迎来到springboot理财产品平台";
    }

    /**
     * 新增一个产品
     * @param product
     * @return
     */
    @ApiOperation(value = "创建产品",notes = "根据对应业务规则添加相应的产品")
    @PostMapping(value = "")
    public Product addProduct(Product product) {
        Product addedProduct = productService.addProduct(product);
        return addedProduct;
    }

    /**
     * 查询单个产品
     * @param id
     * @return
     */
    @GetMapping(value = "/{id}")
    public Product findOne(@PathVariable(value = "id") String id) {
        Product product = productService.findOne(id);
        return product;
    }

    @GetMapping(value = "")
    public Page<Product> query(String ids, BigDecimal minRewardRate,BigDecimal maxRewardRate,
                               String status,@RequestParam(defaultValue = "0") Integer pageNum,
                               @RequestParam(defaultValue = "10") Integer pageSize) {
        List<String> idList = null, statusList = null;
        if (!StringUtils.isEmpty(ids)) {
            idList = Arrays.asList(ids.split(","));
        }
        if(!StringUtils.isEmpty(status)){
            statusList = Arrays.asList(status.split(","));
        }

        Pageable pageable = new PageRequest(pageNum, pageSize);
        Page<Product> products = productService.query(idList, minRewardRate, maxRewardRate, statusList, pageable);
        return products;
    }
}

