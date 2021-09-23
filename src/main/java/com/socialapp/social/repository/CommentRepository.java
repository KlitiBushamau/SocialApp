package com.socialapp.social.repository;

import com.socialapp.social.model.Comment;
import com.socialapp.social.model.Post;
import com.socialapp.social.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findByPost(Post post);
    List<Comment> findAllByUser(User user);
}
