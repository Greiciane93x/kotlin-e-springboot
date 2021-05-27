package br.com.studant.forum.mapper

import br.com.studant.forum.dto.NovoTopicoForm
import br.com.studant.forum.model.Topico
import br.com.studant.forum.service.CursoService
import br.com.studant.forum.service.UsuarioService
import org.springframework.stereotype.Component

@Component
class TopicoFormMapper(
    private val cursoService: CursoService,
    private val usuarioService : UsuarioService
                       ) : Mapper<NovoTopicoForm, Topico>  {

    override fun map(t: NovoTopicoForm): Topico {
        return Topico(
            titulo = t.titulo,
            mensagem = t.mensagem,
            curso = cursoService.buscaPorId(t.idCurso),
            autor = usuarioService.buscaPorId(t.idAutor)
        )

    }

}
