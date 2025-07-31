package com.celada.blog.domain.model

class User(
    var username: String,
    val password: String,
    val role: Role,
    var firstname: String,
    var lastname: String,
    var description: String? = null,
    var id: Long? = null
)