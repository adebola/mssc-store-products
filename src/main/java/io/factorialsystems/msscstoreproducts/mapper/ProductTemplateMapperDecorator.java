package io.factorialsystems.msscstoreproducts.mapper;

import io.factorialsystems.msscstoreproducts.dto.ProductTemplateClientDto;
import io.factorialsystems.msscstoreproducts.model.Category;
import io.factorialsystems.msscstoreproducts.model.ProductTemplate;
import io.factorialsystems.msscstoreproducts.repository.CategoryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
public class ProductTemplateMapperDecorator implements ProductTemplateMapper {
    private ProductTemplateMapper productTemplateMapper;
    private CategoryRepository categoryRepository;

    @Autowired
    public void setProductTemplateMapper(ProductTemplateMapper productTemplateMapper) {
        this.productTemplateMapper = productTemplateMapper;
    }

    @Autowired
    public void setCategoryRepository(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public ProductTemplateClientDto toClientDTO(ProductTemplate template) {
        return productTemplateMapper.toClientDTO(template);
    }

    @Override
    public ProductTemplate toModel(ProductTemplateClientDto dto) {
        ProductTemplate template = productTemplateMapper.toModel(dto);
        Category category = categoryRepository.findById(dto.getId());

        if (category == null) {
            final String errorMessage = String.format("Category: %s Not Found, Unable to create Product template", dto.getCategoryName());
            log.error(errorMessage);
            throw new RuntimeException(errorMessage);
        }

        template.setCategoryId(category.getId());
        template.setCategoryName(category.getName());

        return template;
    }
}
