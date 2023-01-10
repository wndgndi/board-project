package com.fastcampus.newboardproject.repository;

import com.fastcampus.newboardproject.domain.Article;
import com.fastcampus.newboardproject.domain.QArticle;
import com.querydsl.core.types.dsl.DateTimeExpression;
import com.querydsl.core.types.dsl.SimpleExpression;
import com.querydsl.core.types.dsl.StringExpression;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ArticleRepository extends
    JpaRepository<Article, Long>,
    QuerydslPredicateExecutor<Article>,
    // Article 엔티티 안의 모든 필드에 대한 기본 검색기능을 추가해줌
    QuerydslBinderCustomizer<QArticle>
    // 기본적인 검색 기능 외에 원하는 검색 기능을 만들기 위해 사용
{

    @Override
    default void customize(QuerydslBindings bindings, QArticle root) {
        bindings.excludeUnlistedProperties(true);
        // excludeUnlistedProperties를 사용해 listing을 하지 않은 property를 검색에서 제외시킨다.
        bindings.including(root.title, root.content ,root.hashtag, root.createdAt, root.createdBy);
        // including을 사용해 원하는 필드에 대해서 검색이 가능하게 함
//        bindings.bind(root.title).first(StringExpression::likeIgnoreCase);
        // like '${v}'
        bindings.bind(root.title).first(StringExpression::containsIgnoreCase);
        // like '%${v}%'
        // like나 likeIgnoreCase는 검색어에 %를 넣는 것을 내가 직접 해줘야함. 그래야 부분검색 가능
        bindings.bind(root.content).first(StringExpression::containsIgnoreCase);
        bindings.bind(root.hashtag).first(StringExpression::containsIgnoreCase);
        bindings.bind(root.createdAt).first(DateTimeExpression::eq);
        bindings.bind(root.createdBy).first(StringExpression::containsIgnoreCase);

    }
}