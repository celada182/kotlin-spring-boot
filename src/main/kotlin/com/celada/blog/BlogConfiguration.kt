package com.celada.blog

import org.springframework.boot.ApplicationRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class BlogConfiguration {

    @Bean
    fun databaseInitializer(bloggerRepository: BloggerRepository,
                            articleRepository: ArticleRepository) = ApplicationRunner {

        val johnDoe = bloggerRepository.save(Blogger("johnDoe", "John", "Doe"))
        articleRepository.save(
            Article(
                title = "Lorem",
                headline = "Lorem",
                content = "dolor sit amet",
                author = johnDoe
            )
        )
        articleRepository.save(
            Article(
                title = "Ipsum",
                headline = "Ipsum",
                content = "dolor sit amet",
                author = johnDoe
            )
        )
    }
}