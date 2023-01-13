package com.fastcampus.newboardproject.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

@Disabled("Spring Data REST 통합테스트는 불필요하므로 제외시킴")
@DisplayName("Data REST - API 테스트")
@Transactional
@AutoConfigureMockMvc
@SpringBootTest
public class DataRestTest {

    private final MockMvc mvc;

    public DataRestTest(@Autowired MockMvc mvc) {
        this.mvc = mvc;
    }

    @DisplayName("[api] 게시글 리스트 조회")
    @Test
    void given_whenRequestingArticles_thenReturnsArticlesJsonResponse() throws Exception {
        // Given

        // When & Then
        mvc.perform(get("/api/articles"))   // 해당 링크 가져옴
            .andExpect(status().isOk())  // status가  OK인지 검사
            .andExpect(content().contentType(MediaType.valueOf("application/hal+json")));
        //  내용 검사는 hal+JSON이므로 MediaType.APPLICATION_JSON이 아니라 직접 입력해줌

    }

    @DisplayName("[api] 게시글 단건 조회")
    @Test
    void given_whenRequestingArticle_thenReturnsArticleJsonResponse() throws Exception {
        // Given

        // When & Then
        mvc.perform(get("/api/articles/1"))   // 해당 링크 가져옴
            .andExpect(status().isOk())  // status가  OK인지 검사
            .andExpect(content().contentType(MediaType.valueOf("application/hal+json")));
        //  내용 검사는 hal+JSON이므로 MediaType.APPLICATION_JSON이 아니라 직접 입력해줌

    }

    @DisplayName("[api] 게시글 -> 댓글 리스트 조회")
    @Test
    void given_whenRequestingArticleCommentsFromArticle_thenReturnsArticleCommentsJsonResponse() throws Exception {
        // Given

        // When & Then
        mvc.perform(get("/api/articles/1/articleComments"))   // 해당 링크 가져옴
            .andExpect(status().isOk())  // status가  OK인지 검사
            .andExpect(content().contentType(MediaType.valueOf("application/hal+json")));
        //  내용 검사는 hal+JSON이므로 MediaType.APPLICATION_JSON이 아니라 직접 입력해줌

    }

    @DisplayName("[api] 댓글 리스트 조회")
    @Test
    void given_whenRequestingArticleComments_thenReturnsArticleCommentsJsonResponse() throws Exception {
        // Given

        // When & Then
        mvc.perform(get("/api/articleComments"))   // 해당 링크 가져옴
            .andExpect(status().isOk())  // status가  OK인지 검사
            .andExpect(content().contentType(MediaType.valueOf("application/hal+json")));
        //  내용 검사는 hal+JSON이므로 MediaType.APPLICATION_JSON이 아니라 직접 입력해줌

    }

    @DisplayName("[api] 댓글 단건 조회")
    @Test
    void given_whenRequestingArticleComment_thenReturnsArticleCommentJsonResponse() throws Exception {
        // Given

        // When & Then
        mvc.perform(get("/api/articleComments/1"))   // 해당 링크 가져옴
            .andExpect(status().isOk())  // status가  OK인지 검사
            .andExpect(content().contentType(MediaType.valueOf("application/hal+json")));
        //  내용 검사는 hal+JSON이므로 MediaType.APPLICATION_JSON이 아니라 직접 입력해줌

    }

    @DisplayName("[api] 회원 관련 API 는 일체 제공하지 않는다.")
    @Test
    void givenNothing_whenRequestingUserAccounts_thenThrowsException() throws Exception {
        // Given

        // When & Then
        mvc.perform(get("/api/userAccounts")).andExpect(status().isNotFound());
        mvc.perform(post("/api/userAccounts")).andExpect(status().isNotFound());
        mvc.perform(put("/api/userAccounts")).andExpect(status().isNotFound());
        mvc.perform(patch("/api/userAccounts")).andExpect(status().isNotFound());
        mvc.perform(delete("/api/userAccounts")).andExpect(status().isNotFound());
        mvc.perform(head("/api/userAccounts")).andExpect(status().isNotFound());
    }

}
