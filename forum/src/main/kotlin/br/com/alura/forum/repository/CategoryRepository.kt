package br.com.alura.forum.repository

import br.com.alura.forum.model.Category
import org.springframework.data.jpa.repository.JpaRepository

interface CategoryRepository: JpaRepository<Category, Long> {
}