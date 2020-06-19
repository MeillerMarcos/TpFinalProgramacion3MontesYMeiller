package tpfinalprogramacion3;

import java.util.ArrayList;
import java.util.Scanner;

public class TpFinalProgramacion3 
{
    private static ArrayList <Vuelo> vuelos = new ArrayList<Vuelo>();
    private static ArrayGenerico<Vuelo> listaVuelos = new ArrayGenerico<Vuelo>(vuelos);
    
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
        System.out.print(".");
        sleepMs(350);
        System.out.print("  .");
        sleepMs(350);
        System.out.print("    .");
        sleepMs(700);
    }
    
    public static void mensajeOpcionInvalida () 
    {
        System.out.println("Opcion inválida. Ingrese nuevamente");
        asteriscosDeEspera();
    }

    public static void menuPrincipal ()
    {
        listaVuelos.setList(listaVuelos.leerArchivo("vuelos.txt"));
        int opcion=0;
        int i = 0;
        Scanner scan = new Scanner(System.in);
        Avion avion;
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
                for(i=0;i<listaVuelos.getList().size();i++)
                {
                    System.out.println(listaVuelos.getList().get(i).getFecha() + ":" + listaVuelos.getList().get(i).getAvion());
                }
                System.out.println("presione para continuar...");
                scan.next();
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
        listaVuelos.setList(listaVuelos.leerArchivo("vuelos.txt"));
        Scanner scan = new Scanner(System.in);
        Vuelo vuelo = new Vuelo();
        int opcion=0;
        int cantidadElegida=0;
        int i = 0;
        String fechaElegida = new String();
        String vueloElegido = new String();
        AvionGold avionGold = new AvionGold (300,50,1020,"Gold");
        AvionGold avionGold2 = new AvionGold (300,50,1020,"Gold");
        AvionSilver avionSilver = new AvionSilver (230,40,950,"Silver");
        AvionBronze avionBronze = new AvionBronze (150,30,950,"Bronze");
        AvionBronze avionBronze2 = new AvionBronze (150,30,950,"Bronze");
        AvionBronze avionBronze3 = new AvionBronze (150,30,950,"Bronze");
        ArrayList <Avion> aviones = new ArrayList<Avion>();
        ArrayGenerico<Avion> listaDeAviones = new ArrayGenerico<Avion>(aviones);
        aviones.add(avionGold);
        aviones.add(avionGold2);
        aviones.add(avionSilver);
        aviones.add(avionBronze);
        aviones.add(avionBronze2);
        aviones.add(avionBronze3);
        
        refrescarConsola();
        System.out.println("Ingrese la fecha del vuelo: ");
        fechaElegida = ingresarFecha();
        vuelo.setFecha(fechaElegida);
        System.out.print("Fecha elegida del vuelo: "+fechaElegida+".");
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
        vuelo.setOrigenDestino(vueloElegido);
        System.out.println();
        System.out.print("Usted ha elegido: '"+vueloElegido+"'");
        asteriscosDeEspera();
        
        
        refrescarConsola();
        System.out.println("Eliga la cantidad de acompañantes: ");
        cantidadElegida = scan.nextInt();
        vuelo.setCantidadAcompañantes(cantidadElegida);
        System.out.println();
        
        if(cantidadElegida==0)
        {
            System.out.print("Usted viaja solo.");
        }
        if(cantidadElegida>1)
        {
            System.out.print("Usted viaja con "+cantidadElegida+" personas.");
        }
        if(cantidadElegida==1)
        {
            System.out.print("Usted viaja con una persona.");
        }
        asteriscosDeEspera();
        
        refrescarConsola();
        
        
        
        System.out.println("Eliga en que tipo de avion desea viajar: ");
        System.out.println("1.Gold");
        System.out.println("2.Silver");
        System.out.println("3.Bronze");
        opcion = scan.nextInt();
   
        switch(opcion)
        {
            case 1:
               while(i!= -1 && i < listaDeAviones.getList().size())
               {
               if(listaDeAviones.getList().get(i) instanceof AvionGold){
                   vuelo.setAvion(listaDeAviones.getList().get(i));
                   listaDeAviones.eliminar(i);
                   i = -1;
               }
               else
                   i++;
               }
                break;
            case 2:
               while(i!= -1 && i < listaDeAviones.getList().size())
              {
               if(listaDeAviones.getList().get(i) instanceof AvionSilver){
                   vuelo.setAvion(listaDeAviones.getList().get(i));
                   listaDeAviones.eliminar(i);
                   i = -1;
               }
               else
                   i++;
               } 
                break;
            case 3:
               while(i!= -1 && i < listaDeAviones.getList().size())
               {
               if(listaDeAviones.getList().get(i) instanceof AvionBronze){
                   vuelo.setAvion(listaDeAviones.getList().get(i));
                   listaDeAviones.eliminar(i);
                   i = -1;
               }
               else
                   i++;
                break;
               }
       }
        if(i > listaDeAviones.getList().size())
            System.out.println("no tenemos ese tipo de avion disponible actualmente");
        
        vuelo.controlarFecha(vuelo.getAvion(), fechaElegida);
            
        
        
        while(!vuelo.comprobarPasajeros())
        {
            System.out.println();
            System.out.println("No tenemos aviones disponibles con esa capacidad de pasajeros.");
            //System.out.print("El avion "+vuelo.getAvion()+"no dispone la cantidad de pasajeros elegida. Ingrese nuevamente");
            asteriscosDeEspera();
            refrescarConsola();
            System.out.println("Eliga en que tipo de avion desea viajar: ");
            System.out.println("1.Gold");
            System.out.println("2.Silver");
            System.out.println("3.Bronze");
            opcion = scan.nextInt();

            switch(opcion)
            {
                case 1:
                    vuelo.setAvion(avionGold);
                    break;
                case 2:
                    vuelo.setAvion(avionSilver);
                    break;
                case 3:
                    vuelo.setAvion(avionBronze);
                    break;
            }
        }
        
        
        
        vuelo.calcularTotal(vueloElegido);
        refrescarConsola();
        System.out.println("El costo total de su vuelo es de $"+vuelo.getCostoTotal()+".");
        System.out.println("¿Confirmar vuelo?.");
        System.out.println("1. Si");
        System.out.println("2. No");
        opcion = scan.nextInt(); 
        listaVuelos.getList().add(vuelo);
        listaVuelos.escribirArchivo("vuelos.txt",listaVuelos.getList());
        switch(opcion)
        {
            case 1:
                vuelo.escribirArchivo("vuelo.txt", vuelo);
                break;
            case 2:
                menuPrincipal();
                break;
        }
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
        int i = 0;
        usuario.setListaUsuario(usuario.leerArchivo("usuarios.txt"));
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
                usuario.setNombre(scan.next());
                System.out.println("Ingrese su apellido: ");
                usuario.setApellido(scan.next());
                System.out.println("Ingrese su DNI: ");
                usuario.setDni(scan.next());
                System.out.println("Ingrese su edad: ");
                usuario.setEdad(scan.nextInt());
                usuario.getListaUsuario().add(usuario);
                usuario.escribirArchivo("usuarios.txt", usuario.getListaUsuario());         
                break;
            case 2:
                refrescarConsola();
                usuario.setListaUsuario(usuario.leerArchivo("usuarios.txt"));
                for(i=0;i<usuario.getListaUsuario().size();i++){
                    System.out.println(usuario.getListaUsuario().get(i).toString());
                }
                System.out.println("presione para continuar...");
                scan.next();
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
            System.out.println("\n\nIngrese el mes del 1 aFFFFFFl 12: ");
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
        System.out.println("Ingrese '0' para cancelar la operacion.");
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
            System.out.println("Ingrese '0' para cancelar la operacion."); 
            anio = scan.nextInt();
            
            if(anio==0)
            {
                menuPrincipal();
            }
        }
        refrescarConsola();

        System.out.println("\nFecha de vuelo:__/__/"+anio);
        System.out.println("\nIngrese el mes: ");
        System.out.println("Ingrese '0' para cancelar la operacion.");
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
            System.out.println("Ingrese '0' para cancelar la operacion.");
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
        System.out.println("Ingrese '0' para cancelar la operacion.");
        dia = scan.nextInt(); 
        
        if(dia==0)
        {
            menuPrincipal();
        }

        while(dia <=0 || dia>limiteDia)
        {
            refrescarConsola();
            System.out.println("\nFecha de vuelo:__/"+mes+"/"+anio+"/");
            System.out.println("\nEl dia puede variar de 1 a "+limiteDia+".");
            asteriscosDeEspera();
            refrescarConsola();
            System.out.println("\nFecha de vuelo:__/"+mes+"/"+anio+"/");
            System.out.println("\nIngrese el dia: ");
            System.out.println("Ingrese '0' para cancelar la operacion.");
            
            dia = scan.nextInt();
            
            if(dia==0)
            {
                menuPrincipal();
            }
        }

        fecha = dia+"/"+mes+"/"+anio+"/";
        
        return fecha;
    }
}
