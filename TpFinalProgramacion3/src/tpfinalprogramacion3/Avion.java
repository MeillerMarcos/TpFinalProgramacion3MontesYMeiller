package tpfinalprogramacion3;

import java.io.*;

public class Avion implements Serializable
{
    protected int capacidadDeCombustible;
    protected int costoPorKm;
    protected int capacidadMaxPasajeros;
    protected int velocidadMaxima;
    protected String tipoDePropulsion;
    protected String tipoDeAvion;

    public Avion(int capacidadDeCombustible, int costoPorKm, int capacidadMaxPasajeros, int velocidadMaxima, String tipoDePropulsion, String tipoDeAvion) 
    {
        this.capacidadDeCombustible = capacidadDeCombustible;
        this.costoPorKm = costoPorKm;
        this.capacidadMaxPasajeros = capacidadMaxPasajeros;
        this.velocidadMaxima = velocidadMaxima;
        this.tipoDePropulsion = tipoDePropulsion;
        this.tipoDeAvion = tipoDeAvion;
    }

    public int getCapacidadDeCombustible() 
    {
        return capacidadDeCombustible;
    }
    
    public int getCostoPorKm() 
    {
        return costoPorKm;
    }

    public int getCapacidadMaxPasajeros() 
    {
        return capacidadMaxPasajeros;
    }

    public int getVelocidadMaxima() 
    {
        return velocidadMaxima;
    }

    public String getTipoDePropulsion() 
    {
        return tipoDePropulsion;
    }
    
    public String getTipoDeAvion ()
    {
        return tipoDeAvion;
    }

    public void setCapacidadDeCombustible(int capacidadDeCombustible) 
    {
        this.capacidadDeCombustible = capacidadDeCombustible;
    }

    public void setCostoPorKm(int costoPorKm) 
    {
        this.costoPorKm = costoPorKm;
    }

    public void setCapacidadMaxPasajeros(int capacidadMaxPasajeros) 
    {
        this.capacidadMaxPasajeros = capacidadMaxPasajeros;
    }

    public void setVelocidadMaxima(int velocidadMaxima) 
    {
        this.velocidadMaxima = velocidadMaxima;
    }

    public void setTipoDePropulsion(String tipoDePropulsion) 
    {
        this.tipoDePropulsion = tipoDePropulsion;
    }
    
    public String setTipoDeAvion ()
    {
        String tipoDeAvion = new String();
        
        if(this instanceof AvionGold)
        {
            tipoDeAvion = "Avion Gold";
        }
        
        if(this instanceof AvionSilver)
        {
            tipoDeAvion = "Avion Gold";
        }
        
        if(this instanceof AvionBronze)
        {
            tipoDeAvion = "Avion Gold";
        }
        
        return tipoDeAvion;
    }
    
    public int tarifaAvion (Avion tipo)
    {
        int tarifa=0;
        
        if(tipo instanceof AvionGold)
        {
            tarifa = 6000;
        }
            
        if(tipo instanceof AvionSilver)
        {
            tarifa = 4000;
        }
            
        if(tipo instanceof AvionBronze)
        {
            tarifa = 3000;
        }
            
        return tarifa;
    }
    
    public int tarifaAvion ()
    {
        int tarifa=0;
        
        if(this instanceof AvionGold)
        {
            tarifa = 6000;
        }
            
        if(this instanceof AvionSilver)
        {
            tarifa = 4000;
        }
            
        if(this instanceof AvionBronze)
        {
            tarifa = 3000;
        }
            
        return tarifa;
    }
}
