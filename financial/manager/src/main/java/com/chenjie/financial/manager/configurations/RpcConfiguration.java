package com.chenjie.financial.manager.configurations;

import com.googlecode.jsonrpc4j.spring.AutoJsonRpcServiceImplExporter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author chenjie
 * @Date 2018/10/3 11:23
 * @Description:
 */
@Configuration
public class RpcConfiguration {

    @Bean
    public AutoJsonRpcServiceImplExporter rpcServiceImplExporter() {
        return new AutoJsonRpcServiceImplExporter();
    }
}
