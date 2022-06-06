package com.israelbermeo.musicapi.repository

import com.israelbermeo.musicapi.model.Banda
import com.israelbermeo.musicapi.model.Music
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import javax.transaction.Transactional

interface MusicRepository: JpaRepository<Music, Long> {
    fun findByIdm(idm:Long?): Music?

    @Query(nativeQuery = true)
    fun getListaDes(@Param("descripcion") descripcion:String?) : List<Music>?


    @Modifying
    @Query(nativeQuery=true)
    fun setNames (@Param("nombre") nombre :String?, @Param("nuevoNombre")  nuevoNombre: String?) : Integer?
}