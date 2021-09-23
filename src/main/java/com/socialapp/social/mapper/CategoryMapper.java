package com.socialapp.social.mapper;

import com.socialapp.social.dto.CategoryDto;
import com.socialapp.social.model.Category;
import com.socialapp.social.model.Post;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    @Mapping(target = "numberOfPosts", expression = "java(mapPosts(category.getPosts()))")
    CategoryDto mapCategoryToDto(Category category);

    default Integer mapPosts(List<Post> numberOfPosts) {
        return numberOfPosts.size();
    }

    @InheritInverseConfiguration
    @Mapping(target = "posts", ignore = true)
    Category mapDtoToCategory(CategoryDto categoryDto);
}
