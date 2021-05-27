package br.com.studant.forum.model
import  java.time.LocalDateTime

 data class Topico(
    val id : Long,
    val titulo : String,
    val mensagem: String,
    val curso: Curso,
    val autor: Usuario,
    val dataCriacao: LocalDateTime = LocalDateTime.now(),
    val status: StatusTopico = StatusTopico.NAO_RESPONDIDO,
    val respostas: List<Resposta> = ArrayList()
)
