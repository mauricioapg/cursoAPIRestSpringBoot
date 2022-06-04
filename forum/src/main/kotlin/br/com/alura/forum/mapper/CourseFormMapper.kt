package br.com.alura.forum.mapper

import br.com.alura.forum.dto.CourseForm
import br.com.alura.forum.model.Course
import br.com.alura.forum.model.User
import br.com.alura.forum.service.CategoryService
import org.springframework.stereotype.Component

@Component
class CourseFormMapper (
        private var categoryService: CategoryService,
        ): Mapper<CourseForm, Course> {
    override fun map(c: CourseForm): Course {
        return Course(
                name = c.name,
                category = categoryService.listById(c.idCategory)
        )
    }

}
