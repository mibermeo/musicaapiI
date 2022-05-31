package com.israelbermeo.musicapi.controller

import com.israelbermeo.musicapi.model.Banda
import com.israelbermeo.musicapi.model.Manager
import com.israelbermeo.musicapi.model.Music
import com.israelbermeo.musicapi.service.ManagerService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/manager")
class ManagerController {
    @Autowired
    lateinit var managerService: ManagerService

    @GetMapping("/{id}")
    fun listById(@PathVariable("idm")id:Long): Manager? {
        return managerService.getByid(id)
    }
    @GetMapping("/edad/{edad}")
    fun getListaEdad (@PathVariable("edad") edad: Long):List <Manager>?{
        return managerService.getListaEdad(edad)
    }

    @GetMapping
    fun list():List<Manager>{
        return managerService.list()
    }
    @PostMapping
    fun save(@RequestBody manager: Manager): Manager {
        return managerService.save(manager)
    }
    @PutMapping
    fun update (@RequestBody manager: Manager): Manager {
        return managerService.update(manager)
    }
    @PatchMapping
    fun updateUno (@RequestBody manager: Manager): Manager {
        return managerService.updateUno(manager)
    }
    @DeleteMapping ("/delete/{id}")
    fun delete (@PathVariable("id")id: Long): Boolean{
        return managerService.delete(id)
    }
}