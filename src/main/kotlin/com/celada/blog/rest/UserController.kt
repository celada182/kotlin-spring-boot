package com.celada.blog.rest

import com.celada.blog.domain.user.UserService
import com.celada.blog.model.RestUser
import com.celada.blog.ports.inbound.UserRestInterface
import com.celada.blog.rest.adapter.mapUser
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController(private val service: UserService) : UserRestInterface {
    override fun findAllUsers(): ResponseEntity<List<RestUser>> {
        // TODO adapter
        val users = service.findAll();
        val restUsers = users.map { user -> mapUser(user!!) }
        return ResponseEntity.ok(restUsers);
    }

    override fun findOneUser(
        @PathVariable("login") login: String
    ): ResponseEntity<RestUser> {
        // TODO adapter
        val user = service.findByLogin(login);
        val restUser = mapUser(user!!);
        return ResponseEntity.ok(restUser);
    }
}