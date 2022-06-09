package br.com.alura.forum.controller

import br.com.alura.forum.dto.TopicByCategoryDto
import br.com.alura.forum.dto.TopicForm
import br.com.alura.forum.dto.TopicView
import br.com.alura.forum.dto.UpdateTopicForm
import br.com.alura.forum.service.TopicService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.data.web.PageableDefault
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder
import javax.transaction.Transactional
import javax.validation.Valid

@RestController
@RequestMapping("/topics")
class TopicController(private val service: TopicService) {

    @GetMapping
    fun list(
            @RequestParam(required = false) courseName: String?,
            @PageableDefault(size=5, sort = ["dateCreate"], direction = Sort.Direction.DESC) pagination: Pageable): Page<TopicView>{
        return service.listAll(courseName, pagination)
    }

    @GetMapping("/{id}")
    fun listById(@PathVariable id: Long): TopicView{
        return service.listById(id)
    }

    @PostMapping
    @Transactional
    fun create(
            @RequestBody @Valid form: TopicForm,
            uriBuilder: UriComponentsBuilder): ResponseEntity<TopicView>{
        val topicView = service.create(form)
        val uri = uriBuilder.path("/topics/${topicView.id}").build().toUri()
        return ResponseEntity.created(uri).body(topicView)
    }

    @PutMapping("/{id}")
    @Transactional
    fun update(
            @RequestBody @Valid form: UpdateTopicForm,
            @PathVariable id: Long): ResponseEntity<TopicView>{
        val topicView = service.update(form, id)
        return ResponseEntity.ok(topicView)
    }

    @DeleteMapping("/{id}")
    @Transactional
    fun delete(@PathVariable id: Long){
        service.delete(id)
    }

    @GetMapping("/report")
    fun report(): List<TopicByCategoryDto>{
        return service.report()
    }

}