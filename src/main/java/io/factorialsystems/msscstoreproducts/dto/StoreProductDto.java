package io.factorialsystems.msscstoreproducts.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StoreProductDto {
    private String templateId;
    private String productName;
    private String brand;
    private String imageUrl;
    private String description;
    List<StoreProductVariantDto> variants;
}
