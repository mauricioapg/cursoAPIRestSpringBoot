package br.com.alura.forum.mapper

import br.com.alura.forum.dto.TopicForm
import br.com.alura.forum.model.Topic
import br.com.alura.forum.service.CourseService
import br.com.alura.forum.service.UserService
import org.springframework.stereotype.Component

@Component
class TopicFormMapper(
        private var courseService: CourseService,
        private var userService: UserService,
) : Mapper<TopicForm, Topic> {
    override fun map(t: TopicForm): Topic {
        return Topic(
                title = t.title,
                message = t.message,
                course = courseService.listById(t.idCourse),
                author = userService.listById(t.idAuthor)
        )
    }

}
