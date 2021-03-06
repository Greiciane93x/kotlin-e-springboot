package br.com.studant.forum.service

import br.com.studant.forum.model.Curso
import org.springframework.stereotype.Service
import java.util.*

@Service
class CursoService(var cursos: List<Curso>) {
    init {
        val curso = Curso(
            id = 1,
            nome = "Kotlin",
            categoria = "Programacao"
        )
        cursos = Arrays.asList(curso)
    }
    fun buscaPorId(id: Long): Curso {
        return cursos.stream().filter({
            c -> c.id == id
        }).findFirst().get()
    }
}
