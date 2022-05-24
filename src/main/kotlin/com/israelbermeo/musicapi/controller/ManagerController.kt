package com.israelbermeo.musicapi.controller

import com.israelbermeo.musicapi.model.Manager
import com.israelbermeo.musicapi.service.ManagerService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/cliente")
class ManagerController {
    @Autowired
    lateinit var managerService: ManagerService
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