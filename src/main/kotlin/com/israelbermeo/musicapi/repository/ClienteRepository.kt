package com.israelbermeo.musicapi.repository

import com.israelbermeo.musicapi.model.Cliente
import org.springframework.data.jpa.repository.JpaRepository

interface ClienteRepository: JpaRepository<Cliente, Long>{
    fun findById(id:Long?):Cliente?
}