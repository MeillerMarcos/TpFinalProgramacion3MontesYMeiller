package tpfinalprogramacion3;

public class Fecha 
{
    private int dia;
    private int mes;
    private int anio;

    public Fecha() 
    {
        
    }

    public int getDia()
    {
        return dia;
    }

    public int getMes() 
    {
        return mes;
    }

    public int getAnio()
    {
        return anio;
    }

    public void setDia(int dia) 
    {
        this.dia = dia;
    }

    public void setMes(int mes) 
    {
        this.mes = mes;
    }

    public void setAnio(int anio) 
    {
        this.anio = anio;
    }

    @Override
    public String toString() 
    {
        return dia+"/"+mes+"/"+anio;
    } 
}
