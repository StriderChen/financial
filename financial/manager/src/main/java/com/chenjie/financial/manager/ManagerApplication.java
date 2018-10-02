package com.chenjie.financial.manager;

import com.chenjie.financial.swagger.EnableMySwagger;
import com.chenjie.financial.swagger.SwaggerConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Import;

/**
 * @Author chenjie
 * @Date 2018/9/9 15:16
 * @Description: 管理端
 */
@EntityScan("com.chenjie.financial.entity")
@SpringBootApplication
//@Import(SwaggerConfiguration.class) // 通过导入配置类实现swagger文档
@EnableMySwagger //通过添加自定义注解实现swagger文档
public class ManagerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ManagerApplication.class);
    }
}
