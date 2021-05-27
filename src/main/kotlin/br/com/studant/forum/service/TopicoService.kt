package br.com.studant.forum.service


import br.com.studant.forum.dto.NovoTopicoForm
import br.com.studant.forum.dto.TopicoView
import br.com.studant.forum.model.Topico
import org.springframework.stereotype.Service

import java.util.*
import java.util.stream.Collectors

@Service
class TopicoService (private var topicos: List<Topico> = ArrayList(),
                     private val cursoService: CursoService,
                     private val usuarioService : UsuarioService
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
        return topicos.stream().map { t -> TopicoView(
            id = t.id,
            titulo = t.titulo,
            mensagem = t.mensagem,
            dataCriacao = t.dataCriacao,
            status = t.status
        ) }.collect(Collectors.toList())
    }

    fun buscarPorId(id: Long): TopicoView {
         val topico = topicos.stream().filter({
            t -> t.id == id
        }).findFirst().get()
        return TopicoView(
            id = topico.id,
            titulo = topico.titulo,
            mensagem = topico.mensagem,
            dataCriacao = topico.dataCriacao,
            status = topico.status
        )
    }

    fun cadastrar(dto: NovoTopicoForm){
        topicos = topicos.plus(Topico(
            id = topicos.size.toLong()+1,
            titulo = dto.titulo,
            mensagem = dto.mensagem,
            curso = cursoService.buscaPorId(dto.idCurso),
            autor = usuarioService.buscaPorId(dto.idAutor)
        ))
    }
}
