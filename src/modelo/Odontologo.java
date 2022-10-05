package modelo;

public class Odontologo {

        private Integer id;
        private Integer numeroMatricula;
        private String nombre;
        private String apellido;


    //generar constructor sin id

        public Odontologo(Integer numeroMatricula, String nombre, String apellido) {
                this.numeroMatricula = numeroMatricula;
                this.nombre = nombre;
                this.apellido = apellido;
        }

        //generar constructor con id

        public Odontologo(Integer id, Integer numeroMatricula, String nombre, String apellido) {
                this.id = id;
                this.numeroMatricula = numeroMatricula;
                this.nombre = nombre;
                this.apellido = apellido;
        }


        //generar los getter y setter de todos

        public Integer getId() {
                return id;
        }

        public Integer getNumeroMatricula() {
                return numeroMatricula;
        }

        public String getNombre() {
                return nombre;
        }

        public String getApellido() {
                return apellido;
        }

        public void setId(Integer id) {
                this.id = id;
        }

        public void setNumeroMatricula(Integer numeroMatricula) {
                this.numeroMatricula = numeroMatricula;
        }

        public void setNombre(String nombre) {
                this.nombre = nombre;
        }

        public void setApellido(String apellido) {
                this.apellido = apellido;
        }

        //para logger generar toString

     @Override
    public String toString() {
        return "Odontologo:" +
                "id=" + id +
                ", numero de Matricula=" + numeroMatricula +
                ", nombre='" + nombre +
                ", apellido='" + apellido;
    }

}