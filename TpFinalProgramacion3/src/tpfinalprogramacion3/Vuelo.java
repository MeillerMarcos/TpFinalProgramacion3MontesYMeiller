package tpfinalprogramacion3;

import java.util.HashMap;


public class Vuelo
{
    private String origen;
    private String destino;
    private String fecha;
    private int cantidadAcompañantes;
    private Avion avion;
    private float costoTotal;
    HashMap<String,Integer> cantidadKm = new HashMap<String,Integer>();

    public Vuelo() {
    }

    
    
    public Vuelo(String origen, String destino, String fecha, int cantidadAcompañantes, Avion avion, float costoTotal) 
    {
        this.origen = origen;
        this.destino = destino;
        this.fecha = fecha;
        this.cantidadAcompañantes = cantidadAcompañantes;
        this.avion = avion;
        this.costoTotal = costoTotal;
    }

    public String getOrigen() 
    {
        return origen;
    }

    public String getDestino() 
    {
        return destino;
    }

    public String getFecha() 
    {
        return fecha;
    }

    public int getCantidadAcompañantes() 
    {
        return cantidadAcompañantes;
    }

    public Avion getAvion() 
    {
        return avion;
    }

    public float getCostoTotal() 
    {
        return costoTotal;
    }

    public void setOrigen(String origen) 
    {
        this.origen = origen;
    }

    public void setDestino(String destino) 
    {
        this.destino = destino;
    }

    public void setFecha(String fecha) 
    {
        this.fecha = fecha;
    }

    public void setCantidadAcompañantes(int cantidadAcompañantes) 
    {
        this.cantidadAcompañantes = cantidadAcompañantes;
    }

    public void setAvion(Avion avion) 
    {
        this.avion = avion;
    }

    public void setCostoTotal(float costoTotal) 
    {
        this.costoTotal = costoTotal;
    }
    
    public boolean comprobarOrigenDestino (String origen, String destino)
    {
        boolean flag;
        
        if(origen == destino)
        {
           flag = false; 
        }  
        else
        {
            flag = true;
        }
        
        return flag;
    }
    
    public boolean comprobarPasajeros ()
    {
        boolean flag;
        
        if(cantidadAcompañantes > avion.getCapacidadMaxPasajeros())
        {
            flag = false;      
        }   
        else
        {
            flag = true;
        }
        
        return flag;
    }
    public void cargaHashmap()
    {
        cantidadKm.put("BsAs – Cordoba ", 695);
        cantidadKm.put("BsAs – Santiago  ", 1400);
        cantidadKm.put("BsAs – Montevideo ", 950);
        cantidadKm.put("Cordoba - Montevideo ", 1190);
        cantidadKm.put("Cordoba – Santiago ", 1050);
        cantidadKm.put("Montevideo – Santiago ", 2100); 
    }
    
    public void calcularTotal(String key)
    {
        Integer cantidadDeKm = cantidadKm.get(key);
        //costoTotal = (cantidadDeKm * avion.getCostoPorKm()) + (cantidadAcompañantes * 3500) +  (Tarifa del tipo de avión); 
    }
}
