package com.israelbermeo.musicapi.service

import com.israelbermeo.musicapi.model.Banda
import com.israelbermeo.musicapi.model.Music
import com.israelbermeo.musicapi.repository.BandaRepository
import com.israelbermeo.musicapi.repository.MusicRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException


@Service
class BandaService {

    @Autowired
   lateinit var  bandaRepository: BandaRepository

   @Autowired
   lateinit var musicRepository: MusicRepository

   fun list ():List<Banda>{
        return bandaRepository.findAll()
    }

    fun getByid (id:Long?):Banda? {
        return bandaRepository.findById(id)
    }

    fun save ( banda: Banda):Banda {
        try {
            banda.nombre_band?.takeIf { it.trim().isNotEmpty() }
                ?: throw Exception ("El campo no puede estar vacio")
            banda.genero?.takeIf { it.trim().isNotEmpty() }
                ?: throw Exception ("El campo no puede estar vacio")

            musicRepository.findByIdm(banda.idm)
                ?: throw Exception ("Id del musico no encontrada")
        }
        catch (ex:Exception){
            throw ResponseStatusException(
                HttpStatus.NOT_FOUND, ex.message, ex
            )
        }
        return bandaRepository.save(banda)
    }
    fun update (banda: Banda):Banda {
        try {
            banda.nombre_band?.takeIf { it.trim().isNotEmpty() }
                ?: throw Exception ("El campo no puede estar vacio")
            banda.genero?.takeIf { it.trim().isNotEmpty() }
                ?: throw Exception ("El campo no puede estar vacio")

        }
        catch (ex:Exception){
            throw ResponseStatusException(
                HttpStatus.NOT_FOUND, ex.message, ex
            )
        }
        return bandaRepository.save(banda)
    }
    fun updateUno (banda: Banda): Banda{
        try {
            banda.nombre_band?.takeIf { it.trim().isNotEmpty() }
                ?: throw Exception ("El campo no puede estar vacio")
            banda.genero?.takeIf { it.trim().isNotEmpty() }
                ?: throw Exception ("El campo no puede estar vacio")


            val response=bandaRepository.findById(banda.id)
                ?: throw Exception()
            response.apply {
                nombre_band=banda.nombre_band
            }
            return bandaRepository.save(response)
        }
        catch (ex:Exception){
            throw ResponseStatusException(
                HttpStatus.NOT_FOUND, ex.message, ex
            )
        }


    }

    fun delete (id:Long): Boolean{
        try {
            val response = bandaRepository.findById(id)
                ?:throw Exception("El id ${id} no existe")
            response.apply {
                bandaRepository.deleteById(id)
            }
            return true
        }
        catch (ex:Exception){
            throw ResponseStatusException(
                HttpStatus.NOT_FOUND, ex.message, ex
            )
        }
    }


    }
