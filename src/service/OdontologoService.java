package service;

import dao.IDao;
import modelo.Odontologo;

import java.util.List;

public class OdontologoService {

    private IDao<Odontologo> odontologoDao;

    //hacer un constructor


    public OdontologoService(IDao<Odontologo> odontologoDao) {
        this.odontologoDao = odontologoDao;
    }

    public Odontologo guardar (Odontologo odontologo){
        return odontologoDao.guardar(odontologo);
    }
    public List<Odontologo>buscarTodos(){
        return odontologoDao.buscarTodos();
    }


}
