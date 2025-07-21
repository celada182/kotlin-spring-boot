package com.celada.blog

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne
import java.time.LocalDateTime

@Entity
class Article(
    var title: String,
    var headline: String,
    var content: String,
    @ManyToOne var author: Blogger,
    var slug: String = title.toSlug(),
    var addedAt: LocalDateTime = LocalDateTime.now(),
    @Id @GeneratedValue var id: Long? = null)

@Entity
class Blogger(
    var login: String,
    var firstname: String,
    var lastname: String,
    var description: String? = null,
    @Id @GeneratedValue var id: Long? = null)
