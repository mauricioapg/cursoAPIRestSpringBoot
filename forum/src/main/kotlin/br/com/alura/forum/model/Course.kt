package br.com.alura.forum.model

data class Course(
        var id: Long? = null,
        val name: String,
        val category: Category
)
