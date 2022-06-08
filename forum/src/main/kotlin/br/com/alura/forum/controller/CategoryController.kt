package br.com.alura.forum.controller

import br.com.alura.forum.model.Category
import br.com.alura.forum.service.CategoryService
import org.springframework.web.bind.annotation.*
import javax.transaction.Transactional

@RestController
@RequestMapping("/categories")
class CategoryController(private val service: CategoryService) {

    @GetMapping
    fun list(): List<Category> {
        return service.listAll()
    }

    @GetMapping("/{id}")
    fun listById(@PathVariable id: Long): Category {
        return service.listById(id)
    }

    @PostMapping
    @Transactional
    fun create(@RequestBody category: Category){
        service.create(category)
    }

}