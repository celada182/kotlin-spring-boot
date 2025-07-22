package com.celada.blog.rest

import com.celada.blog.domain.article.ArticleService
import com.celada.blog.model.RestArticle
import com.celada.blog.ports.inbound.ArticleRestInterface
import com.celada.blog.rest.adapter.mapArticle
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

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
}