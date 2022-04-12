package sv.edu.udb.carsmotors;

public class Usuario_Class {
    private int id;
    private String Nombre;
    private String Apellido;

    public void setId(int id)
    {
        this.id = id;
    }

    public int getId()
    {
        return  id;
    }

    public  String getApellido(){
        return Apellido;
    }

    public void setApellido(String Apellido)
    {
        this.Apellido = Apellido;
    }

    public  void setNombre(String Nombre)
    {
        this.Nombre=Nombre;
    }

    public String getNombre()
    {
        return Nombre;
    }
}
