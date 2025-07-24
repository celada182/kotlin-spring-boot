package com.celada.blog.config

import com.celada.blog.persistence.relational.entity.EntityArticle
import com.celada.blog.persistence.relational.entity.EntityUser
import com.celada.blog.persistence.relational.repository.h2.ArticleCrudRepository
import com.celada.blog.persistence.relational.repository.h2.UserCrudRepository
import org.springframework.boot.ApplicationRunner
import org.springframework.context.annotation.Configuration

@Configuration
class BlogConfiguration(
    userCrudRepository: UserCrudRepository,
    articleCrudRepository: ArticleCrudRepository
) {

    init {
        val johnDoe = userCrudRepository.save(EntityUser("johnDoe", "John", "Doe"))
        articleCrudRepository.save(
            EntityArticle(
                title = "Lorem",
                headline = "Lorem",
                content = "dolor sit amet",
                author = johnDoe
            )
        )
        articleCrudRepository.save(
            EntityArticle(
                title = "Ipsum",
                headline = "Ipsum",
                content = "dolor sit amet",
                author = johnDoe
            )
        )
    }
}