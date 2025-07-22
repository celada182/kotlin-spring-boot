package com.celada.blog.rest

import com.celada.blog.Article
import com.celada.blog.User
import com.celada.blog.domain.article.ArticleService
import com.celada.blog.model.RestArticle
import com.celada.blog.model.RestUser
import com.celada.blog.ports.inbound.ArticleRestInterface
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import java.math.BigDecimal
import java.time.OffsetDateTime
import java.time.ZoneOffset

@RestController
class ArticleController(private val service: ArticleService) : ArticleRestInterface {
    override fun findAllArticles(): ResponseEntity<List<RestArticle>> {
        // TODO adapter
        val articles = service.findAll();
        val restArticles = articles.map { article -> mapArticle(article!!) }
        return ResponseEntity.ok(restArticles);
    }

    override fun findOneArticle(
        @PathVariable("slug") slug: String
    ): ResponseEntity<RestArticle> {
        // TODO adapter
        val article = service.findBySlug(slug);
        val restArticle = mapArticle(article!!);
        return ResponseEntity.ok(restArticle);
    }

    fun mapUser(user: User): RestUser {
        return RestUser(
            BigDecimal.valueOf(user.id!!),
            user.login,
            user.firstname,
            user.lastname,
            user.description
        )
    }

    fun mapArticle(article: Article): RestArticle {
        return RestArticle(
            BigDecimal.valueOf(
                article.id!!
            ),
            article.title,
            article.headline,
            article.content,
            mapUser(article.author),
            article.slug,
            OffsetDateTime.of(article.addedAt, ZoneOffset.UTC)
        )
    }
}