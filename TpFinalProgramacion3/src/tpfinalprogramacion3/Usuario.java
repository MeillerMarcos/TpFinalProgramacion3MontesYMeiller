package tpfinalprogramacion3;

import java.io.*;
import java.util.ArrayList;

public class Usuario implements Serializable
{
    private String nombre;
    private String apellido;
    private int edad;
    private String dni;
    private ArrayList <Usuario> listaUsuario = new ArrayList<Usuario>();  
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

    public ArrayList<Usuario> getListaUsuario() 
    {
        return listaUsuario;
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

    public void setListaUsuario(ArrayList<Usuario> listaUsuario) 
    {
        this.listaUsuario = listaUsuario;
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
        return "Usuario{" + "nombre=" + nombre + ", apellido=" + apellido + ", edad=" + edad + ", dni=" + dni + '}';
    }
    
    
}