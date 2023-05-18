package io.factorialsystems.msscstoreproducts.repository;

import com.github.pagehelper.Page;
import io.factorialsystems.msscstoreproducts.model.ProductTemplate;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface ProductTemplateRepository {
    void save(ProductTemplate productTemplate);
    void update (ProductTemplate productTemplate);
    Page<ProductTemplate> search(String name);
    ProductTemplate findById(String id);
    Page<ProductTemplate> findAll();
    void suspend(String id);
    void unsuspend(String id);
    void delete (Map<String, String> parameters);
}
