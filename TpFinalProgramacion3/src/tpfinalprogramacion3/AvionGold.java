package tpfinalprogramacion3;

public class AvionGold extends Avion implements ServicioDeCatering
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
