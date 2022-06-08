package br.com.alura.forum.model

import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class Answers(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long? = null,
        val message: String,
        val dateCrate: LocalDateTime = LocalDateTime.now(),
        @ManyToOne
        val author: User,
        @ManyToOne
        val topic: Topic,
        val solution: Boolean
)
