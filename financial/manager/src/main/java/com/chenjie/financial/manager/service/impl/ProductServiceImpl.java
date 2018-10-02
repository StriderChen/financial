package com.chenjie.financial.manager.service.impl;

import com.chenjie.financial.entity.Product;
import com.chenjie.financial.entity.enums.ProductStatus;
import com.chenjie.financial.manager.error.ErrorEnum;
import com.chenjie.financial.manager.repositores.ProductRepository;
import com.chenjie.financial.manager.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.persistence.criteria.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author chenjie
 * @Date 2018/9/10 17:44
 * @Description:
 */
@Service
@Slf4j
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository repository;

    @Override
    public Product addProduct(Product product) {
        log.info("创建产品,参数 : {}",product);
        //数据校验
        checkProduct(product);
        //设置默认值
        setDefault(product);
        //保存数据库
        Product savedProduct = repository.save(product);
        log.info("创建产品,结果:{}", savedProduct);
        return savedProduct;
    }

    @Override
    public Product findOne(String id) {
        log.info("查询单个产品,参数: {}", id);
        Assert.notNull(id,"需要产品编号参数!");
        Product product = repository.findOne(id);
        log.info("查询单个产品,结果: {}", product);
        return product;
    }

    @Override
    public Page<Product> query(List<String> idList, BigDecimal minRewardRate, BigDecimal maxRewardRate, List<String> statusList, Pageable pageable) {

        log.info("复杂查询,参数:---idList:{}, ---minRewardRate:{},---maxRewardRate:{},---statusList:{},---pageable:{}",
                idList,minRewardRate,maxRewardRate,statusList,pageable);
        //lambdas 写法
        Specification<Product> specification =(Root<Product> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) -> {
            Expression<String> idCol = root.get("id");
            Expression<BigDecimal> rewardRateCol = root.get("rewardRate");
            Expression<String> statusCol = root.get("status");

            List<Predicate> predicates = new ArrayList<>();
            if (idList != null && idList.size() > 0) {
                predicates.add(idCol.in(idList));
            }
            if (minRewardRate != null && BigDecimal.ZERO.compareTo(minRewardRate) < 0) {
                predicates.add(criteriaBuilder.ge(rewardRateCol, minRewardRate));
            }
            if (maxRewardRate != null && BigDecimal.ZERO.compareTo(maxRewardRate) < 0) {
                predicates.add(criteriaBuilder.le(rewardRateCol, maxRewardRate));
            }
            if (statusList != null && statusList.size() > 0) {
                predicates.add(statusCol.in(statusList));
            }
            criteriaQuery.where(predicates.toArray(new Predicate[0]));
            return null;
         };

        Page<Product> allProducts = repository.findAll(specification, pageable);
        log.info("复杂查询,返回结果:{}",allProducts);
        return allProducts;
    }

    /**
     * 产品数据校验
     * 1. 非空数据
     * 2. 收益率要0-30以内
     * 3. 投资步长需为整数
     * @param product
     */
    private void checkProduct(Product product) {
        //Assert.notNull(product.getId(), "编号不可为空");
        Assert.notNull(product.getId(), ErrorEnum.ID_NOT_NULL.getCode());
        //其他非空校验
        Assert.isTrue(BigDecimal.ZERO.compareTo(product.getRewardRate()) < 0 && BigDecimal.valueOf(30).compareTo(product.getRewardRate()) >= 0, "收益率范围错误");
        Assert.isTrue(BigDecimal.valueOf(product.getStepAmount().longValue()).compareTo(product.getStepAmount()) == 0, "投资步长需为整数");
    }

    /**
     * 设置默认值
     * 创建时间、更新时间
     * 投资步长、锁定期、状态
     * @param product
     */
    private void setDefault(Product product) {
        if (product.getCreateAt() == null) {
            product.setCreateAt(new Date());
        }
        if (product.getUpdateAt() == null) {
            product.setUpdateAt(new Date());
        }
        if (product.getStepAmount() == null) {
            product.setStepAmount(BigDecimal.ZERO);
        }
        if (product.getLockTerm() == null) {
            product.setLockTerm(0);
        }
        if (product.getStatus() == null) {
            product.setStatus(ProductStatus.AUDITING.name());
        }
    }
}
