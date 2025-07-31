package com.celada.blog.ports.outbound.repository

import com.celada.blog.domain.model.User

interface UserRepository {
    fun findByUsername(username: String): User?
    fun findAll(): Iterable<User>
}