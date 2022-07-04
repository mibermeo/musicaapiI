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
    fun getByid (id:Long?): Manager? {
        return managerRepository.findById(id)
    }

    fun getListaEdad (edad:Long?):List<Manager>?{
        return managerRepository.getListaEdad(edad)
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
    fun multiplicacion (coeficiente: Int, digito: Int): Int {
        val response= coeficiente*digito
        if(response >= 10)
            return response -9
        return response
    }

    fun SumaValores (nui:String): Long{
        var sum: Long=0
        for ( i in 0..8) {
            val coeficiente = if(i%2 ==0) 2 else 1
            sum  += multiplicacion(coeficiente, Integer.parseInt(nui[i].toString()))
        }
        return sum
    }
    fun findDecenaSuperior (sum: Int): Int{

        val division:Int = sum-10
        val decenaSuperior: Int = (division+1) *10
        var response: Int=decenaSuperior-sum
        if(decenaSuperior == 10)
            response=0

        return response
    }
}

