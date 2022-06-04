package br.com.alura.forum.service

import br.com.alura.forum.model.Category
import br.com.alura.forum.model.Course
import br.com.alura.forum.model.Topic
import br.com.alura.forum.model.User
import org.springframework.stereotype.Service

@Service
class CategoryService(private var categories: List<Category> = ArrayList()) {

//    init {
//        val category1 = Category(
//                id = 1,
//                name = "Front-End",
//        )
//
//        val category2 = Category(
//                id = 2,
//                name = "Back-End",
//        )
//
//        categories = listOf(category1, category2)
//    }

    fun listAll(): List<Category> {
        return categories
    }

    fun listById(id: Long): Category {
        return categories.stream().filter { c ->
            c.id == id
        }.findFirst().get()
    }

    fun create(category: Category) {
        categories = categories.plus(Category(
                id = categories.size.toLong() + 1,
                name = category.name
        ))
    }

}