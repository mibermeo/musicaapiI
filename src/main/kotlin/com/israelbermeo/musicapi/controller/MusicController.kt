package com.israelbermeo.musicapi.controller

import DTO.NewName
import com.israelbermeo.musicapi.model.Manager
import com.israelbermeo.musicapi.model.Music
import com.israelbermeo.musicapi.service.MusicService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/musica")
class MusicController {
    @Autowired
    lateinit var musicService: MusicService

    @GetMapping("/{idm}")
    fun listById(@PathVariable("idm")idm:Long):Music?{
        return musicService.getByid(idm)
    }
    @GetMapping("/descripcion/{descripcion}")
    fun getListaDes (@PathVariable("descripcion") descripcion: String):List <Music>?{
        return musicService.getListaDes(descripcion )
    }

    @GetMapping
    fun list():List<Music>{
        return musicService.list()
    }


    @PostMapping("/changeName")
    fun updateName (@RequestBody newName: NewName): String?{
        return musicService.updateName(newName)
    }
    @PostMapping
    fun save(@RequestBody music: Music): Music {
        return musicService.save(music)
    }
    @PutMapping
    fun update (@RequestBody music: Music): Music {
        return musicService.update(music)
    }
    @PatchMapping
    fun updateUno (@RequestBody music: Music): Music {
        return musicService.updateUno(music)
    }
    @DeleteMapping("/delete/{idm}")
    fun delete (@PathVariable("idm") idm: Long):Boolean{
        return musicService.delete(idm)
    }
}