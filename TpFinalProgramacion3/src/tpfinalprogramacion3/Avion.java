package tpfinalprogramacion3;

import java.io.*;

public class Avion implements Serializable
{
    protected int capacidadDeCombustible;
    protected int costoPorKm;
    protected int capacidadMaxPasajeros;
    protected int velocidadMaxima;
    protected String tipoDePropulsion;

    public Avion(int capacidadDeCombustible, int costoPorKm, int capacidadMaxPasajeros, int velocidadMaxima, String tipoDePropulsion) 
    {
        this.capacidadDeCombustible = capacidadDeCombustible;
        this.costoPorKm = costoPorKm;
        this.capacidadMaxPasajeros = capacidadMaxPasajeros;
        this.velocidadMaxima = velocidadMaxima;
        this.tipoDePropulsion = tipoDePropulsion;
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
    
    public int tarifaAvion (Avion tipo){
        int tarifa=0;
        if(tipo instanceof AvionGold)
            tarifa = 6000;
        if(tipo instanceof AvionSilver)
            tarifa = 4000;
        if(tipo instanceof AvionBronze)
            tarifa = 3000;
        return tarifa;
    }
    
    public void escribirArchivo (String fileName,Avion escribir) 
    {
        File file = new File(fileName); 
        file.delete();
        FileOutputStream output=null;
        ObjectOutputStream writer=null;
        
        try
        {
            if(!file.exists())
            {
                file.createNewFile();
            }
            
            output = new FileOutputStream(file, true);
            writer = new ObjectOutputStream(output);
            
            writer.writeObject(escribir);

            output.close();
            writer.close();    
        }
        catch(Exception e)
        {
            System.out.println("Error dentro de escribirArchivo");   
        } 
    }
    
    
    public Avion leerArchivo (String fileName,Avion recibir) 
    {  
        File file = new File(fileName);
        FileInputStream input=null;
        ObjectInputStream reader=null;
        
        try
        {
            if(!file.exists())
            {
                file.createNewFile();
            }
            else
            {
                input = new FileInputStream(file);
                reader = new ObjectInputStream(input); 
                recibir = (Avion)reader.readObject();
            }
            input.close();
            reader.close();    
        }
        catch(Exception e)
        {
            System.out.println("Error dentro de leerArchivo");        
        } 
        
        return recibir;
    }  
}
