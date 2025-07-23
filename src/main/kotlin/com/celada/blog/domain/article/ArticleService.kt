package com.celada.blog.domain.article

import com.celada.blog.domain.model.Article
import com.celada.blog.ports.outbound.repository.ArticleRepository
import org.springframework.stereotype.Service

@Service
class ArticleService(private val repository: ArticleRepository) {
    fun findAll(): List<Article?> {
        val articles: Iterable<Article?> = repository.findAll()
        return articles.toList()
    }

    fun findBySlug(slug: String): Article? {
        return repository.findBySlug(slug);
    }
}