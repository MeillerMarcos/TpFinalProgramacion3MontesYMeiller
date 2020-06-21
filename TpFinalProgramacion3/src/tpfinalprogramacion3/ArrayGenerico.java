package tpfinalprogramacion3;

import com.google.gson.Gson;
import java.io.*;
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
    
    public int buscarDentroDeLista (E buscar) ///devuelve -1 si no lo encuentra, si no su posicion dentro de la lista
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
    
    public int eliminar (int posicion) //elimina el elemento indicado y devuelve -1 si no se borro
    {
       
        if(posicion != -1)
        {
            list.remove(posicion);
        }
            
        return posicion;
    }
    
    public void reemplazar (E objeto, int i) ///reemplaza un elemento de la lista por otro
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
            File file = new File(archivo);
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
            arrayG = new ArrayList<E>();
            Gson gson = new Gson();
            gson.toJson(arrayG, Vuelo.class, bufferedWriter);
        }
        catch(Exception e)
        {
            System.out.println(e); 
        }  
    }
    
    public ArrayList<E> leerArchivoGSon (String archivo, ArrayList<E> arrayG)
    {
        try
        {
            File file = new File(archivo);
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            Gson gson = new Gson();
            arrayG = gson.fromJson(bufferedReader, ArrayList.class);
            System.out.println(arrayG);
        }
        catch(Exception e)
        {
            System.out.println(e); 
        } 
        
        return arrayG;
    }
}
