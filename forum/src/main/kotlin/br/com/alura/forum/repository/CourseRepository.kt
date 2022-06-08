package br.com.alura.forum.repository

import br.com.alura.forum.model.Course
import br.com.alura.forum.model.Topic
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository

interface CourseRepository: JpaRepository<Course, Long> {

    fun findByCategoryName(categoryName: String, pagination: Pageable): Page<Course>

}