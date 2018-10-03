package com.chenjie.financial.annotation;

import java.lang.annotation.*;

/**
 * @Author chenjie
 * @Date 2018/10/3 10:47
 * @Description: 自定义一个json格式的tostring方法的注解
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.SOURCE)
@Inherited
public @interface JsonToString {
}
