package tpfinalprogramacion3;

import java.io.Serializable;

public class AvionGold extends Avion implements ServicioDeCatering, Serializable
{
    public AvionGold(int costoPorKm, int capacidadMaxPasajeros, int velocidadMaxima, String tipoDePropulsion) 
    {
        super(costoPorKm, capacidadMaxPasajeros, velocidadMaxima, tipoDePropulsion);
    }

    public String conexionWIFI ()
    {
        return "Conectandose a WIFI. . .";
    }
    
    @Override
    public String servicioDeCatering() 
    {
       return "Servicio de Catering"; 
    } 
}
