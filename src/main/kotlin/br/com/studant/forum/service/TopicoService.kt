package br.com.studant.forum.service

import br.com.studant.forum.dto.NovoTopicoDto
import br.com.studant.forum.model.Topico
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.PostMapping
import java.util.*

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
    fun listar(): List<Topico> {
        return topicos
    }

    fun buscarPorId(id: Long): Topico {
        return topicos.stream().filter({
            t -> t.id == id
        }).findFirst().get()

    }

    fun cadastrar(dto: NovoTopicoDto){
        topicos = topicos.plus(Topico(
            id = topicos.size.toLong()+1,
            titulo = dto.titulo,
            mensagem = dto.mensagem,
            curso = cursoService.buscaPorId(dto.idCurso),
            autor = usuarioService.buscaPorId(dto.idAutor)
        ))
    }
}
