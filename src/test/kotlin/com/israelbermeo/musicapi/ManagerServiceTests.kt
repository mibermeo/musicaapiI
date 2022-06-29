package com.israelbermeo.musicapi

import com.israelbermeo.musicapi.service.ManagerService
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest


@SpringBootTest
class ManagerServiceTests {
    @Autowired
    lateinit var managerService: ManagerService
    @Test
    fun multiplicacionWhenLessThanTen (){
        val response=managerService.multiplicacion(1,7)
        Assertions.assertEquals(7,response)
    }

    @Test
    fun multiplicacionWhenMajorThanTen(){
        val response=managerService.multiplicacion(2,7)
        Assertions.assertEquals(5,response)
    }

    @Test
    fun ValidarSumaNui(){
        val response=managerService.SumaValores("0301707030")
        Assertions.assertEquals(20,response)
    }
}