package io.factorialsystems.msscstoreproducts.mapper;

import io.factorialsystems.msscstoreproducts.dto.ProductTemplateClientDto;
import io.factorialsystems.msscstoreproducts.model.ProductTemplate;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper
@DecoratedWith(ProductTemplateMapperDecorator.class)
public interface ProductTemplateMapper {
    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "brand", target = "brand"),
            @Mapping(source = "imageUrl", target = "imageUrl"),
            @Mapping(source = "description", target = "description"),
            @Mapping(source = "categoryName", target = "categoryName")
    })
    ProductTemplateClientDto toClientDTO(ProductTemplate template);

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "brand", target = "brand"),
            @Mapping(source = "imageUrl", target = "imageUrl"),
            @Mapping(source = "description", target = "description"),
            @Mapping(target = "categoryName", ignore = true),
    })
    ProductTemplate toModel(ProductTemplateClientDto dto);
}
