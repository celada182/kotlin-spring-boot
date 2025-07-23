package com.celada.blog.persistence.relational.repository

import com.celada.blog.domain.model.User
import com.celada.blog.persistence.relational.mapper.UserMapper
import com.celada.blog.persistence.relational.repository.h2.UserCrudRepository
import com.celada.blog.ports.outbound.repository.UserRepository
import org.springframework.stereotype.Repository

@Repository
class UserRelationalRepository(private val crudRepository: UserCrudRepository, val mapper: UserMapper) :
    UserRepository {
    override fun findByLogin(login: String): User? {
        val entity = crudRepository.findByLogin(login);
        if (entity == null) {
            throw Exception("Article not found");
        }
        return mapper.toDomain(entity);
    }

    override fun findAll(): Iterable<User> {
        val entities = crudRepository.findAll();
        val users = entities.map { entity -> mapper.toDomain(entity) }
        return users;
    }

}