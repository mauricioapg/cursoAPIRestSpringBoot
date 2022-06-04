package br.com.alura.forum.controller

import br.com.alura.forum.dto.CourseForm
import br.com.alura.forum.model.Course
import br.com.alura.forum.service.CourseService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/courses")
class CourseController(private val service: CourseService) {

    @GetMapping
    fun list(): List<Course> {
        return service.listAll()
    }

    @GetMapping("/{id}")
    fun listById(@PathVariable id: Long): Course {
        return service.listById(id)
    }

    @PostMapping
    fun create(@RequestBody dto: CourseForm){
        service.create(dto)
    }

}