package tpfinalprogramacion3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;


public class Vuelo
{
    private String origen;
    private String destino;
    private String fecha;
    private int cantidadAcompañantes;
    private Avion avion;
    private int costoTotal;
    HashMap<String,Integer> cantidadKm = new HashMap<String,Integer>();

    public Vuelo(String origen, String destino, String fecha, int cantidadAcompañantes, Avion avion, int costoTotal) 
    {
        this.origen = origen;
        this.destino = destino;
        this.fecha = fecha;
        this.cantidadAcompañantes = cantidadAcompañantes;
        this.avion = avion;
        this.costoTotal = costoTotal;
    }
    
    public Vuelo() 
    {
        
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

    public int getCostoTotal() 
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

    public void setCostoTotal(int costoTotal) 
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
        cantidadKm.put("BsAs – Cordoba", 695);
        cantidadKm.put("BsAs – Santiago", 1400);
        cantidadKm.put("BsAs – Montevideo", 950);
        cantidadKm.put("Cordoba - Montevideo", 1190);
        cantidadKm.put("Cordoba – Santiago", 1050);
        cantidadKm.put("Montevideo – Santiago", 2100); 
    }
    
    public void calcularTotal(String key)
    {
        int cantidadDeKm = cantidadKm.get(key);
        System.out.println(cantidadDeKm);
        costoTotal = (cantidadDeKm * avion.getCostoPorKm()) + (cantidadAcompañantes * 3500) +  avion.tarifaAvion(avion); 
    }
    
   
    
        public void escribirArchivo (String fileName,Vuelo escribir) 
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
    
    
    public Vuelo leerArchivo (String fileName,Vuelo recibir) 
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

                  
                recibir = (Vuelo)reader.readObject();
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
