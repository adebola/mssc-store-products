package io.factorialsystems.msscstoreproducts.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductVariantOptionMapping {
    private String productId;
    private String productVariantId;
    private String productVariantOptionId;
}
