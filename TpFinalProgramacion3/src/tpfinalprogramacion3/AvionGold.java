package tpfinalprogramacion3;

public class AvionGold extends Avion implements ServicioDeCatering
{
    public AvionGold(int capacidadDeCombustible, int costoPorKm, int capacidadMaxPasajeros, int velocidadMaxima, String tipoDePropulsion, String tipoDeAvion) 
    {
        super(capacidadDeCombustible, costoPorKm, capacidadMaxPasajeros, velocidadMaxima, tipoDePropulsion, tipoDeAvion);
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
