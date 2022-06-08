package br.com.alura.forum.service

import br.com.alura.forum.dto.TopicForm
import br.com.alura.forum.dto.TopicView
import br.com.alura.forum.dto.UpdateTopicForm
import br.com.alura.forum.exceptions.NotFoundException
import br.com.alura.forum.mapper.TopicFormMapper
import br.com.alura.forum.mapper.TopicViewMapper
import br.com.alura.forum.model.Topic
import br.com.alura.forum.repository.TopicRepository
import org.springframework.stereotype.Service
import java.util.stream.Collectors
import kotlin.collections.ArrayList

@Service
class TopicService(
        private val repository: TopicRepository,
        private var topicViewMapper: TopicViewMapper,
        private var topicFormMapper: TopicFormMapper,
        private val notFoundExceptionMessage: String = "Tópico não encontrado") {

    fun listAll(): List<TopicView> {
        return repository.findAll().stream().map {
            t -> topicViewMapper.map(t)
        }.collect(Collectors.toList())
    }

    fun listById(id: Long): TopicView {
        val topic = repository.findById(id).orElseThrow{
            NotFoundException(notFoundExceptionMessage)
        }
        return topicViewMapper.map(topic)
    }

    fun create(form: TopicForm): TopicView {
        println("criando tópico")
        val topic = topicFormMapper.map(form)
        repository.save(topic)
        return topicViewMapper.map(topic)
    }

    fun update(form: UpdateTopicForm, id: Long): TopicView {
        println("atualizando tópico")
        val topic = repository.findById(id).orElseThrow{
            NotFoundException(notFoundExceptionMessage)
        }
        topic.title = form.title
        topic.message = form.message
        return topicViewMapper.map(topic)
    }

    fun delete(id: Long) {
        println("excluindo tópico")
        repository.deleteById(id)
    }
}