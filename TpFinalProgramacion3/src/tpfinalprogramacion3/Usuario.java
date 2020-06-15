package tpfinalprogramacion3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Usuario implements Serializable
{
    private String nombre;
    private String apellido;
    private int edad;
    private int dni;

    public Usuario(String nombre, String apellido, int edad, int dni) 
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

    public int getDni() 
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

    public void setDni(int dni) 
    {
        this.dni = dni;
    }
    
        public void escribirArchivo (String fileName,Usuario escribir) 
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
    
    
    public Usuario leerArchivo (String fileName,Usuario recibir) 
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

                  
                recibir = (Usuario)reader.readObject();
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