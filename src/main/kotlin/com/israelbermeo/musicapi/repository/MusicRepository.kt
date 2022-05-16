package com.israelbermeo.musicapi.repository

import com.israelbermeo.musicapi.model.Music
import org.springframework.data.jpa.repository.JpaRepository

interface MusicRepository: JpaRepository<Music, Long> {
    fun findByIdm(idm:Long?): Music?


}