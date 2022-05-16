package com.israelbermeo.musicapi.controller

import com.israelbermeo.musicapi.model.Cliente
import com.israelbermeo.musicapi.service.CLienteService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/cliente")
class ClienteController {
    @Autowired
    lateinit var cLienteService: CLienteService
    @GetMapping
    fun list():List<Cliente>{
        return cLienteService.list()
    }
    @PostMapping
    fun save(@RequestBody cliente: Cliente): Cliente {
        return cLienteService.save(cliente)
    }
    @PutMapping
    fun update (@RequestBody cliente: Cliente): Cliente {
        return cLienteService.update(cliente)
    }
    @PatchMapping
    fun updateUno (@RequestBody cliente: Cliente): Cliente {
        return cLienteService.updateUno(cliente)
    }
}