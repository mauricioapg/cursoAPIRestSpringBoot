package br.com.alura.forum.mapper

interface Mapper<T, U> {

    //MÉTODO QUE CONVERTE DE TOPIC PARA TOPICVIEW
    fun map(t: T): U

}
