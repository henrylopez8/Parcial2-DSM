package sv.edu.udb.carsmotors;

public class TipoCoche_Class {
    private int id;
    private String Descripcion;

    public void setId(int id)
    {
        this.id = id;
    }

    public int getId()
    {
        return  id;
    }

    public  void setDescripcion(String Descripcion)
    {
        this.Descripcion=Descripcion;
    }

    public String getDescripcion()
    {
        return Descripcion;
    }
}
