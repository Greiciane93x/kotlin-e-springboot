package br.com.studant.forum.controller


import br.com.studant.forum.dto.NovoTopicoForm
import br.com.studant.forum.dto.TopicoView
import br.com.studant.forum.model.Curso
import br.com.studant.forum.model.Topico
import br.com.studant.forum.model.Usuario
import br.com.studant.forum.service.TopicoService
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping(value = ["/topicos"])
class TopicoController(private val service: TopicoService) {

    @GetMapping
    fun listar(): List<TopicoView> {
      return service.listar()
    }

    @GetMapping("/{id}")
    fun buscarPorId(@PathVariable id: Long): TopicoView {
        return service.buscarPorId(id)
    }

    @PostMapping
    fun cadastrar(@RequestBody @Valid dto: NovoTopicoForm){
        service.cadastrar(dto)
    }

}