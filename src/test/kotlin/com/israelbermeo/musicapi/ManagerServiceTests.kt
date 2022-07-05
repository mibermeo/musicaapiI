package com.israelbermeo.musicapi

import com.google.gson.Gson
import com.israelbermeo.musicapi.model.Manager
import com.israelbermeo.musicapi.repository.ManagerRepository
import com.israelbermeo.musicapi.service.ManagerService
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import java.io.File


@SpringBootTest
class ManagerServiceTests {
/*    @InjectMocks
    lateinit var managerService: ManagerService

    @Mock
    lateinit var managerRepository: ManagerRepository

    val jsonString = File("./src/test/resources/gerent.json").readText(Charsets.UTF_8)
    val productMock = Gson().fromJson(jsonString, Manager::class.java)


    @Test
    fun saveProduct() {

        Mockito.`when`(managerRepository.save(Mockito.any(Manager::class.java))).thenReturn(productMock)
        val response = managerService.save(productMock)
        Assertions.assertEquals(response?.id, productMock.id)
    }

    @Test
    fun saveProductFailed() {
        Assertions.assertThrows(Exception::class.java) {
            productMock.apply { nombre = " " }
            Mockito.`when`(managerRepository.save(Mockito.any(Manager::class.java))).thenReturn(productMock)
            managerService.save(productMock)
        }
    }*/


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

    @Test
    fun validarDecenaSuperiorCuandoNoEsCero(){
        val response = managerService.findDecenaSuperior(25)
        Assertions.assertEquals(5, response)
    }

    @Test
    fun validarDecenaSuperiorCuandoEsCero(){
        val response = managerService.findDecenaSuperior(10)
        Assertions.assertEquals(0, response)
    }

    @Test
    fun validarCedulaIsValida(){
        val response = managerService.validarCedula("0105785505")
        Assertions.assertEquals(true, response)
    }

    @Test
    fun validarCedulaIsInvalid(){
        val response = managerService.validarCedula("0105785555")
        Assertions.assertEquals(false, response)
    }
}

