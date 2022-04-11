package sv.edu.udb.carsmotors;

public class Automovil_Class {
    private int id;
    private String modelo;
    private String numerovin;
    private String numerochasis;
    private String numeromotor;
    private Integer numeroasientos;
    private String anio;
    private Integer capacidadasientos;
    private Float precio;

    //setters y getters
    public void setModelo(String model)
    {
        this.modelo = model;
    }

    public  void setNumeroVin(String vin)
    {
        this.numerovin = vin;
    }

    public  void setNumeroChasis(String chasis)
    {
        this.numerochasis = chasis;
    }

    public  void setNumeroMotor(String motor)
    {
        this.numeromotor = motor;
    }

    public  void setNumeroasientos(Integer nAsientos)
    {
     this.numeroasientos = nAsientos;
    }

    public  void setAnio(String Year)
    {
        this.anio = Year;
    }

    public  void setCapacidadAsientos(Integer Asientos)
    {
        this.capacidadasientos = Asientos;
    }

    public  void setPrecio(Float price)
    {
        this.precio = price;
    }

    public void setId(int iD)
    {
        this.id = iD;
    }

    public int getId()
    {
        return  id;
    }
    public  String getModelo(){return  modelo;}
    public  String getNumerovin(){return  numerovin;}
    public  String getNumerochasis(){return numerochasis;}
    public String getNumeromotor(){return  numeromotor;}
    public Integer getNumeroasientos(){return  numeroasientos;}
    public String getAnio(){return  anio;}
    public Integer getCapacidadasientos(){return capacidadasientos;}
    public Float getPrecio(){return  precio;}
}
