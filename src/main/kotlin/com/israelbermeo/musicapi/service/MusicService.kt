package com.israelbermeo.musicapi.service

import DTO.NewName
import com.israelbermeo.musicapi.model.Banda
import com.israelbermeo.musicapi.model.Music
import com.israelbermeo.musicapi.repository.BandaRepository
import com.israelbermeo.musicapi.repository.MusicRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException
import javax.transaction.Transactional


@Service
class MusicService {
    @Autowired
    lateinit var musicRepository: MusicRepository
    @Autowired
    lateinit var bandaRepository: BandaRepository

    fun list ():List<Music>{
        return musicRepository.findAll()
    }

    fun getByid(idm:Long?):Music? {
        return musicRepository.findByIdm(idm)
    }

    fun getListaDes (descripcion:String?):List<Music>?{
        return musicRepository.getListaDes(descripcion)
    }

    fun save ( music: Music):Music {
        try {
            music.nombre?.takeIf { it.trim().isNotEmpty() }
                ?: throw Exception ("El campo no puede estar vacio")
            music.apellido?.takeIf { it.trim().isNotEmpty() }
                ?: throw Exception ("El campo  no puede estar vacio")
            music.edad?.takeIf { it > 17 }
                ?: throw Exception ("Debe ser mayor de 18 para registrarce")
            music.descripcion?.takeIf { it.trim().isNotEmpty() }
                ?: throw Exception ("El campo no debe estar vacio")

            bandaRepository.findById(music.bandaId)
                ?: throw Exception ("Id de la banda no encontrada")
        }
        catch (ex:Exception){
            throw ResponseStatusException(
                HttpStatus.NOT_FOUND, ex.message, ex
            )
        }

        return musicRepository.save(music)
    }

    fun update (music:Music):Music{
        try {
            music.nombre?.takeIf { it.trim().isNotEmpty() }
                ?: throw Exception ("El campo no puede estar vacio")

            music.apellido?.takeIf { it.trim().isNotEmpty() }
                ?: throw Exception ("El campo no puede estar vacio")
            music.edad?.takeIf { it > 17 }
                ?: throw Exception ("Debe ser mayor para registrarce")
            music.descripcion?.takeIf { it.trim().isNotEmpty() }
                ?: throw Exception ("El campo no puede estar vacio")

        }
        catch (ex: Exception) {
            throw ResponseStatusException(
                HttpStatus.NOT_FOUND, ex.message, ex
            )
        }
        return musicRepository.save(music)
    }


    /*fun update (music: Music):Music {
        musicRepository.findById_m(music.id_m) ?: throw Exception()
        return musicRepository.save(music)
    }*/
    fun updateUno (music: Music): Music{
        try {
            music.nombre?.takeIf { it.trim().isNotEmpty() }
                ?: throw Exception ("El campo no puede estar vacio")

            music.apellido?.takeIf { it.trim().isNotEmpty() }
                ?: throw Exception ("El campo no puede estar vacio")
            music.edad?.takeIf { it > 17 }
                ?: throw Exception ("Debe ser mayor para registrarce")
            music.descripcion?.takeIf { it.trim().isNotEmpty() }
                ?: throw Exception ("El campo no puede estar vacio")
            val response=musicRepository.findByIdm(music.idm)
                ?: throw Exception()
            response.apply {
                nombre=music.nombre
            }
            return musicRepository.save(response)

        }
        catch (ex: Exception) {
            throw ResponseStatusException(
                HttpStatus.NOT_FOUND, ex.message, ex
            )
        }


    }
    fun delete (idm:Long): Boolean{
       try {
            musicRepository.findByIdm(idm)
               ?:throw Exception("El id ${idm} no existe")

               musicRepository.deleteById(idm)

           return true
       }
       catch (ex:Exception){
           throw ResponseStatusException(
           HttpStatus.NOT_FOUND, ex.message, ex
           )
       }


    }

    @Transactional
    fun updateName (newName: NewName): String??{
       val  rowsUpdate= musicRepository.setNames(newName.nombre, newName.nuevoNombre)
        return "${rowsUpdate} rows updated"
    }
}