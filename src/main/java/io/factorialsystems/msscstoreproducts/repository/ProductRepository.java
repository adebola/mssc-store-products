package io.factorialsystems.msscstoreproducts.repository;

import com.github.pagehelper.Page;
import io.factorialsystems.msscstoreproducts.model.Product;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface ProductRepository {
    Product findById(String id);
    Page<Product> findAll();
    Product findBySkuCode(String code);
    int create(Product product);
    Boolean checkIfExistsBySku(String sku);
    Boolean checkIfProductExists(Map<String, String> map);
}
