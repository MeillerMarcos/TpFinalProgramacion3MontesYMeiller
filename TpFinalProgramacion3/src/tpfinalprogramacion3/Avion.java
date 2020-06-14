package tpfinalprogramacion3;

import java.io.Serializable;

public class Avion implements Serializable
{
    protected int costoPorKm;
    protected int capacidadMaxPasajeros;
    protected int velocidadMaxima;
    protected String tipoDePropulsion;

    public Avion(int costoPorKm, int capacidadMaxPasajeros, int velocidadMaxima, String tipoDePropulsion) 
    {
        this.costoPorKm = costoPorKm;
        this.capacidadMaxPasajeros = capacidadMaxPasajeros;
        this.velocidadMaxima = velocidadMaxima;
        this.tipoDePropulsion = tipoDePropulsion;
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
}
