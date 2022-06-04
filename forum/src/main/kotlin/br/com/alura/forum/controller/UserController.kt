package br.com.alura.forum.controller

import br.com.alura.forum.model.User
import br.com.alura.forum.service.UserService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/users")
class UserController(private val service: UserService) {

    @GetMapping
    fun list(): List<User> {
        return service.listAll()
    }

    @GetMapping("/{id}")
    fun listById(@PathVariable id: Long): User {
        return service.listById(id)
    }

    @PostMapping
    fun create(@RequestBody user: User){
        service.create(user)
    }

}