package com.chenjie.financial.seller.configuration;

import com.chenjie.financial.api.ProductRpc;
import com.googlecode.jsonrpc4j.spring.AutoJsonRpcClientProxyCreator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @Author chenjie
 * @Date 2018/10/3 11:47
 * @Description: RPC相关配置
 */
@Configuration
@Slf4j
@ComponentScan(basePackageClasses = {ProductRpc.class})
public class RpcConfiguration {
    @Bean
    public AutoJsonRpcClientProxyCreator rpcClientProxyCreator(@Value("${rpc.manager.url}") String url) {
        AutoJsonRpcClientProxyCreator creator = new AutoJsonRpcClientProxyCreator();
        try {
            creator.setBaseUrl(new URL(url));
        } catch (MalformedURLException e) {
            log.info("创建rpc服务地址错误,",e);
            e.printStackTrace();
        }
        creator.setScanPackage(ProductRpc.class.getPackage().getName());
        return creator;
    }
}
