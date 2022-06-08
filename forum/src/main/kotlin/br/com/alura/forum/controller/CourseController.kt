package br.com.alura.forum.controller

import br.com.alura.forum.dto.CourseForm
import br.com.alura.forum.model.Course
import br.com.alura.forum.service.CourseService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.web.bind.annotation.*
import javax.transaction.Transactional

@RestController
@RequestMapping("/courses")
class CourseController(private val service: CourseService) {

    @GetMapping
    fun list(
            @RequestParam(required = false) categoryName: String?,
            pagination: Pageable): Page<Course> {
        return service.listAll(categoryName, pagination)
    }

    @GetMapping("/{id}")
    fun listById(@PathVariable id: Long): Course {
        return service.listById(id)
    }

    @PostMapping
    @Transactional
    fun create(@RequestBody dto: CourseForm){
        service.create(dto)
    }

}