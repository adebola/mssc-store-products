package io.factorialsystems.msscstoreproducts.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Category {
    private String id;
    private String name;
    private String imageUrl;
    private Date createdOn;
    private String createdBy;
    private Boolean deleted;
    private String deletedBy;
    private Date deletedOn;
    private Boolean suspended;
}
