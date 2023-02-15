package com.fastcampus.newboardproject.request;

import com.fastcampus.newboardproject.dto.ArticleCommentDto;
import com.fastcampus.newboardproject.dto.UserAccountDto;

public record ArticleCommentRequest(Long articleId, String content) {

    public static ArticleCommentRequest of(Long articleId, String content) {
        return new ArticleCommentRequest(articleId, content);
    }

    public ArticleCommentDto toDto(UserAccountDto userAccountDto) {
        return ArticleCommentDto.of(
            articleId,
            userAccountDto,
            content
        );
    }
}
