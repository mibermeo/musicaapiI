package com.israelbermeo.musicapi.service


import com.israelbermeo.musicapi.repository.UsuarioRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service

class UsuarioService {
    @Autowired
    lateinit var usuarioRepository: UsuarioRepository

    fun list(): List<Usuario> {
        return usuarioRepository.findAll()
    }

    fun save(usuario: Usuario): Usuario {
        try {
            usuario.username?.takeIf { it.trim().isNotEmpty() }
                ?: throw Exception("El campo no puede estar vacio")
            usuario.password?.takeIf { it.trim().isNotEmpty() }
                ?: throw Exception("El campo  no puede estar vacio")


        }catch (ex:Exception){
            throw ResponseStatusException(
                HttpStatus.NOT_FOUND, ex.message, ex
            )
        }

        return usuarioRepository.save(usuario)
    }
}