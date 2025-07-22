package com.celada.blog.domain.article

import com.celada.blog.Article
import com.celada.blog.ArticleRepository
import org.springframework.stereotype.Service

@Service
class ArticleService(private val repository: ArticleRepository) {
    fun findAll(): List<Article?> {
        val articles: Iterable<Article?> = repository.findAll()
        // TODO repository port and adapter
        return articles.toList()
    }

    fun findBySlug(slug: String): Article? {
        // TODO repository port and adapter
        return repository.findBySlug(slug);
    }
}