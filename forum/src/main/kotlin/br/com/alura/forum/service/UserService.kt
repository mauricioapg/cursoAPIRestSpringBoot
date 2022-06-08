package br.com.alura.forum.service

import br.com.alura.forum.model.User
import br.com.alura.forum.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(
        private val repository: UserRepository
) {

    fun listAll(): List<User> {
        return repository.findAll()
    }

    fun listById(id: Long): User {
        return repository.getById(id)
    }

//    fun create(form: UserForm) {
//        val user = userFormMapper.map(form)
//        repository.save(user)
//    }

    fun create(user: User) {
        println("criando usuário")
        repository.save(User(
//                id = users.size.toLong() + 1,
//                id = 1,
                name = user.name,
                email = user.email
        ))
    }
}