package com.chenjie.financial.api;

import com.chenjie.financial.entity.Product;
import com.googlecode.jsonrpc4j.JsonRpcService;
import org.springframework.data.domain.Page;

/**
 * @Author chenjie
 * @Date 2018/10/2 23:21
 * @Description: 产品相关的rpc服务
 */
@JsonRpcService("/products")
public interface ProductRpc {

    Page<Product> query();
}
