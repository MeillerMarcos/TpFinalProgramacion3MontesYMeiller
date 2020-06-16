package tpfinalprogramacion3;

import java.io.Serializable;

public class AvionSilver extends Avion implements Serializable
{
    public AvionSilver(int costoPorKm, int capacidadMaxPasajeros, int velocidadMaxima, String tipoDePropulsion) 
    {
        super(costoPorKm, capacidadMaxPasajeros, velocidadMaxima, tipoDePropulsion);
    }
}
