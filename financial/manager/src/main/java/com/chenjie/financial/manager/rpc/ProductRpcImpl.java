package com.chenjie.financial.manager.rpc;

import com.chenjie.financial.api.ProductRpc;
import com.chenjie.financial.api.domain.ProductRpcReq;
import com.chenjie.financial.entity.Product;
import com.chenjie.financial.manager.service.ProductService;
import com.googlecode.jsonrpc4j.spring.AutoJsonRpcServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author chenjie
 * @Date 2018/10/3 11:15
 * @Description:
 */
@AutoJsonRpcServiceImpl
@Service
@Slf4j
public class ProductRpcImpl implements ProductRpc {

    @Autowired
    private ProductService productService;

    @Override
    public List<Product> query(ProductRpcReq req) {
        log.info("查询多个产品,请求参数为:{}", req);

        Pageable pageable = new PageRequest(0, 1000, Sort.Direction.DESC, "rewardRate");
        Page<Product> result = productService.query(req.getIdList(), req.getMinRewardRate(), req.getMaxRewardRate(), req.getStatusList(), pageable);
        log.info("查询多个产品,请求结果为:{}", result);
        return result.getContent();
    }

    @Override
    public Product findOne(String id) {
        log.info("查询单个产品,请求参数为:{}", id);
        Product product = productService.findOne(id);
        log.info("查询单个产品,请求结果为:{}", product);
        return product;
    }
}
