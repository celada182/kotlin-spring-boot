package com.celada.blog.rest.adapter

import com.celada.blog.Article
import com.celada.blog.model.RestArticle
import java.math.BigDecimal
import java.time.OffsetDateTime
import java.time.ZoneOffset

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