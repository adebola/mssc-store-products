package io.factorialsystems.msscstoreproducts.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import io.factorialsystems.msscstoreproducts.dto.CategoryClientDto;
import io.factorialsystems.msscstoreproducts.dto.PagedDto;
import io.factorialsystems.msscstoreproducts.mapper.CategoryMapper;
import io.factorialsystems.msscstoreproducts.model.Category;
import io.factorialsystems.msscstoreproducts.repository.CategoryRepository;
import io.factorialsystems.msscstoreproducts.security.JwtTokenWrapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryMapper categoryMapper;
    private final CategoryRepository categoryRepository;

    public void clientSave(CategoryClientDto categoryClientDto) {
        Category c = categoryMapper.toModel(categoryClientDto);
        c.setCreatedBy(JwtTokenWrapper.getUserName());
        c.setId(UUID.randomUUID().toString());

        log.info("Saving category {}", c);

        categoryRepository.save(c);
    }

    public void clientUpdate (String id, CategoryClientDto categoryClientDto) {
        Category c = categoryMapper.toModel(categoryClientDto);
        c.setId(id);

        log.info("updating Category {}", c);

        categoryRepository.update(c);
    }

    public PagedDto<CategoryClientDto> findAll(Integer pageNumber, Integer pageSize) {

        log.info("Find All Categories PageNumber : {}, PageSize {}", pageNumber, pageSize);

        try (var ignored = PageHelper.startPage(pageNumber, pageSize)) {
            return createClientDto(categoryRepository.findAll());
        } catch (Exception ex) {
            log.error(ex.getMessage());
            throw new RuntimeException(ex.getMessage());
        }
    }

    public CategoryClientDto findById(String id) {
        log.info("Find Category by Id {}", id);
        return categoryMapper.toClientDto(categoryRepository.findById(id));
    }

    public PagedDto<CategoryClientDto> search(Integer pageNumber, Integer pageSize, String searchString) {
        log.info("Search Category PageNumber {}, PageSize {}, search String {}", pageNumber, pageSize, searchString);

        try (var ignored = PageHelper.startPage(pageNumber, pageSize)) {
            return createClientDto(categoryRepository.search(searchString));
        } catch (Exception ex) {
            log.error(ex.getMessage());
            throw new RuntimeException(ex.getMessage());
        }
    }

    public void clientDelete(String id) {
        log.info("Delete Category {}, deleted By {}", id, JwtTokenWrapper.getUserName());

        Map<String, String> map = new HashMap<>();
        map.put("id", id);
        map.put("deletedBy", JwtTokenWrapper.getUserName());

        categoryRepository.delete(map);
    }

    public void clientSuspend(String id) {
        log.info("Suspend Category {}", id);
        categoryRepository.suspend(id);
    }

    public void clientUnsuspend(String id) {
        log.info("Unsuspend Category {}", id);
        categoryRepository.unsuspend(id);
    }

    private PagedDto<CategoryClientDto> createClientDto(Page<Category> categories) {
        List<Category> result = categories.getResult();

        PagedDto<CategoryClientDto> pagedDto = new PagedDto<>();
        pagedDto.setTotalSize((int) categories.getTotal());
        pagedDto.setPageNumber(categories.getPageNum());
        pagedDto.setPageSize(categories.getPageSize());
        pagedDto.setPages(categories.getPages());
        pagedDto.setList(result.stream().map(categoryMapper::toClientDto).toList());

        return pagedDto;
    }
}
