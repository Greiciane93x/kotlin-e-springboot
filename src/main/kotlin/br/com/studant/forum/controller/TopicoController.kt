package br.com.studant.forum.controller


import br.com.studant.forum.dto.AtualizacaoTopicoForm
import br.com.studant.forum.dto.NovoTopicoForm
import br.com.studant.forum.dto.TopicoView
import br.com.studant.forum.model.Topico
import br.com.studant.forum.service.TopicoService
import org.apache.coyote.Response
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder
import javax.validation.Valid

@RestController
@RequestMapping("/topicos")

class TopicoController(private val service: TopicoService) {

    @GetMapping
    fun listar(): List<TopicoView> { return service.listar() }
    @GetMapping("/{id}")
    fun buscarPorId(@PathVariable id: Long): TopicoView { return service.buscarPorId(id) }
    @PostMapping
    fun cadastrar(
        @RequestBody @Valid form: NovoTopicoForm,
        uriBuilder: UriComponentsBuilder
    ): ResponseEntity<TopicoView> {
        val topicoView = service.cadastrar(form)
        val uri = uriBuilder.path("/topicos/${topicoView.id}").build().toUri()
        return ResponseEntity.created(uri).body(topicoView) }
    @PutMapping
    fun atualizar(@RequestBody @Valid form: AtualizacaoTopicoForm){ service.atualizar(form) }
    @DeleteMapping("/{id}")
    fun deletar(@PathVariable id: Long){ service.deletar(id) }

}