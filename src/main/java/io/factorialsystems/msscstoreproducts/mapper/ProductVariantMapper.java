package io.factorialsystems.msscstoreproducts.mapper;

import io.factorialsystems.msscstoreproducts.dto.ProductVariantClientDto;
import io.factorialsystems.msscstoreproducts.model.ProductVariant;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper
public interface ProductVariantMapper {
    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "name", target = "name"),
    })
    ProductVariantClientDto toClientDto(ProductVariant variant);

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "name", target = "name"),
    })
    ProductVariant toModel(ProductVariantClientDto dto);
}
