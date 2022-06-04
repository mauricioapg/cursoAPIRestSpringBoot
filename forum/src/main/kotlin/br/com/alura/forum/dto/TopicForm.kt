package br.com.alura.forum.dto

import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

data class TopicForm(
        @field:NotEmpty @field:Size(min = 5, max = 100, message = "Título deve ter entre 5 e 100 caracteres")
        val title: String,

        @field:NotEmpty(message= "Mensagem não pode estar vazia")
        val message: String,

        @field:NotNull(message= "Curso não pode ser nulo")
        val idCourse: Long,

        @field:NotNull(message= "Autor não pode ser nulo")
        val idAuthor: Long,
)
