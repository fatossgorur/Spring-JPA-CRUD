package com.hellospring.demo.repository;

import com.hellospring.demo.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends JpaRepository<Article, String> {
    @Query("update Article a set a.title = :title where a.id = :id")
    void updateTitle(@Param("id") String id, @Param("title") String title);

    @Query("update Article a set a.content = :content where a.id = :id")
    void updateContent(@Param("id") String id, @Param("content") String content);

    void deleteById(String id);
}

