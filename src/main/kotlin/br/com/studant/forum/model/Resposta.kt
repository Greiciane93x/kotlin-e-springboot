package br.com.studant.forum.model

import java.time.LocalDateTime

class Resposta {
    val id: Long? = 0
    val mensagem: String = ""
    val dataCriacao: LocalDateTime = LocalDateTime.now()
    val autor: Usuario = TODO()
    val topico: Topico = TODO()
    val solucao: Boolean = false
}
