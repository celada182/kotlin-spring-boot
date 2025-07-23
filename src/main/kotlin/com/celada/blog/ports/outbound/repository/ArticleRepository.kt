package com.celada.blog.ports.outbound.repository

import com.celada.blog.domain.model.Article

interface ArticleRepository {
    fun findBySlug(slug: String): Article?
    fun findAll(): Iterable<Article>
}