package com.celada.blog.persistence.relational.repository.h2

import com.celada.blog.persistence.relational.entity.EntityArticle
import org.springframework.data.repository.CrudRepository

interface ArticleCrudRepository : CrudRepository<EntityArticle, Long> {
    fun findBySlug(slug: String): EntityArticle?
    fun findAllByOrderByAddedAtDesc(): Iterable<EntityArticle>
}