package com.israelbermeo.musicapi.controller

import com.israelbermeo.musicapi.service.Usuario
import com.israelbermeo.musicapi.service.UsuarioService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/usuario")

class UsuarioController {
    @Autowired
    lateinit var usuarioService: UsuarioService

    @PostMapping
    fun save (@RequestBody usuario: Usuario): Usuario{
        return usuarioService.save(usuario)

    }

}