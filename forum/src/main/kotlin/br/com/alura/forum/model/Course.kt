package br.com.alura.forum.model

import javax.persistence.*

@Entity
data class Course(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long? = null,
        val name: String,
        @ManyToOne
        val category: Category
)
