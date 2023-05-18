package io.factorialsystems.msscstoreproducts.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductVariant {
    private String id;
    private String name;
    private Date createdOn;
    private String createdBy;
    private Boolean suspended;
    private Boolean deleted;
    private String deletedBy;
    private Date deletedOn;
}
