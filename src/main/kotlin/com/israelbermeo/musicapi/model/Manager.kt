package com.israelbermeo.musicapi.model

import javax.persistence.*

@Entity
@Table(name= "manager")
class Manager {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null
    var nombre: String? = null
    var apellido: String? = null
    var edad: Long? = null
    var correo: String? = null
    var contacto: String? = null

}