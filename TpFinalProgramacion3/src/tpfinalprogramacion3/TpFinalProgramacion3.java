package tpfinalprogramacion3;

import java.util.Scanner;

public class TpFinalProgramacion3 
{
    public static void main(String[] args) 
    {
         menuVuelo();
    } 
    
    public static void mensajeOpcionInvalida () 
    {
        System.out.println("Opcion inválida. Ingrese nuevamente. . .");
        
        try
        {
            Thread.sleep(1200);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        
        for (int i=0;i<50;i++) 
        {
            System.out.println("\n\n\n");
        }  
    }
    
    public static void menuVuelo ()
    {
        int opcion=0;
        Vuelo vuelo = new Vuelo();
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Eliga el vuelo: ");
        System.out.println("1. BsAs – Cordoba");
        System.out.println("2. BsAs – Santiago");
        System.out.println("3. BsAs – Montevideo");
        System.out.println("4. Cordoba - Montevideo");
        System.out.println("5. Cordoba – Santiago");
        System.out.println("6. Montevideo – Santiago"); 
        System.out.println("Opcion: ");
        opcion = scan.nextInt();
        
        if(opcion<1 || opcion>6)
        {
            mensajeOpcionInvalida();
            menuVuelo();
        }
        
        switch(opcion)
        {
            case 1:
                vuelo.calcularTotal("BsAs – Cordoba");
            case 2:
                vuelo.calcularTotal("BsAs – Santiago");
            case 3:
                vuelo.calcularTotal("BsAs – Montevideo");
            case 4:
                vuelo.calcularTotal("Cordoba - Montevideo");
            case 5:
                vuelo.calcularTotal("Cordoba – Santiago");
            case 6:
                vuelo.calcularTotal("Montevideo – Santiago");                        
        }
    }
}
