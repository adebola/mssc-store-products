package io.factorialsystems.msscstoreproducts.mapper;


import io.factorialsystems.msscstoreproducts.dto.CategoryClientDto;
import io.factorialsystems.msscstoreproducts.model.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper
public interface CategoryMapper {
    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "imageUrl", target = "imageUrl")
    })
    CategoryClientDto toClientDto(Category category);
    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "imageUrl", target = "imageUrl"),
            @Mapping(target = "createdOn", ignore = true),
            @Mapping(target = "createdBy", ignore = true)
    })
    Category toModel(CategoryClientDto categoryClientDto);
}
