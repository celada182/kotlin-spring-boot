package com.celada.blog.persistence.relational.entity

import com.celada.blog.domain.model.Role
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id

@Entity(name = "User")
class EntityUser(
    var username: String,
    val password: String,
    val role: Role,
    var firstname: String,
    var lastname: String,
    var description: String? = null,
    @Id @GeneratedValue var id: Long? = null
)