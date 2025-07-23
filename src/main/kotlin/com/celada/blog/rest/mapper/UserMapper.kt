package com.celada.blog.rest.mapper

import com.celada.blog.domain.model.User
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