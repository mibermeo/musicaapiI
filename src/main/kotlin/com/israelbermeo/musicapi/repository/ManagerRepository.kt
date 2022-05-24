package com.israelbermeo.musicapi.repository

import com.israelbermeo.musicapi.model.Manager
import org.springframework.data.jpa.repository.JpaRepository

interface ManagerRepository: JpaRepository<Manager, Long>{
    fun findById(id:Long?):Manager?
}