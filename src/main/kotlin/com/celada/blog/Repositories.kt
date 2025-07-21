package com.celada.blog

import org.springframework.data.repository.CrudRepository

interface ArticleRepository : CrudRepository<Article, Long> {
    fun findBySlug(slug: String): Article?
    fun findAllByOrderByAddedAtDesc(): Iterable<Article>
}

interface BloggerRepository : CrudRepository<Blogger, Long> {
    fun findByLogin(login: String): Blogger?
}