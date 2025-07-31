package com.celada.blog

import com.celada.blog.domain.article.ArticleService
import com.celada.blog.domain.model.Article
import com.celada.blog.domain.model.Role
import com.celada.blog.domain.model.User
import com.celada.blog.domain.user.UserService
import com.ninjasquad.springmockk.MockkBean
import io.mockk.every
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*

@WebMvcTest
class RestControllersTests(@Autowired val mockMvc: MockMvc) {

    @MockkBean
    lateinit var articleService: ArticleService

    @MockkBean
    lateinit var userService: UserService

    val johnDoe = User("johnDoe", "123456", Role.USER,"John", "Doe", id = 1)
    val janeDoe = User("janeDoe", "123456", Role.USER,"Jane","Doe", id = 2)
    val lorem5Article = Article("Lorem", "Lorem", "dolor sit amet", johnDoe, id = 1)
    val ipsumArticle = Article("Ipsum", "Ipsum", "dolor sit amet", johnDoe, id = 2)

    @Test
    fun `List articles`() {
        every { articleService.findAll() } returns listOf(lorem5Article, ipsumArticle)
        mockMvc.perform(get("/api/article").accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk)
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("\$.[0].author.login").value(johnDoe.username))
            .andExpect(jsonPath("\$.[0].slug").value(lorem5Article.slug))
            .andExpect(jsonPath("\$.[1].author.login").value(johnDoe.username))
            .andExpect(jsonPath("\$.[1].slug").value(ipsumArticle.slug))
    }

    @Test
    fun `Single article`() {
        val slug = "ipsum";
        every { articleService.findBySlug(slug) } returns ipsumArticle
        mockMvc.perform(
            get("/api/article/$slug")
                .accept(MediaType.APPLICATION_JSON)
        )
            .andExpect(status().isOk)
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("\$.author.login").value(johnDoe.username))
            .andExpect(jsonPath("\$.slug").value(ipsumArticle.slug))
    }

    @Test
    fun `List users`() {
        every { userService.findAll() } returns listOf(johnDoe, janeDoe)
        mockMvc.perform(get("/api/user").accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk)
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("\$.[0].login").value(johnDoe.username))
            .andExpect(jsonPath("\$.[1].login").value(janeDoe.username))
    }

    @Test
    fun `Single user`() {
        val login = "janeDoe";
        every { userService.findByLogin(login) } returns janeDoe
        mockMvc.perform(get("/api/user/$login").accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk)
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("\$.login").value(janeDoe.username))
    }
}