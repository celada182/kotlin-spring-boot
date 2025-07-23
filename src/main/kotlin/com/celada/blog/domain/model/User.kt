package com.celada.blog.domain.model

class User(
    var login: String,
    var firstname: String,
    var lastname: String,
    var description: String? = null,
    var id: Long? = null
)