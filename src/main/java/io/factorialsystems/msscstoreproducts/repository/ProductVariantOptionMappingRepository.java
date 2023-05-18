package io.factorialsystems.msscstoreproducts.repository;

import io.factorialsystems.msscstoreproducts.model.ProductVariantOptionMapping;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductVariantOptionMappingRepository {
    void save(ProductVariantOptionMapping optionMapping);
    void deleteVariant(ProductVariantOptionMapping optionMapping);
    void deleteVariantOption(ProductVariantOptionMapping optionMapping);
    List<ProductVariantOptionMapping> findByProductId(String id);
    List<ProductVariantOptionMapping> findByVariantId(String id);
}
