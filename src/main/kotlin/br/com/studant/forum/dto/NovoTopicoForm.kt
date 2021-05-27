package br.com.studant.forum.dto

import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

data class NovoTopicoForm(@field:NotEmpty @Size(min = 5, max = 100)val titulo: String,
                          @field:NotEmpty val mensagem: String,
                          @field:NotNull val idCurso: Long,
                          @field:NotNull val idAutor: Long )
