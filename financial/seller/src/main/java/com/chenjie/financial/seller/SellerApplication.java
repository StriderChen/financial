package com.chenjie.financial.seller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

/**
 * @Author chenjie
 * @Date 2018/10/3 11:38
 * @Description: 销售端启动类
 */
//@EntityScan("com.chenjie.financial.entity")
@SpringBootApplication
public class SellerApplication {
    public static void main(String[] args) {
        SpringApplication.run(SellerApplication.class);
    }
}
