package br.com.alura.forum.service

import br.com.alura.forum.dto.CourseForm
import br.com.alura.forum.mapper.CourseFormMapper
import br.com.alura.forum.model.Course
import org.springframework.stereotype.Service

@Service
class CourseService(
        private var courses: List<Course> = ArrayList(),
        private var courseFormMapper: CourseFormMapper
) {

    fun listAll(): List<Course> {
        return courses
    }

    fun listById(id: Long): Course {
        return courses.stream().filter { c ->
            c.id == id
        }.findFirst().get()
    }

    fun create(form: CourseForm) {
        val course = courseFormMapper.map(form)
        course.id = courses.size.toLong() + 1
        courses = courses.plus(course)
    }

}