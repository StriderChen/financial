package com.chenjie.financial.api;

import com.chenjie.financial.api.domain.ProductRpcReq;
import com.chenjie.financial.entity.Product;
import com.googlecode.jsonrpc4j.JsonRpcService;

import java.util.List;

/**
 * @Author chenjie
 * @Date 2018/10/2 23:21
 * @Description: 产品相关的rpc服务
 * @注意 请求路径必须不能以斜杠开头
 */
@JsonRpcService("rpc/products")
public interface ProductRpc {

    /**
     * 分页查询产品
     * @return
     */
    List<Product> query(ProductRpcReq req);

    /**
     * 查询单个产品
     * @param id
     * @return
     */
    Product findOne(String id);
}
