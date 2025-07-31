package com.celada.blog.domain.user

import com.celada.blog.domain.model.User
import com.celada.blog.ports.outbound.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(private val repository: UserRepository) {

    init {

    }

    fun findAll(): List<User?> {
        val users: Iterable<User?> = repository.findAll()
        return users.toList()
    }

    fun findByLogin(login: String): User? {
        return repository.findByUsername(login);
    }
}