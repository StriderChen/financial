package com.chenjie.financial.manager.repositores;

import com.chenjie.financial.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @Author chenjie
 * @Date 2018/9/10 17:35
 * @Description:
 */
public interface ProductRepository extends JpaRepository<Product,String>, JpaSpecificationExecutor<Product> {
}
