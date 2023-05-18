package io.factorialsystems.msscstoreproducts.mapper;

import io.factorialsystems.msscstoreproducts.dto.UomClientDto;
import io.factorialsystems.msscstoreproducts.model.Uom;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper
public interface UomMapper {
    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "name", target = "name")
    })
    UomClientDto toClientDto(Uom uom);

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "name", target = "name")
    })
    Uom toModel(UomClientDto uomClientDto);
}
