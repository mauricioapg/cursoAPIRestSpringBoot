package br.com.alura.forum.service

import br.com.alura.forum.model.User
import org.springframework.stereotype.Service

@Service
class UserService(
        private var users: List<User> = ArrayList(),
) {

    fun listAll(): List<User> {
        return users
    }

    fun listById(id: Long): User {
        return users.stream().filter { u ->
            u.id == id
        }.findFirst().get()
    }

    fun create(user: User) {
        users = users.plus(User(
                id = users.size.toLong() + 1,
                name = user.name,
                email = user.email
        ))
    }
}