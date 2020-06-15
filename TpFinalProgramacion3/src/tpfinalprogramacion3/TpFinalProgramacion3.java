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
    
    public static void asteriscosDeEspera ()
    {
        sleepMs(350);
        System.out.println("*");
        sleepMs(350);
        System.out.println("*");
        sleepMs(350);
        System.out.println("*");
        sleepMs(400);
    }
    
    public static void mensajeOpcionInvalida () 
    {
        System.out.println("Opcion inválida. Ingrese nuevamente");
        asteriscosDeEspera();
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
        System.out.println("3. Listado de fechas de vuelos");
        System.out.println("4. Salir");
        System.out.println();
        System.out.println("Opcion: ");
        opcion = scan.nextInt();
        
        if(opcion<1 || opcion>4)
        {
            mensajeOpcionInvalida();
            menuPrincipal();
        }
        
        switch(opcion)
        {
            case 1:
                menuUsuarios();
                break;
            case 2:
                menuVuelo();
                break;
            case 3:
                refrescarConsola();
                System.out.println("No funcional");
                asteriscosDeEspera();
                menuPrincipal();
                break;
            case 4:
                System.exit(0);
        }
    }
    
    public static void mostrarOpcionesOrigenYDestino ()
    {
        System.out.println("Eliga el origen y el destino: ");
        System.out.println();
        System.out.println("1. BsAs – Cordoba");
        System.out.println("2. BsAs – Santiago");
        System.out.println("3. BsAs – Montevideo");
        System.out.println("4. Cordoba - Montevideo");
        System.out.println("5. Cordoba – Santiago");
        System.out.println("6. Montevideo – Santiago");
    }
    
    public static void menuVuelo ()
    {
        Vuelo vuelo = new Vuelo();
        Scanner scan = new Scanner(System.in);
        int cantidad=0;
        int opcion=0;
        int anio=0;
        int mes=0;
        String fechaElegida = new String();
        String vueloElegido = new String();
        
        refrescarConsola();
        System.out.println("---Menu contratación de vuelo---");
        System.out.println();
        System.out.println("Ingrese la fecha del vuelo: ");
        fechaElegida = ingresarFecha();
        System.out.println("Fecha elegida: "+fechaElegida);
        asteriscosDeEspera();
        
        refrescarConsola();
        mostrarOpcionesOrigenYDestino(); 
        System.out.println();
        System.out.println("Opcion: ");
        opcion = scan.nextInt();
        
        while(opcion<1 || opcion>6)
        {
            mensajeOpcionInvalida();
            refrescarConsola();
            System.out.println("---Menu contratación de vuelo---");
            System.out.println();
            mostrarOpcionesOrigenYDestino(); 
            System.out.println();
            System.out.println("Opcion: ");
            opcion = scan.nextInt();
        }
        
        switch(opcion)
        {
            case 1:
                vueloElegido = "BsAs – Cordoba";
                break;
            case 2:
                vueloElegido = "BsAs – Santiago";
                break;
            case 3:
                vueloElegido = "BsAs – Montevideo";
                break;
            case 4:
                vueloElegido = "Cordoba - Montevideo";
                break;
            case 5:
                vueloElegido = "Cordoba – Santiago";
                break;
            case 6:
                vueloElegido = "Montevideo – Santiago";
                break;
        }
        
        System.out.println();
        System.out.println("Usted ha elegido: '"+vueloElegido+"'");
        System.out.println();
        System.out.println("Eliga la cantidad de acompañantes: ");
        cantidad = scan.nextInt();

        vuelo.setCantidadAcompañantes(cantidad);
        
        if(!vuelo.comprobarPasajeros())
        {
            System.out.println("No tenemos aviones disponibles con esa capacidad de pasajeros");
        }
            
        vuelo.calcularTotal(vueloElegido);
        System.out.println("costo total del vuelo:"+ vuelo.getCostoTotal());
        
        
        
        
        
        System.out.println("mensaje final, vuelve a menu principal");
        menuPrincipal();
    }
    
    public static void menuUsuarios ()
    {
        Scanner scan = new Scanner(System.in);
        Usuario usuario = new Usuario();
        String nombre = new String();
        String apellido = new String();
        int dni=0;
        int edad=0;
        int opcion=0;
        
        refrescarConsola();
        System.out.println("------Menu de usuarios------");
        System.out.println();
        System.out.println("1. Registrar usuario");
        System.out.println("2. Listado de usuarios");
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
                refrescarConsola();
                System.out.println("Ingrese su nombre: ");
                nombre = scan.next();
                System.out.println("Ingrese su apellido: ");
                apellido = scan.next();
                System.out.println("Ingrese su DNI: ");
                dni = scan.nextInt();
                System.out.println("Ingrese su edad: ");
                edad = scan.nextInt();
                break;
            case 2:
                refrescarConsola();
                System.out.println("No funcional");
                asteriscosDeEspera();
                menuPrincipal();
                break;
        }
        
        
        
        
        
        
        
        
        
        
        
        menuPrincipal();  
    }

    public static int validarAnio ()
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

    public static int validarMes ()
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
    
    public static String ingresarFecha ()
    {
        Scanner scan = new Scanner(System.in);
        String fecha = new String();
        int limiteDia=0;
        int dia=0;
        int mes=0;
        int anio=0;

        System.out.println("\nFecha de vuelo:__/__/__");
        System.out.println("\nIngrese el anio: ");
        System.out.println("Ingrese '0' para cancelar la operacion");
        anio = scan.nextInt();
        
        if(anio==0)
        {
            menuPrincipal();
        }

        while(anio<2018 || anio >2030)
        {
            refrescarConsola();
            System.out.println("\nFecha de vuelo:__/__/__");
            System.out.println("\nAnio invalido. El anio varia desde 2018 hasta 2030.");
            asteriscosDeEspera();
            refrescarConsola();
            System.out.println("\nFecha de vuelo:__/__/__");
            System.out.println("\nIngrese el anio: ");
            System.out.println("Ingrese '0' para cancelar la operacion"); 
            anio = scan.nextInt();
            
            if(anio==0)
            {
                menuPrincipal();
            }
        }
        refrescarConsola();

        System.out.println("\nFecha de vuelo:__/__/"+anio);
        System.out.println("\nIngrese el mes: ");
        System.out.println("Ingrese '0' para cancelar la operacion");
        mes = scan.nextInt();
        
        if(mes==0)
        {
            menuPrincipal();
        }

        while(mes<=0 || mes>=13)
        {
            refrescarConsola();
            System.out.println("\nFecha de vuelo:__/__/"+anio);
            System.out.println("\nEl mes solo puede variar del 1 al 12.");
            asteriscosDeEspera();
            refrescarConsola();
            System.out.println("\nFecha de vuelo:__/__/"+anio);
            System.out.println("\nIngrese el mes: ");
            System.out.println("Ingrese '0' para cancelar la operacion");
            mes = scan.nextInt();
            
            if(mes==0)
            {
                menuPrincipal();
            }
        }
        refrescarConsola();

        System.out.println("\nFecha de vuelo:__/"+mes+"/"+anio+"/");

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

        System.out.println("\nFecha de vuelo:__/"+mes+"/"+anio+"/");
        System.out.println("\nIngrese el dia: ");
        System.out.println("Ingrese '0' para cancelar la operacion");
        dia = scan.nextInt(); 
        
        if(dia==0)
        {
            menuPrincipal();
        }

        while(dia <=0 || dia>limiteDia)
        {
            refrescarConsola();
            System.out.println("\nFecha de vuelo:__/"+mes+"/"+anio+"/");
            System.out.println("\nEl dia puede variar de 1 a %d."+limiteDia);
            asteriscosDeEspera();
            refrescarConsola();
            System.out.println("\nFecha de vuelo:__/"+mes+"/"+anio+"/");
            System.out.println("\nIngrese el dia: ");
            System.out.println("Ingrese '0' para cancelar la operacion");
            
            dia = scan.nextInt();
            
            if(dia==0)
            {
                menuPrincipal();
            }
        }

        System.out.println("\nFecha valida de vuelo:"+dia+"/"+mes+"/"+anio+"/");

        fecha = dia+"/"+mes+"/"+anio+"/";
        
        return fecha;
    }
}
