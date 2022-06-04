package br.com.alura.forum.controller

import br.com.alura.forum.dto.TopicForm
import br.com.alura.forum.dto.TopicView
import br.com.alura.forum.dto.UpdateTopicForm
import br.com.alura.forum.service.TopicService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder
import javax.validation.Valid

@RestController
@RequestMapping("/topics")
class TopicController(private val service: TopicService) {

    @GetMapping
    fun list(): List<TopicView>{
        return service.listAll()
    }

    @GetMapping("/{id}")
    fun listById(@PathVariable id: Long): TopicView{
        return service.listById(id)
    }

    @PostMapping
    fun create(
            @RequestBody @Valid form: TopicForm,
            uriBuilder: UriComponentsBuilder): ResponseEntity<TopicView>{
        val topicView = service.create(form)
        val uri = uriBuilder.path("/topics/${topicView.id}").build().toUri()
        return ResponseEntity.created(uri).body(topicView)
    }

    @PutMapping("/{id}")
    fun update(
            @RequestBody @Valid form: UpdateTopicForm,
            @PathVariable id: Long): ResponseEntity<TopicView>{
        val topicView = service.update(form, id)
        return ResponseEntity.ok(topicView)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long){
        service.delete(id)
    }

}