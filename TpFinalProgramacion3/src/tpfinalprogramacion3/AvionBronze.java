package tpfinalprogramacion3;

import java.io.Serializable;

public class AvionBronze extends Avion implements Serializable
{
    public AvionBronze(int costoPorKm, int capacidadMaxPasajeros, int velocidadMaxima, String tipoDePropulsion) 
    {
        super(costoPorKm, capacidadMaxPasajeros, velocidadMaxima, tipoDePropulsion);
    } 
}
