package com.celada.blog.rest.mapper

import com.celada.blog.domain.model.Article
import com.celada.blog.model.RestArticle
import org.mapstruct.Mapper

@Mapper(componentModel = "spring")
interface ArticleMapper {
    fun toRest(article: Article): RestArticle
    fun toDomain(userDto: RestArticle): Article
}