package com.celada.blog.rest.mapper

import com.celada.blog.domain.model.User
import com.celada.blog.model.RestUser
import org.mapstruct.Mapper

@Mapper(componentModel = "spring")
interface UserMapper {
    fun toRest(user: User): RestUser
    fun toDomain(userDto: RestUser): User
}