package br.com.alura.forum.service

import br.com.alura.forum.dto.CourseForm
import br.com.alura.forum.mapper.CourseFormMapper
import br.com.alura.forum.model.Course
import br.com.alura.forum.repository.CourseRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class CourseService(
        private val repository: CourseRepository,
        private var courseFormMapper: CourseFormMapper
) {

    fun listAll(categoryName: String?, pagination: Pageable): Page<Course> {
        val courses = if(categoryName == null){
            repository.findAll(pagination)
        }
        else{
            repository.findByCategoryName(categoryName, pagination)
        }
        return courses
    }

    fun listById(id: Long): Course {
        return repository.getById(id)
    }

    fun create(form: CourseForm) {
        println("criando curso")
        val course = courseFormMapper.map(form)
        repository.save(course)
    }

}