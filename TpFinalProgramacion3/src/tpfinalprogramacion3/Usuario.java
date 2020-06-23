package tpfinalprogramacion3;

import java.io.*;
import java.util.ArrayList;

public class Usuario implements Serializable
{
    private String nombre;
    private String apellido;
    private int edad;
    private String dni; 
    
    public Usuario(String nombre, String apellido, int edad, String dni) 
    {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.dni = dni;
    }

    public Usuario () 
    {
        
    }

    public String getNombre() 
    {
        return nombre;
    }

    public String getApellido() 
    {
        return apellido;
    }

    public int getEdad() 
    {
        return edad;
    }

    public String getDni() 
    {
        return dni;
    }

    public void setNombre(String nombre) 
    {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) 
    {
        this.apellido = apellido;
    }

    public void setEdad(int edad) 
    {
        this.edad = edad;
    }

    public void setDni(String dni) 
    {
        this.dni = dni;
    }
    
    public String avionMasUtilizado (ArrayGenerico<Vuelo> listaVuelos, String dni)
    {
        int contadorGold=0;
        int contadorSilver=0;
        int contadorBronze=0;
        String avionMasUtilizado = new String();
        
        for (int i=0;i<listaVuelos.getList().size();i++) 
        {
            if(listaVuelos.getList().get(i).getAvion() instanceof AvionGold && listaVuelos.getList().get(i).getUsuario().getDni().equals(dni))
            {
                contadorGold++; 
            }
            else if(listaVuelos.getList().get(i).getAvion() instanceof AvionSilver && listaVuelos.getList().get(i).getUsuario().getDni().equals(dni))
            {
                contadorSilver++;
            }
            else if(listaVuelos.getList().get(i).getAvion() instanceof AvionBronze && listaVuelos.getList().get(i).getUsuario().getDni().equals(dni))
            {
                contadorBronze++;
            }
        }
       
        if (contadorGold >= contadorSilver && contadorGold >= contadorBronze )
        {
            avionMasUtilizado="Avion Gold";
        }
        else
        {
            if (contadorSilver > contadorBronze)
            {
                avionMasUtilizado="Avion Silver";
            }
            else
            {
                avionMasUtilizado="Avion Bronze";  
            }
        }  
         if(contadorGold == 0 && contadorSilver == 0 && contadorBronze == 0 )
             avionMasUtilizado = "No utilizo ningun avion...";
        
        return avionMasUtilizado;
    }
    
    public int costoTotalDeVuelos (ArrayGenerico<Vuelo> listaVuelos, String dni)
    {
        int i = 0;
        int total = 0;
        for(i= 0; i< listaVuelos.getList().size();i++)
        {
            if(listaVuelos.getList().get(i).getUsuario().getDni().equals(dni))
                total += listaVuelos.getList().get(i).getCostoTotal();
        }
        return total;
    }
    
    public int buscarDni (ArrayList<Usuario> listaDeUsuarios, String dni) ///devuelve -1 si no lo encuentra, si no su posicion dentro de la lista
    {
        int control = -1;
        int i=0;
        int dimension=listaDeUsuarios.size();
        
        if(!listaDeUsuarios.isEmpty())
        {
            while(i<dimension && control==-1)
            {
                if(listaDeUsuarios.get(i).getDni().equals(dni))
                {
                    control=i;
                } 
                else
                {
                    i++; 
                }
            }  
        }
        
        return control;
    }
    
    public void escribirArchivo (String fileName,ArrayList<Usuario> escribir) 
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
    
    public ArrayList<Usuario> leerArchivo (String fileName) 
    {  
        ArrayList<Usuario> recibir = new ArrayList<Usuario>();
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
                recibir = (ArrayList<Usuario>)reader.readObject();
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

    @Override
    public String toString() 
    {
        return "---Usuario---" + " nombre:" + nombre + "  apellido:" + apellido + "  edad:" + edad + "  dni:" + dni + " ---";
    }
    
    
}