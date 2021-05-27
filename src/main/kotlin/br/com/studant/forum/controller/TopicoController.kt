package br.com.studant.forum.controller

import br.com.studant.forum.model.Curso
import br.com.studant.forum.model.Topico
import br.com.studant.forum.model.Usuario
import br.com.studant.forum.service.TopicoService
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping(value = ["/topicos"])
class TopicoController(private val service: TopicoService) {

    @GetMapping
    fun listar(): List<Topico> {
      return service.listar()
    }

    @GetMapping("/{id}")
    fun buscarPorId(@PathVariable id: Int) : Topico {
        return service.buscarPorId(id)
    }

    @PostMapping
    fun cadastrar(@RequestBody topico: Topico){
        service.cadastrar(topico)
    }

}