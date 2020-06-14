package tpfinalprogramacion3;

import java.util.Scanner;

public class TpFinalProgramacion3 
{
    public static void main(String[] args) 
    {
        menuPrincipal();
    } 
    
    public static void refrescarConsola ()
    {
        for (int i=0;i<100;i++) 
        {
            System.out.println("\n\n\n");
        }
    }
    
    public static void sleepMs (int ms)
    {
        try
        {
            Thread.sleep(ms);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
    public static void mensajeOpcionInvalida () 
    {
        System.out.println("Opcion inválida. Ingrese nuevamente. . .");
        sleepMs(1200);
    }

    public static void menuPrincipal ()
    {
        int opcion=0;
        Scanner scan = new Scanner(System.in);
        
        refrescarConsola();
        System.out.println("------Menu principal------");
        System.out.println();
        System.out.println("1. Registrar usuario");
        System.out.println("2. Contratar un nuevo vuelo");
        System.out.println();
        System.out.println("Opcion: ");
        opcion = scan.nextInt();
        
        if(opcion<1 || opcion>2)
        {
            mensajeOpcionInvalida();
            menuPrincipal();
        }
        
        switch(opcion)
        {
            case 1:
                menuRegistroUsuario();
                break;
            case 2:
                menuVuelo();
                break;
        }
    }
    
    public static void menuVuelo ()
    {
        int opcion=0;
        Vuelo vuelo = new Vuelo();
        Scanner scan = new Scanner(System.in);
        
        refrescarConsola();
        System.out.println("---Menu contratación de vuelo---");
        System.out.println();
        System.out.println("Eliga el vuelo: ");
        System.out.println();
        System.out.println("1. BsAs – Cordoba");
        System.out.println("2. BsAs – Santiago");
        System.out.println("3. BsAs – Montevideo");
        System.out.println("4. Cordoba - Montevideo");
        System.out.println("5. Cordoba – Santiago");
        System.out.println("6. Montevideo – Santiago"); 
        System.out.println();
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
                break;
            case 2:
                vuelo.calcularTotal("BsAs – Santiago");
                break;
            case 3:
                vuelo.calcularTotal("BsAs – Montevideo");
                break;
            case 4:
                vuelo.calcularTotal("Cordoba - Montevideo");
                break;
            case 5:
                vuelo.calcularTotal("Cordoba – Santiago");
                break;
            case 6:
                vuelo.calcularTotal("Montevideo – Santiago");
                break;
        }
        
        menuPrincipal();
    }
    
    public static void menuRegistroUsuario ()
    {
        Usuario usuario = new Usuario();
        Scanner scan = new Scanner(System.in);
        String nombre = new String();
        String apellido = new String();
        int dni=0;
        int edad=0;
        
        refrescarConsola();
        System.out.println("---Menu de registro de usuario---");
        System.out.println("Ingrese su nombre: ");
        nombre = scan.next();
        System.out.println("Ingrese su apellido: ");
        apellido = scan.next();
        System.out.println("Ingrese su DNI: ");
        dni = scan.nextInt();
        System.out.println("Ingrese su edad: ");
        edad = scan.nextInt();
        
        menuPrincipal();  
    }

    public static int ValidarAnio ()
    {
        Scanner scan = new Scanner(System.in);
        int anio=0;

        System.out.println("\n\nIngrese anio del 2020 al 2030: ");
        System.out.println("Ingrese '0' para cancelar");
        anio = scan.nextInt();

        if(anio==0)
        {
            menuVuelo();
        }

        while(anio<2020 || anio >2030)
        {
            refrescarConsola();
            System.out.println("\nAnio invalido. El anio varia desde 2020 hasta 2030.");
            System.out.println("\n\nIngrese el anio del 2020 al 2030: ");
            System.out.println("Ingrese '0' para cancelar");
            anio = scan.nextInt();

            if(anio==0)
            {
                menuVuelo();
            }
        }

        return anio;
    }

    public static int ValidarMes ()
    {
        Scanner scan = new Scanner(System.in);
        int mes=0;

        System.out.println("Ingrese mes del 1 al 12: ");
        System.out.println("Ingrese '0' para cancelar");
        mes = scan.nextInt();

        if(mes==0)
        {
            menuVuelo();
        }

        while(mes<=0 || mes>=13)
        {
            refrescarConsola();
            System.out.println("\nEl mes solo puede variar del 1 al 12.");
            System.out.println("Ingrese '0' para cancelar");
            System.out.println("\n\nIngrese el mes del 1 al 12: ");
            mes = scan.nextInt();

            if(mes==0)
            {
                menuVuelo();
            }
        }

        return mes;
    }
    
    public static String fechavta (int mes, int anio)
    {
        Scanner scan = new Scanner(System.in);
        String fecha = new String();
        int limiteDia=0;
        int dia=0;

        System.out.println("\nFecha de venta:__/__/__");
        System.out.println("\nIngrese el anio: ");
        anio = scan.nextInt();

        while(anio<2018 || anio >2030)
        {
            refrescarConsola();
            System.out.println("\nFecha de venta:__/__/__");
            System.out.println("\nAnio invalido. El anio varia desde 2018 hasta 2030.");
            
            System.out.println("\nFecha de venta:__/__/__");
            System.out.println("\nIngrese el anio: ");
            
            anio = scan.nextInt();
        }
        refrescarConsola();

        System.out.println("\nFecha de venta:__/__/%d"+anio);
        System.out.println("\nIngrese el mes: ");
        mes = scan.nextInt();

        while(mes<=0 || mes>=13)
        {
            refrescarConsola();
            System.out.println("\nFecha de venta:__/__/%d"+anio);
            System.out.println("\nEl mes solo puede variar del 1 al 12.");
            System.out.println("\nFecha de venta:__/__/%d"+anio);
            System.out.println("\nIngrese el mes: ");
            mes = scan.nextInt();
        }
        refrescarConsola();

        System.out.println("\nFecha de venta:__/"+mes+"/"+anio+"/");

        if(anio%4==0)
        {
            if(mes==2)
            {
                limiteDia=29;
            }
            else
            {
                if(mes==1 || mes==3 || mes==5 || mes==7 || mes==8 || mes==10 || mes==12)
                {
                    limiteDia=31;
                }
                else
                {
                    limiteDia=30;
                }
            }
        }
        else
        {
            if(mes==2)
            {
                limiteDia=28;
            }
            else
            {
                if(mes==1 || mes==3 || mes==5 || mes==7 || mes==8 || mes==10 || mes==12)
                {
                    limiteDia=31;
                }
                else
                {
                    limiteDia=30;
                }
            }
        }
        refrescarConsola();

        System.out.println("\nFecha de venta:__/"+mes+"/"+anio+"/");
        System.out.println("\nIngrese el dia: ");
        dia = scan.nextInt(); 

        while(dia <=0 || dia>limiteDia)
        {
            refrescarConsola();
            System.out.println("\nFecha de venta:__/"+mes+"/"+anio+"/");
            System.out.println("\nEl dia puede variar de 1 a %d."+limiteDia);
            System.out.println("\nFecha de venta:__/"+mes+"/"+anio+"/");
            System.out.println("\nIngrese el dia: ");
            
            dia = scan.nextInt();
        }

        System.out.println("\nFecha valida de venta:"+dia+"/"+mes+"/"+anio+"/");

        fecha = dia+"/"+mes+"/"+anio+"/";
        
        return fecha;
    }
}
