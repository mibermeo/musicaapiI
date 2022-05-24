package com.israelbermeo.musicapi.model

import javax.persistence.*

@Entity
@Table(name= "band")

class Banda {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null
    @Column(name = "manager_id")
    var managerId: Long? = null
    var nombre_band: String? = null
    var genero: String? = null


}