package com.celada.blog.ports.outbound.repository

import com.celada.blog.domain.model.User

interface UserRepository {
    fun findByLogin(login: String): User?
    fun findAll(): Iterable<User>
}