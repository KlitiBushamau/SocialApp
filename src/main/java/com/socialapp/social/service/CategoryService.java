package com.socialapp.social.service;

import com.socialapp.social.dto.CategoryDto;
import com.socialapp.social.exception.SocialAppException;
import com.socialapp.social.mapper.CategoryMapper;
import com.socialapp.social.model.Category;
import com.socialapp.social.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@AllArgsConstructor
@Slf4j
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    @Transactional
    public CategoryDto save(CategoryDto categoryDto) {
        Category save = categoryRepository.save(categoryMapper.mapDtoToCategory(categoryDto));
        categoryDto.setId(save.getId());
        return categoryDto;
    }

    @Transactional(readOnly = true)
    public List<CategoryDto> getAll() {
        return categoryRepository.findAll()
                .stream()
                .map(categoryMapper::mapCategoryToDto)
                .collect(toList());
    }

    public CategoryDto getCategory(Long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new SocialAppException("No category found with ID - " + id));
        return categoryMapper.mapCategoryToDto(category);
    }
}
