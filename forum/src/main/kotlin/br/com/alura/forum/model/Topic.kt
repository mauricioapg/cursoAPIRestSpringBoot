package br.com.alura.forum.model

import java.time.LocalDateTime

data class Topic(
        var id: Long? = null,
        val title: String,
        val message: String,
        val dateCreate: LocalDateTime = LocalDateTime.now(),
        val course: Course,
        val author: User,
        val status: StatusTopic = StatusTopic.NOT_ANSWERED,
        val answers: ArrayList<Answers> = ArrayList()
)