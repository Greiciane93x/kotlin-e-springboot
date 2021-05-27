package br.com.studant.forum.service

import br.com.studant.forum.model.Usuario
import org.springframework.stereotype.Service
import java.util.*

@Service
data class UsuarioService(var usuarios: List<Usuario>) {
    init{
        val usuario = Usuario(
            id = 1,
            nome = "Assis Nane",
            email = "assis@ane"
        )
        usuarios = Arrays.asList(usuario)
    }

    fun buscaPorId(id: Long): Usuario{
        return usuarios.stream().filter({
            u -> u.id == id
        }).findFirst().get()
    }
}
