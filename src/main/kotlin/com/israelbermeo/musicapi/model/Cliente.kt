package com.israelbermeo.musicapi.model

import javax.persistence.*

@Entity
@Table(name= "cliente")
class Cliente {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null
    var nombre_cli: String? = null
    var apelli_cli: String? = null
    var edad: Long? = null
    var correo: String? = null
}