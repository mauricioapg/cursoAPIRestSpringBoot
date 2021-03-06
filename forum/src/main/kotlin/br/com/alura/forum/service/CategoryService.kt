package br.com.alura.forum.service

import br.com.alura.forum.model.Category
import br.com.alura.forum.model.Course
import br.com.alura.forum.model.Topic
import br.com.alura.forum.model.User
import br.com.alura.forum.repository.CategoryRepository
import br.com.alura.forum.repository.CourseRepository
import org.springframework.stereotype.Service

@Service
class CategoryService(
        private val repository: CategoryRepository,
) {

    fun listAll(): List<Category> {
        return repository.findAll()
    }

    fun listById(id: Long): Category {
        return repository.getById(id)
    }

    fun create(category: Category) {
        println("criando categoria")
        repository.save(Category(
                name = category.name
        ))
    }

}