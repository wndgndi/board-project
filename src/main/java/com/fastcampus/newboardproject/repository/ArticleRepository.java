package com.fastcampus.newboardproject.repository;

import com.fastcampus.newboardproject.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {

}