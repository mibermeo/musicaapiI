package com.israelbermeo.musicapi.repository

import com.israelbermeo.musicapi.model.Banda
import org.springframework.data.jpa.repository.JpaRepository

interface BandaRepository: JpaRepository<Banda, Long> {
    fun findById(id:Long?):Banda?

}