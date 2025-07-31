package com.celada.blog.persistence.relational.repository.h2

import com.celada.blog.persistence.relational.entity.EntityUser
import org.springframework.data.repository.CrudRepository

interface UserCrudRepository : CrudRepository<EntityUser, Long> {
    fun findByUsername(username: String): EntityUser?
}