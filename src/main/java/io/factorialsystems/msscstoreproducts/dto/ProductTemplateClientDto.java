package io.factorialsystems.msscstoreproducts.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Null;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductTemplateClientDto {
    @Null(message = "Product Id cannot be set, it is generated automatically")
    private String id;

    @NotEmpty(message = "Product name must be specified")
    private String name;

    private String brand;
    private String imageUrl;
    private String description;

    @NotEmpty(message = "Product mus have a category")
    private String categoryName;
}
