package com.chenjie.financial.manager;

import com.chenjie.financial.entity.Product;
import com.chenjie.financial.entity.enums.ProductStatus;
import com.chenjie.financial.util.RestUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.util.Assert;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author chenjie
 * @Date 2018/9/16 16:41
 * @Description:
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerTest {

    private static RestTemplate template = new RestTemplate();

    @Autowired
    private MockMvc mvc;

    @Value("http://localhost:8888/financial/manager")
    private String baseUrl;

    //正常的产品数据
    private static List<Product> normals = new ArrayList<>();

    @BeforeClass
    public static void init() {
        Product p1 = new Product("T001","灵活宝1号", ProductStatus.AUDITING.name(),
                BigDecimal.valueOf(10),BigDecimal.valueOf(1),BigDecimal.valueOf(3.42));
        Product p2 = new Product("T002","活期盈-金色人生", ProductStatus.AUDITING.name(),
                BigDecimal.valueOf(10),BigDecimal.valueOf(0),BigDecimal.valueOf(3.28));
        Product p3 = new Product("T003","朝朝盈-聚财", ProductStatus.AUDITING.name(),
                BigDecimal.valueOf(100),BigDecimal.valueOf(10),BigDecimal.valueOf(3.86));
        normals.add(p1);
        normals.add(p2);
        normals.add(p3);
    }

    @Test
    public void createProduct() {
        log.info("请求URL:{}/{}",baseUrl,"products");
        normals.forEach(product -> {
            Product result = RestUtil.postJSON(template, baseUrl + "/products", product, Product.class);
            Assert.notNull(result.getCreateAt(),"数据插入失败!");
        });

    }

}
