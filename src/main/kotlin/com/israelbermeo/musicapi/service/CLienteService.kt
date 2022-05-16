package com.israelbermeo.musicapi.service

import com.israelbermeo.musicapi.model.Cliente
import com.israelbermeo.musicapi.repository.ClienteRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CLienteService {
    @Autowired
    lateinit var clienteRepository: ClienteRepository

    fun list ():List<Cliente>{
        return clienteRepository.findAll()
    }

    fun save ( cliente: Cliente): Cliente {
        return clienteRepository.save(cliente)
    }
    fun update (cliente: Cliente): Cliente {
        clienteRepository.findById(cliente.id)?: throw Exception()
        return clienteRepository.save(cliente)
    }
    fun updateUno (cliente: Cliente): Cliente {
        val response=clienteRepository.findById(cliente.id)
            ?: throw Exception()
        response.apply {
            nombre_cli=cliente.nombre_cli
        }
        return clienteRepository.save(response)
    }

}