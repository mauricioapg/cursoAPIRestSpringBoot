package br.com.alura.forum.model

import java.time.LocalDateTime

data class Answers(
        val id: Long? = null,
        val message: String,
        val dateCrate: LocalDateTime = LocalDateTime.now(),
        val author: User,
        val topic: Topic,
        val solution: Boolean
)
