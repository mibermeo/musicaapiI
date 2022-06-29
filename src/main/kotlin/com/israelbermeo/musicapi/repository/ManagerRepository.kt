package com.israelbermeo.musicapi.repository


import com.israelbermeo.musicapi.model.Manager
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface ManagerRepository: JpaRepository<Manager, Long> {
    fun findById(id: Long?): Manager?

    @Query(nativeQuery = true)
    fun getListaEdad(@Param("edad") edad: Long?): List<Manager>?
}