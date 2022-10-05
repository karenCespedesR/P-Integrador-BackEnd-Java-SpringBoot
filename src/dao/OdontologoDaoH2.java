package dao;

import modelo.Odontologo;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OdontologoDaoH2 implements IDao<Odontologo> {

    private static final String SQL_INSERT="INSERT INTO ODONTOLOGOS(numeroMatricula,nombre,apellido) VALUES(?,?,?)";
    private static final String SQL_SELECTALL="SELECT * FROM ODONTOLOGOS";

    //implementar el logger
    private static final Logger logger = Logger.getLogger(OdontologoDaoH2.class);
    @Override
    public Odontologo guardar(Odontologo odontologo) {
        //conectar a la base y guardar el odontologo

        //uso de logger iniciando el guardado del odontologo
        logger.info("Registro de un odontologo nuevo:" + odontologo.toString());
        Connection connection = null;
        try {
            connection = BD.getConnection();
            PreparedStatement ps= connection.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1,odontologo.getNumeroMatricula());
            ps.setString(2,odontologo.getNombre());
            ps.setString(3,odontologo.getApellido());
            ps.executeUpdate();

            //procesamos la clave autogenerada;
            ResultSet claveGenerada=ps.getGeneratedKeys();
            while (claveGenerada.next()){
                odontologo.setId(claveGenerada.getInt(1));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        //logger de operacion exitosa
        logger.info(("El odontologo se registro correctamente:"+ odontologo.toString()));
        return odontologo;
    }

    @Override
    public List<Odontologo> buscarTodos() {
        //logger
        logger.info("Buscando todos los odontologos");

        Connection connection = null;
        List<Odontologo>odontologos = new ArrayList<>();
        try{
            connection=BD.getConnection();

            //crear la sentencia
            PreparedStatement ps=connection.prepareStatement(SQL_SELECTALL);

            //ejecutar la sentencia
            ResultSet rs = ps.executeQuery();

            //evaluar los resultados
            while (rs.next()){
                Odontologo odontologo= new Odontologo(rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4));
                odontologos.add(odontologo);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
            logger.info(("Los odontologos que se encontraron son:"+odontologos.toString()));
        return odontologos;
    }
}
