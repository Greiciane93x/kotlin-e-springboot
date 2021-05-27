package br.com.studant.forum.model
import  java.time.LocalDateTime

 data class Topico(val id: Int, val titulo: String, val mensagem: String, val curso: Curso = TODO(), val autor: Usuario = TODO()) {


    val dataCriacao: LocalDateTime = LocalDateTime.now()
    val status: StatusTopico = StatusTopico.NAO_RESPONDIDO
    val respostas: List<Resposta> = ArrayList()


}