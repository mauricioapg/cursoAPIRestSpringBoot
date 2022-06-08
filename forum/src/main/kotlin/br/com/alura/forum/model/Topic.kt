package br.com.alura.forum.model

import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class Topic(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long? = null,
        var title: String,
        var message: String,
        val dateCreate: LocalDateTime = LocalDateTime.now(),
        @ManyToOne
        val course: Course,
        @ManyToOne
        val author: User,
        @Enumerated(value = EnumType.STRING)
        val status: StatusTopic = StatusTopic.NOT_ANSWERED,
//        @OneToMany(mappedBy = "Topic")
        val answers: ArrayList<Answers> = ArrayList()
)