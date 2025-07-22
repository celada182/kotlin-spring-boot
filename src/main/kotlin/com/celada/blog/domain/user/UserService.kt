package com.celada.blog.domain.user

import com.celada.blog.User
import com.celada.blog.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(private val repository: UserRepository) {
    fun findAll(): List<User?> {
        val users: Iterable<User?> = repository.findAll()
        // TODO repository port and adapter
        return users.toList()
    }

    fun findByLogin(login: String): User? {
        // TODO repository port and adapter
        return repository.findByLogin(login);
    }
}