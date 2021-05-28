package br.com.studant.forum.service


import br.com.studant.forum.dto.AtualizacaoTopicoForm
import br.com.studant.forum.dto.NovoTopicoForm
import br.com.studant.forum.dto.TopicoView
import br.com.studant.forum.exception.NotFoundException
import br.com.studant.forum.mapper.TopicoFormMapper
import br.com.studant.forum.mapper.TopicoViewMapper
import br.com.studant.forum.model.Topico
import org.springframework.stereotype.Service

import java.util.*
import java.util.stream.Collectors

@Service
class TopicoService (private var topicos: List<Topico> = ArrayList(),
                     private val topicoViewMapper : TopicoViewMapper,
                     private val topicoFormMapper : TopicoFormMapper,
                     private val notFoundMessage : String = "Tópico não encontrado!"
                     ){
//
//    init {
//        val topico1 = Topico(
//            id = 1,
//            titulo = "Duvida sobre kotlin",
//            mensagem = "Variaveis no kotlin",
//            curso = Curso(
//                id = 1,
//                nome = "Kotlin",
//                categoria = "Programacao"
//            ),
//            autor = Usuario(
//                id = 1,
//                nome = "Ane Assis",
//                email = "assis@ane.com"
//            )
//
//        )
//        val topico2 = Topico(
//            id = 2,
//            titulo = "Duvida sobre kotlin",
//            mensagem = "Variaveis no kotlin",
//            curso = Curso(
//                id = 1,
//                nome = "Kotlin",
//                categoria = "Programacao"
//            ),
//            autor = Usuario(
//                id = 1,
//                nome = "Alice Rocha",
//                email = "alice@rocha.com"
//            )
//
//        )
//        val topico3 = Topico(
//            id = 3,
//            titulo = "Duvida sobre kotlin",
//            mensagem = "Variaveis no kotlin",
//            curso = Curso(
//                id = 1,
//                nome = "Kotlin",
//                categoria = "Programacao"
//            ),
//            autor = Usuario(
//                id = 1,
//                nome = "Bruno Rocha",
//                email = "bruno@rocha.com"
//            )
//
//        )
//        topicos =  Arrays.asList(topico1, topico2, topico3)
//
//    }
    fun listar(): List<TopicoView> {
        return topicos.stream().map {
            t -> topicoViewMapper.map(t)
        }.collect(Collectors.toList())
    }

    fun buscarPorId(id: Long): TopicoView {
         val topico = topicos.stream().filter({
            t -> t.id == id
        }).findFirst().orElseThrow{NotFoundException(notFoundMessage)}
        return topicoViewMapper.map(topico)
    }

    fun cadastrar(form: NovoTopicoForm) : TopicoView{
        val topico = topicoFormMapper.map(form)
        topico.id = topicos.size.toLong()+1
        topicos = topicos.plus(topico)
        return topicoViewMapper.map(topico)
    }

    fun atualizar(form: AtualizacaoTopicoForm) : TopicoView {
        val topico = topicos.stream().filter{ t->
            t.id == form.id
        }.findFirst().get()
        val topicoAtualizado = Topico(
            id = form.id,
            titulo = form.titulo,
            mensagem = form.mensagem,
            autor = topico.autor,
            curso = topico.curso,
            respostas = topico.respostas,
            status = topico.status,
            dataCriacao =  topico.dataCriacao
        )
        topicos = topicos.minus(topico).plus(topicoAtualizado)
        return topicoViewMapper.map(topico)
    }

    fun deletar(id: Long) {
        val topico = topicos.stream().filter{ t ->
            t.id == id
        }.findFirst().get()
        topicos = topicos.minus(topico)
    }
}
