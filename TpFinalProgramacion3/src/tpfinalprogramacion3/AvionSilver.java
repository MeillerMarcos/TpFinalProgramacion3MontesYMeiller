package tpfinalprogramacion3;

public class AvionSilver extends Avion implements ServicioDeCatering
{
    public AvionSilver(int capacidadDeCombustible, int costoPorKm, int capacidadMaxPasajeros, int velocidadMaxima, String tipoDePropulsion, String tipoDeAvion) 
    {
        super(capacidadDeCombustible, costoPorKm, capacidadMaxPasajeros, velocidadMaxima, tipoDePropulsion, tipoDeAvion);
    }
    
    @Override
    public String servicioDeCatering() 
    {
       return "Servicio de Catering"; 
    } 
}
