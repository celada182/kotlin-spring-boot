package com.celada.blog

import com.celada.blog.domain.model.Role
import com.celada.blog.persistence.relational.entity.EntityArticle
import com.celada.blog.persistence.relational.entity.EntityUser
import com.celada.blog.persistence.relational.repository.h2.ArticleCrudRepository
import com.celada.blog.persistence.relational.repository.h2.UserCrudRepository
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager
import org.springframework.data.repository.findByIdOrNull

@DataJpaTest
class RelationalRepositoriesTests @Autowired constructor(
    val entityManager: TestEntityManager,
    val userRepository: UserCrudRepository,
    val articleRepository: ArticleCrudRepository
) {

    @Test
    fun `When findByIdOrNull then return Article`() {
        val johnDoe = EntityUser("johnDoe", "123456", Role.USER,"John", "Doe")
        entityManager.persist(johnDoe)
        val article = EntityArticle("Lorem", "Lorem", "dolor sit amet", johnDoe)
        entityManager.persist(article)
        entityManager.flush()
        val found = articleRepository.findByIdOrNull(article.id!!)
        assertThat(found).isEqualTo(article)
    }

    @Test
    fun `When findByLogin then return User`() {
        val johnDoe = EntityUser("johnDoe", "123456", Role.USER,"John", "Doe")
        entityManager.persist(johnDoe)
        entityManager.flush()
        val user = userRepository.findByUsername(johnDoe.username)
        assertThat(user).isEqualTo(johnDoe)
    }
}