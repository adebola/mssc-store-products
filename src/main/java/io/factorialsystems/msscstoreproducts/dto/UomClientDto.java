package io.factorialsystems.msscstoreproducts.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Null;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UomClientDto {
    @Null(message = "Unit of Measure Id cannot be set, it is generated automatically")
    private String id;

    @NotEmpty(message = "Unit of Measure name must be specified")
    private String name;
}
