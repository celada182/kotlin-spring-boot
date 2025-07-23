package com.celada.blog.persistence.relational.mapper

import com.celada.blog.domain.model.User
import com.celada.blog.persistence.relational.entity.EntityUser
import org.mapstruct.Mapper

@Mapper(componentModel = "spring")
interface UserMapper {
    fun toEntity(user: User): EntityUser
    fun toDomain(entity: EntityUser): User
}