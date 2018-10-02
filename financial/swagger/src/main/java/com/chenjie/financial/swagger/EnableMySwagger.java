package com.chenjie.financial.swagger;

import org.springframework.context.annotation.Import;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.lang.annotation.*;

/**
 * @Author chenjie
 * @Date 2018/9/30 23:48
 * @Description: 通过注解实现swagger文档自动生成功能
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Documented
@Import(SwaggerConfiguration.class)
@EnableSwagger2 //组合注解
public @interface EnableMySwagger {
}
