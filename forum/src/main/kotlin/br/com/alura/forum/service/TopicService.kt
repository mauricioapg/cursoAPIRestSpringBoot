package br.com.alura.forum.service

import br.com.alura.forum.dto.TopicForm
import br.com.alura.forum.dto.TopicView
import br.com.alura.forum.dto.UpdateTopicForm
import br.com.alura.forum.exceptions.NotFoundException
import br.com.alura.forum.mapper.TopicFormMapper
import br.com.alura.forum.mapper.TopicViewMapper
import br.com.alura.forum.model.Topic
import org.springframework.stereotype.Service
import java.util.stream.Collectors
import kotlin.collections.ArrayList

@Service
class TopicService(
        private var topics: List<Topic> = ArrayList(),
        private var topicViewMapper: TopicViewMapper,
        private var topicFormMapper: TopicFormMapper,
        private val notFoundExceptionMessage: String = "Tópico não encontrado") {

    fun listAll(): List<TopicView> {
        return topics.stream().map {
            t -> topicViewMapper.map(t)
        }.collect(Collectors.toList())
    }

    fun listById(id: Long): TopicView {
        val topic = topics.stream().filter { t ->
            t.id == id
        }.findFirst().orElseThrow{
            NotFoundException(notFoundExceptionMessage)
        }
        return topicViewMapper.map(topic)
    }

    fun create(form: TopicForm): TopicView {
        val topic = topicFormMapper.map(form)
        topic.id = topics.size.toLong() + 1
        topics = topics.plus(topic)
        return topicViewMapper.map(topic)
    }

    fun update(form: UpdateTopicForm, id: Long): TopicView {
        val topic = topics.stream().filter { t ->
            t.id == id
        }.findFirst().orElseThrow{
            NotFoundException(notFoundExceptionMessage)
        }
        val topicUpdated = Topic(
                id = id,
                title = form.title,
                message = form.message,
                author = topic.author,
                course = topic.course,
                answers = topic.answers,
                status = topic.status,
                dateCreate = topic.dateCreate
        )
        topics = topics.minus(topic).plus(topicUpdated)
        return topicViewMapper.map(topicUpdated)
    }

    fun delete(id: Long) {
        val topic = topics.stream().filter { t ->
            t.id == id
        }.findFirst().orElseThrow{
            NotFoundException(notFoundExceptionMessage)
        }
        topics = topics.minus(topic)
    }
}