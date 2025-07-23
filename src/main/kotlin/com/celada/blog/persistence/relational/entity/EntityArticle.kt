package com.celada.blog.persistence.relational.entity

import com.celada.blog.domain.model.toSlug
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne
import java.time.LocalDateTime

@Entity
class EntityArticle(
    var title: String,
    var headline: String,
    var content: String,
    @ManyToOne var author: EntityUser,
    var slug: String = title.toSlug(),
    var addedAt: LocalDateTime = LocalDateTime.now(),
    @Id @GeneratedValue var id: Long? = null
)