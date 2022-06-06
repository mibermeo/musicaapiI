package com.israelbermeo.musicapi.repository

import com.israelbermeo.musicapi.service.Usuario
import org.springframework.data.jpa.repository.JpaRepository

interface UsuarioRepository: JpaRepository<Usuario, Long>{
    fun findById(id:Long?):Usuario?
}