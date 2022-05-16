package com.israelbermeo.musicapi.controller

import com.israelbermeo.musicapi.model.Banda
import com.israelbermeo.musicapi.model.Music
import com.israelbermeo.musicapi.repository.MusicRepository
import com.israelbermeo.musicapi.service.BandaService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/ban")
class BandaController {
@Autowired
lateinit var bandaService: BandaService

    @GetMapping("/{id}")
    fun listById(@PathVariable("id")id:Long): Banda?{
        return bandaService.getByid(id)
    }

    @GetMapping
    fun list():List<Banda>{
        return bandaService.list()
    }
    @PostMapping
    fun save(@RequestBody banda: Banda): Banda {
        return bandaService.save(banda)
    }
    @PutMapping
    fun update (@RequestBody banda: Banda): Banda {
        return bandaService.update(banda)
    }
    @PatchMapping
    fun updateUno (@RequestBody banda: Banda): Banda {
        return bandaService.updateUno(banda)
    }

    @DeleteMapping("/delete/{id}")
    fun delete (@PathVariable("id")id: Long): Boolean{
        return bandaService.delete (id)
    }


}