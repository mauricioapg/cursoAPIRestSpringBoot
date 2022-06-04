package br.com.alura.forum.exceptions

import java.lang.RuntimeException

class NotFoundException(message: String?) : RuntimeException(message) {
}