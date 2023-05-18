package io.factorialsystems.msscstoreproducts.repository;

import com.github.pagehelper.Page;
import io.factorialsystems.msscstoreproducts.model.ProductVariant;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface ProductVariantRepository {
    void save(ProductVariant pv);

    void update(ProductVariant pv);

    ProductVariant findById(String id);

    Page<ProductVariant> findAll();

    void suspend(String id);

    void unsuspend(String id);

    void delete(Map<String, String> parameters);

    ProductVariant findByIdOrName(String id);

    Page<ProductVariant> search(String search);
}
