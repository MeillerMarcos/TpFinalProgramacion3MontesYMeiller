package tpfinalprogramacion3;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class ArrayGenerico<E>
{
    private ArrayList<E> list;

    public ArrayGenerico(ArrayList<E> list) 
    {
        this.list = list;
    }

    public ArrayList<E> getList() 
    {
        return list;
    }

    public void setList(ArrayList<E> list) 
    {
        this.list = list;
    }
    
    public void agregarAlista (E objeto)
    {
        list.add(objeto);
    }
    /**
     * Recorre la lista y compara con el elemento recibido en parámetro.
     * @param buscar
     * @return -1 si no lo encuentra
     */
    public int buscarDentroDeLista (E buscar)
    {
        int control = -1;
        int i=0;
        int dimension=list.size();
        
        if(!list.isEmpty())
        {
            while(i<dimension && control==-1)
            {
                if(list.get(i).equals(buscar))
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
    
    /**
     * Quita un elemento específico dentro del array recibido en parametro
     * @param lista
     * @param eliminar 
     */
    public void quitarElementoDeArray (ArrayGenerico<E> lista,E eliminar)//devuelve false si no se encontro y sino True si se elimino
    { 
        int i = lista.buscarDentroDeLista(eliminar);
        lista.eliminar(i);   
    }
    
    /**
     * Elimina un elemento de la lista
     * @param posicion
     * @return 
     */
    public int eliminar (int posicion) 
    {
       
        if(posicion != -1)
        {
            list.remove(posicion);
        }
            
        return posicion;
    }
    
    /**
     * Reemplaza un elemento de la lista por otro
     * @param objeto
     * @param i 
     */
    public void reemplazar (E objeto, int i) 
    {
        list.set(i, objeto);
    }
    
    public void escribirArchivo (String fileName, ArrayList<E> escribir) //escribe en un archivo
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
    
    public ArrayList<E> leerArchivo (String fileName) //lee los datos de el archivo indicado
    {  
        ArrayList<E> recibir = new ArrayList<E>();
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
                recibir = (ArrayList<E>)reader.readObject();
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
    
    public void escribirArchivoGSon (String archivo, ArrayList<E> arrayG)
    {
        try
        {
            Gson gson = new Gson();
            String cadenaJson = gson.toJson(arrayG);
            FileWriter fileWriter = new FileWriter(archivo, true);
            fileWriter.write(cadenaJson);
            fileWriter.close();
        }
        catch(Exception e)
        {
            System.out.println(e); 
        }
    }
    
    public ArrayList<E> leerArchivoGSon (String nombreArchivo)
    {
        ArrayList<E> listaUsuarios = new ArrayList<E>();
        Type type = new TypeToken<ArrayList<E>>(){}.getType();
        
        try
        {
            File file = new File(nombreArchivo);
            Gson gson = new Gson();
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            listaUsuarios = gson.fromJson(bufferedReader, type);
        }
        catch(Exception e)
        {
            System.out.println(e); 
        } 
        System.out.println("sout en leer: "+listaUsuarios.toString());

        return listaUsuarios;
    }
}
