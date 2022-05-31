package com.israelbermeo.musicapi.repository

import com.israelbermeo.musicapi.model.Banda
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface BandaRepository: JpaRepository<Banda, Long> {
    fun findById(id:Long?):Banda?

    @Query(nativeQuery = true)
    fun getListaPorGenero(@Param("genero") genero:String?) : List<Banda>?

}