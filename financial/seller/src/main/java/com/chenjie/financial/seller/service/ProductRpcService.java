package com.chenjie.financial.seller.service;

import com.chenjie.financial.api.ProductRpc;
import com.chenjie.financial.api.domain.ProductRpcReq;
import com.chenjie.financial.entity.Product;
import com.chenjie.financial.entity.enums.ProductStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import sun.rmi.runtime.Log;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author chenjie
 * @Date 2018/10/3 11:43
 * @Description: 产品相关服务
 */
@Service
@Slf4j
public class ProductRpcService {

    @Autowired
    private ProductRpc productRpc;

    public List<Product> findAll() {
        ProductRpcReq req = new ProductRpcReq();
        List<String> status = new ArrayList<>();
        status.add(ProductStatus.IN_SELL.name());
        req.setStatusList(status);

        log.info("rpc查询全部产品,请求参数:{}",req);
        List<Product> result = productRpc.query(req);
        log.info("rpc查询全部产品,请求结果:{}",result);
        return result;
    }

    public Product findOne() {
        String id = "001";
        Product product = productRpc.findOne(id);
        log.info("查询单个产品,结果:{}",product);
        return product;
    }

    @PostConstruct
    public void testFindAll() {
        findOne();
    }
}
