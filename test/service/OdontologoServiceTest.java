package service;

import dao.BD;
import dao.OdontologoDaoH2;
import modelo.Odontologo;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OdontologoServiceTest {

    private OdontologoService odontologoService=new OdontologoService(new OdontologoDaoH2());
    
    @Test
    public void guardarOdontologoTest() throws Exception {
        BD.crearBD();
        Odontologo odontologo= new Odontologo(15686,"Nicola","Tesla");
        odontologoService.guardar(odontologo);
        assertTrue(odontologo.getId()==1);
    }

    public void buscarTodosOdontolosTest(){
        Odontologo odontologo2 = new Odontologo(16845,"Maria","del Barrio");
        odontologoService.guardar((odontologo2));
        odontologoService.buscarTodos();

    }

}