package com.celada.blog.rest.adapter

import com.celada.blog.User
import com.celada.blog.model.RestUser
import java.math.BigDecimal

fun mapUser(user: User): RestUser {
    return RestUser(
        BigDecimal.valueOf(user.id!!),
        user.login,
        user.firstname,
        user.lastname,
        user.description
    )
}