package tpfinalprogramacion3;

import com.google.gson.Gson;
import java.io.*;
import java.util.HashMap;

public class Vuelo implements Serializable
{
    private String origenDestino;
    private String fecha;
    private int cantidadAcompañantes;
    private Avion avion;
    private float costoTotal;
    HashMap<String, Integer> distanciasOrigenDestino = new HashMap<String, Integer>();
    Usuario usuario = new Usuario ();
    
    public Vuelo() 
    {
        this.cargaHashmap();
    }
    
    public String getOrigenDestino() 
    {
        return origenDestino;
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

    public float getCostoTotal() 
    {
        return costoTotal;
    }

    public HashMap<String, Integer> getDistanciasOrigenDestino() 
    {
        return distanciasOrigenDestino;
    }
    
    public Usuario getUsuario ()
    {
        return usuario;
    }
    
    public void setOrigenDestino(String origen) 
    {
        this.origenDestino = origen;
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

    public void setCostoTotal(float costoTotal) 
    {
        this.costoTotal = costoTotal;
    }

    public void setDistanciasOrigenDestino(HashMap<String, Integer> distanciasOrigenDestino) 
    {
        this.distanciasOrigenDestino = distanciasOrigenDestino;
    }
    
    public void setUsuario (Usuario usuario)
    {
        this.usuario = usuario;
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
    
    public boolean controlarFecha (String fecha)
    {
        boolean flag = false;
        
        if(this.fecha.equals(fecha))
        {
            flag = true;   
        }
        
        return flag; 
    }
    
    public boolean controlarTipoDeAvion (Avion avion, Avion avionNuevo)
    {
        boolean flag = false;
        
        if(avion instanceof AvionGold)
        {
            if(avionNuevo instanceof AvionGold)
            {
                flag = true;      
            }
        }
        
        return flag; 
    }
    
    public void cargaHashmap()
    {
        distanciasOrigenDestino.put("BsAs – Cordoba", 695);
        distanciasOrigenDestino.put("BsAs – Santiago", 1400);
        distanciasOrigenDestino.put("BsAs – Montevideo", 950);
        distanciasOrigenDestino.put("Cordoba – Santiago", 1050);
        distanciasOrigenDestino.put("Cordoba - Montevideo", 1190);
        distanciasOrigenDestino.put("Cordoba - BsAs", 695);
        distanciasOrigenDestino.put("Montevideo – Cordoba", 1190);
        distanciasOrigenDestino.put("Montevideo – Santiago", 2100); 
        distanciasOrigenDestino.put("Montevideo – BsAs", 950);
        distanciasOrigenDestino.put("Santiago – Cordoba", 1050);
        distanciasOrigenDestino.put("Santiago – Montevideo", 2100);
        distanciasOrigenDestino.put("Santiago – BsAs", 1400);
    }
    
    public void calcularTotal(String key)
    {
        int cantidadDeKm = distanciasOrigenDestino.get(key);
        costoTotal = (cantidadDeKm * avion.getCostoPorKm()) + (cantidadAcompañantes * 3500) +  avion.tarifaAvion(avion); 
    }
    
    public void escribirArchivo (String fileName,Vuelo vuelo) 
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

            writer.writeObject(vuelo);

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
    
    public void escribirArchivoGSon (String archivo, Vuelo vuelo)
    {
        try
        {
            File file = new File(archivo);
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
            vuelo = new Vuelo();
            Gson gson = new Gson();
            gson.toJson(vuelo, Vuelo.class, bufferedWriter);
        }
        catch(Exception e)
        {
            System.out.println(e); 
        }  
    }
    
    public Vuelo leerArchivoGSon (String archivo, Vuelo vuelo)
    {
        try
        {
            File file = new File(archivo);
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            Gson gson = new Gson();
            vuelo = gson.fromJson(bufferedReader, Vuelo.class);
            System.out.println(vuelo);
        }
        catch(Exception e)
        {
            System.out.println(e); 
        } 
        
        return vuelo;
    }

    @Override
    public String toString() 
    {
        return "---Vuelo---" + "  origenDestino:" + origenDestino + "  fecha:" + fecha + "  cantidadAcompañantes:" + cantidadAcompañantes + "  avion:" + avion + "  costoTotal:" 
        + costoTotal + "  distanciasOrigenDestino:" + distanciasOrigenDestino + "  usuario:" + usuario + " ---";
    }
    
    
}
