package com.israelbermeo.musicapi.service

import com.israelbermeo.musicapi.model.Manager
import com.israelbermeo.musicapi.repository.ManagerRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class ManagerService {
    @Autowired
    lateinit var managerRepository: ManagerRepository

    fun list ():List<Manager>{
        return managerRepository.findAll()
    }

    fun save (manager: Manager): Manager {
        return managerRepository.save(manager)
    }
    fun update (manager: Manager): Manager {
        managerRepository.findById(manager.id)?: throw Exception()
        return managerRepository.save(manager)
    }
    fun updateUno (manager: Manager): Manager {
        val response=managerRepository.findById(manager.id)
            ?: throw Exception()
        response.apply {
            nombre=manager.nombre
        }
        return managerRepository.save(response)
    }
    fun delete (id:Long): Boolean{
        try {
            managerRepository.findById(id)
                ?:throw Exception("El id ${id} no existe")

            managerRepository.deleteById(id)

            return true
        }
        catch (ex:Exception){
            throw ResponseStatusException(
                HttpStatus.NOT_FOUND, ex.message, ex
            )
        }
    }
}