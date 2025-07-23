package com.celada.blog.domain.model

import java.time.LocalDateTime

class Article(
    var title: String,
    var headline: String,
    var content: String,
    var author: User,
    var slug: String = title.toSlug(),
    var addedAt: LocalDateTime = LocalDateTime.now(),
    var id: Long? = null
)