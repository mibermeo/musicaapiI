package com.israelbermeo.musicapi.model

import javax.persistence.*

@Entity
@Table(name= "musico")
class Music {


    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var idm: Long? = null
    @Column(name = "band_id")
    var bandaId: Long? =null
    var nombre: String? = null
    var apellido: String? = null
    var edad: Long? = null
    var descripcion: String? = null


}