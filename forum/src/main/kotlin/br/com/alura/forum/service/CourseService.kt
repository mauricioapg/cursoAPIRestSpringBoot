package br.com.alura.forum.service

import br.com.alura.forum.dto.CourseForm
import br.com.alura.forum.mapper.CourseFormMapper
import br.com.alura.forum.model.Course
import br.com.alura.forum.repository.CourseRepository
import org.springframework.stereotype.Service

@Service
class CourseService(
        private val repository: CourseRepository,
        private var courseFormMapper: CourseFormMapper
) {

    fun listAll(): List<Course> {
        return repository.findAll()
    }

    fun listById(id: Long): Course {
        return repository.getById(id)
    }

    fun create(form: CourseForm) {
        println("criando curso")
        val course = courseFormMapper.map(form)
        repository.save(course)
    }

//    fun create(form: CourseForm) {
//        val course = courseFormMapper.map(form)
//        course.id = courses.size.toLong() + 1
//        courses = courses.plus(course)
//    }

}