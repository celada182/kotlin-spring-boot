package com.celada.blog.persistence.relational.repository

import com.celada.blog.domain.model.Article
import com.celada.blog.persistence.relational.mapper.ArticleMapper
import com.celada.blog.persistence.relational.repository.h2.ArticleCrudRepository
import com.celada.blog.ports.outbound.repository.ArticleRepository
import org.springframework.stereotype.Repository

@Repository
class ArticleRelationalRepository(private val crudRepository: ArticleCrudRepository, val mapper: ArticleMapper) :
    ArticleRepository {
    override fun findBySlug(slug: String): Article? {
        val entity = crudRepository.findBySlug(slug);
        if (entity == null) {
            throw Exception("Article not found");
        }
        return mapper.toDomain(entity);
    }

    override fun findAll(): Iterable<Article> {
        val entities = crudRepository.findAllByOrderByAddedAtDesc();
        val articles = entities.map { entity -> mapper.toDomain(entity) }
        return articles;
    }

}