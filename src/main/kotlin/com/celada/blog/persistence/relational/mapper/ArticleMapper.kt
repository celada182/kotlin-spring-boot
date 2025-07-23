package com.celada.blog.persistence.relational.mapper

import com.celada.blog.domain.model.Article
import com.celada.blog.persistence.relational.entity.EntityArticle
import org.mapstruct.Mapper
import org.springframework.context.annotation.Bean

@Mapper(componentModel = "spring")
interface ArticleMapper {
    fun toEntity(article: Article): EntityArticle
    fun toDomain(entity: EntityArticle): Article
}