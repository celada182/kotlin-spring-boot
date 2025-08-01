package com.celada.blog.security

import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Repository

@Repository
class RefreshTokenRepository {
    private val tokens = mutableMapOf<String, UserDetails>()

    fun findUserByToken(token: String): UserDetails? =
        tokens[token]

    fun save(token: String, user: UserDetails) {
        tokens[token] = user
    }
}