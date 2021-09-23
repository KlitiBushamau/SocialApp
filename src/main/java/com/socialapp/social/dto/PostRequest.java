package com.socialapp.social.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostRequest {
    private Long postId;
    private String categoryName;
    private String postName;
    private String url;
    private String description;
}
