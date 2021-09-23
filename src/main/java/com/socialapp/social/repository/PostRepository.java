package com.socialapp.social.repository;

import com.socialapp.social.model.Category;
import com.socialapp.social.model.Post;
import com.socialapp.social.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findAllByCategory(Category category);
    List<Post> findByUser(User user);
}
