package tpfinalprogramacion3;

import java.util.ArrayList;
import java.util.Scanner;

public class TpFinalProgramacion3 
{
    private static ArrayList<Vuelo> vuelos = new ArrayList<Vuelo>();
    private static ArrayGenerico<Vuelo> listaVuelos = new ArrayGenerico<Vuelo>(vuelos);
    private static ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
    private static ArrayGenerico<Usuario> listaUsuarios = new ArrayGenerico<Usuario>(usuarios);
    
    public static void main(String[] args) 
    {
        menuPrincipal();
    } 
    
    public static void refrescarConsola ()
    {
        for (int i=0;i<20;i++) 
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
    
    public static void puntosSuspensivos ()
    {
        sleepMs(350);
        System.out.print(".");
        sleepMs(350);
        System.out.print(" .");
        sleepMs(350);
        System.out.print(" .");
        sleepMs(700);
    }
    
    public static void mensajeOpcionInvalida () 
    {
        System.out.print("Opcion inválida. Ingrese nuevamente");
        puntosSuspensivos();
    }

    public static void menuPrincipal ()
    {
        Scanner scan = new Scanner(System.in);
        int opcion=0;
        int i = 0;
        
        refrescarConsola();
        System.out.println("------Menu principal------");
        System.out.println();
        System.out.println("1. Menu de usuarios");
        System.out.println("2. Contratar un nuevo vuelo");
        System.out.println("3. Listado de fechas de vuelos");
        System.out.println("4. Salir");
        System.out.println();
        System.out.print("Opción: ");
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
                cargarVuelo();
                break;
            case 3:
                listaVuelos.setList(listaVuelos.leerArchivo("vuelos.txt"));
                refrescarConsola();
                
                for(i=0;i<listaVuelos.getList().size();i++)
                {
                    if(listaVuelos.getList().get(i).getAvion() instanceof AvionGold)
                    {
                      System.out.println(listaVuelos.getList().get(i).getFecha()+": Avion Gold");  
                    }
                    if(listaVuelos.getList().get(i).getAvion() instanceof AvionSilver)
                    {
                      System.out.println(listaVuelos.getList().get(i).getFecha()+": Avion Silver");  
                    }
                    if(listaVuelos.getList().get(i).getAvion() instanceof AvionBronze)
                    {
                      System.out.println(listaVuelos.getList().get(i).getFecha()+": Avion Bronze");  
                    }
                    
                }
                System.out.println();
                System.out.print("Ingrese una tecla para volver");
                puntosSuspensivos();
                scan.next();
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
    
    public static void mostrarOpcionesTipoDeAvion ()
    {
        System.out.println("Eliga en que tipo de avion desea viajar: ");
        System.out.println("1.Gold");
        System.out.println("2.Silver");
        System.out.println("3.Bronze");
        System.out.println();
        System.out.print("Opción: ");
    }
    
    public static void cargarVuelo ()
    {
        Scanner scan = new Scanner(System.in);
        Vuelo vuelo = new Vuelo();
        Usuario usuario = new Usuario();
        String fechaElegida = new String();
        String vueloElegido = new String();
        ArrayList <Avion> aviones = new ArrayList<Avion>();
        AvionGold avionGold = new AvionGold (200,300,5,1020,"Motor a reacción");
        AvionSilver avionSilver = new AvionSilver (190,230,4,950,"Motor a hélice");
        AvionSilver avionSilver2 = new AvionSilver (190,230,4,950,"Motor a hélice");
        AvionBronze avionBronze = new AvionBronze (160,150,2,950,"Motor de pistones");
        AvionBronze avionBronze2 = new AvionBronze (160,150,2,950,"Motor de pistones");
        AvionBronze avionBronze3 = new AvionBronze (160,150,2,950,"Motor de pistones");
        AvionBronze avionBronze4 = new AvionBronze (160,150,2,950,"Motor de pistones");
        int opcion=0;
        int cantidadElegida=0;
        int i=0;
        int buscarUsuario=0;
        String dni= new String();
        
        if(aviones.isEmpty())
        {
            aviones.add(avionGold);
            aviones.add(avionSilver);
            aviones.add(avionSilver2);
            aviones.add(avionBronze);
            aviones.add(avionBronze2);
            aviones.add(avionBronze3);
            aviones.add(avionBronze4);
        }
        
        ArrayGenerico<Avion> listaDeAviones = new ArrayGenerico<Avion>(aviones);
        
        refrescarConsola();
        System.out.print("Ingrese su DNI: ");
        dni = scan.next();
        buscarUsuario=usuario.buscarDni(listaUsuarios.getList(), dni);
        
        if(buscarUsuario==-1)
        {
            System.out.println();
            System.out.print("Usuario no encontrado");
            puntosSuspensivos();
            cargarVuelo();
        }
        usuario.setDni(dni);
        vuelo.setUsuario(listaUsuarios.getList().get(buscarUsuario));

        fechaElegida = ingresarFecha();
        vuelo.setFecha(fechaElegida);   
        System.out.print("Fecha elegida del vuelo: "+fechaElegida);
        puntosSuspensivos();
        
        refrescarConsola();
        System.out.println("Fecha de vuelo: "+fechaElegida);
        System.out.println();
        mostrarOpcionesOrigenYDestino(); 
        System.out.println();
        System.out.print("Opción: ");
        opcion = scan.nextInt();
        
        while(opcion<1 || opcion>6)
        {
            mensajeOpcionInvalida();
            refrescarConsola();
            mostrarOpcionesOrigenYDestino(); 
            System.out.println();
            System.out.print("Opción: ");
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
        puntosSuspensivos();
        
        refrescarConsola();
        System.out.println("Fecha de vuelo: "+fechaElegida);
        System.out.println();
        System.out.println("Eliga la cantidad de acompañantes: ");
        cantidadElegida = scan.nextInt();
        vuelo.setCantidadAcompañantes(cantidadElegida);
        System.out.println();
        
        if(cantidadElegida==0)
        {
            System.out.print("Usted viaja solo");
        }
        if(cantidadElegida>1)
        {
            System.out.print("Usted viaja con "+cantidadElegida+" personas");
        }
        if(cantidadElegida==1)
        {
            System.out.print("Usted viaja con una persona");
        }
        puntosSuspensivos();
        
        refrescarConsola();
        System.out.println("Fecha de vuelo: "+fechaElegida);
        System.out.println();
        mostrarOpcionesTipoDeAvion();
        opcion = scan.nextInt();
        
        while(opcion<1 || opcion>3)
        {
            mensajeOpcionInvalida();
            refrescarConsola();
            System.out.println("Fecha de vuelo: "+fechaElegida);
            System.out.println();
            mostrarOpcionesTipoDeAvion();
            opcion = scan.nextInt();
            System.out.println();
            System.out.print("Opción: ");
            opcion = scan.nextInt();
        }
        
        switch(opcion)
        {
            case 1:
                while(i!= -1 && i < listaDeAviones.getList().size())
                {
                    if(listaDeAviones.getList().get(i) instanceof AvionGold)
                    {
                        vuelo.setAvion(listaDeAviones.getList().get(i));
                        listaDeAviones.eliminar(i);
                        i = -1;
                    }
                    else
                    {
                        i++;
                    }
                }
                break;
            case 2:
                while(i!= -1 && i < listaDeAviones.getList().size())
                {
                    if(listaDeAviones.getList().get(i) instanceof AvionSilver)
                    {
                        vuelo.setAvion(listaDeAviones.getList().get(i));
                        listaDeAviones.eliminar(i);
                        i = -1;
                    }
                    else
                    {
                      i++;  
                    }      
                } 
                break;
            case 3:
                while(i!= -1 && i < listaDeAviones.getList().size())
                {
                    if(listaDeAviones.getList().get(i) instanceof AvionBronze)
                    {
                        vuelo.setAvion(listaDeAviones.getList().get(i));
                        listaDeAviones.eliminar(i);
                        i = -1;
                    }
                    else
                    {
                        i++;
                    }
                }
                break;
        }
         
        while(!vuelo.comprobarPasajeros())
        {
            System.out.println();
            
            if(vuelo.getAvion() instanceof AvionGold)
            {
                System.out.print("El avion Gold no dispone la cantidad de pasajeros elegida. Ingrese una tecla para continuar");
            }
            if(vuelo.getAvion() instanceof AvionSilver)
            {
                System.out.print("El avion Silver no dispone la cantidad de pasajeros elegida. Ingrese una tecla para continuar");
            }
            if(vuelo.getAvion() instanceof AvionBronze)
            {
                System.out.print("El avion Bronze no dispone la cantidad de pasajeros elegida. Ingrese una tecla para continuar");
            }
            puntosSuspensivos();
            scan.next();
            menuPrincipal();
        }
            
        if(i>listaDeAviones.getList().size())
        {
            System.out.println();
            
            if(vuelo.getAvion() instanceof AvionGold)
            {
                System.out.print("No tenemos aviones Gold disponibles actualmente. Ingrese una tecla para continuar");
            }
            if(vuelo.getAvion() instanceof AvionSilver)
            {
                System.out.print("No tenemos aviones Silver disponibles actualmente. Ingrese una tecla para continuar");
            }
            if(vuelo.getAvion() instanceof AvionBronze)
            {
                System.out.print("No tenemos aviones Bronze disponibles actualmente. Ingrese una tecla para continuar");
            }
            puntosSuspensivos();
            scan.next();
            menuPrincipal();
        }
  
        if(!listaVuelos.getList().isEmpty())
        {
            for(i=0;i<listaVuelos.getList().size();i++)
            {
                if(vuelo.getAvion()==listaVuelos.getList().get(i).getAvion())
                {
                    System.out.println("es true.");
                }
                System.out.println("i: "+i);
                System.out.println("vueloGetAvion: "+vuelo.getAvion());
                System.out.println("listaVuelosGetAvion: "+listaVuelos.getList().get(i).getAvion());
                
                if(listaVuelos.getList().get(i).controlarFecha(fechaElegida) 
                && listaVuelos.getList().get(i).controlarTipoDeAvion(vuelo.getAvion(), listaVuelos.getList().get(i).getAvion()))
                {  
                    System.out.println();
                    System.out.print("El avion no esta disponible para esa fecha. Ingrese una tecla para continuar");
                    puntosSuspensivos();
                    scan.next();
                    menuPrincipal();
                }
            } 
        }
        
        vuelo.calcularTotal(vueloElegido);
        refrescarConsola();
        System.out.println("El costo total de su vuelo es de $"+vuelo.getCostoTotal()+".");
        System.out.println("¿Confirmar vuelo?.");
        System.out.println("1. Si");
        System.out.println("2. No");
        System.out.println();
        System.out.print("Opción: ");
        opcion = scan.nextInt(); 
        
        switch(opcion)
        {
            case 1:
                listaVuelos.getList().add(vuelo);
                listaVuelos.escribirArchivo("vuelos.txt", listaVuelos.getList());
                System.out.println();
                System.out.print("Vuelo confirmado");
                puntosSuspensivos();
                menuPrincipal();
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
        int opcion=0;
        int i=0;
        int buscarUsuario=0;
        int dni=0;
        
        usuario.setListaUsuario(usuario.leerArchivo("usuarios.txt"));
        
        refrescarConsola();
        System.out.println("------Menu de usuarios------");
        System.out.println();
        System.out.println("1. Registrar usuario");
        System.out.println("2. Listado de usuarios");
        System.out.println("3. Volver");
        System.out.println();
        System.out.print("Opción: ");
        opcion = scan.nextInt();
        
        if(opcion<1 || opcion>3)
        {
            mensajeOpcionInvalida();
            menuUsuarios();
        }
        
        switch(opcion)
        {
            case 1:
                refrescarConsola();
                
                
                
                System.out.println();
                System.out.print("Ingrese su DNI: ");
                usuario.setDni(scan.next());
                buscarUsuario=usuario.buscarDni(listaUsuarios.getList(), usuario.getDni());
                
                if(buscarUsuario!=-1)
                {
                    System.out.print("El dni ya existe. Ingrese nuevamente");
                    puntosSuspensivos();
                    menuUsuarios();
                }
                System.out.println();
                System.out.print("Ingrese su nombre: ");
                usuario.setNombre(scan.next());
                System.out.println();
                System.out.print("Ingrese su apellido: ");
                usuario.setApellido(scan.next());
                System.out.println();
                System.out.print("Ingrese su edad: ");
                usuario.setEdad(scan.nextInt());
                usuario.getListaUsuario().add(usuario);
                listaUsuarios.agregarAlista(usuario);
                listaUsuarios.escribirArchivo("usuarios.txt", usuario.getListaUsuario());
                System.out.println();
                System.out.print("Usuario cargado con exito");
                puntosSuspensivos();
                menuUsuarios();
                break;
            case 2:
                refrescarConsola();
                listaUsuarios.setList(listaUsuarios.leerArchivo("usuarios.txt"));
                
                if(!usuario.getListaUsuario().isEmpty())
                {
                    for(i=0;i<usuario.getListaUsuario().size();i++)
                    {
                        System.out.println("-------------"+(i+1)+"-------------");
                        System.out.println("Nombre: "+listaUsuarios.getList().get(i).getNombre());
                        System.out.println("Apellido: "+listaUsuarios.getList().get(i).getApellido());
                        System.out.println("Edad: "+listaUsuarios.getList().get(i).getEdad());
                        System.out.println("Dni: "+listaUsuarios.getList().get(i).getDni());
                        System.out.println("Avion mas utilizado: "+listaUsuarios.getList().get(i).avionMasUtilizado(listaVuelos));
                        System.out.println("Costo total de todos los vuelos: ");
                        System.out.println("---------------------------");
                    } 
                }
                else
                {
                    System.out.print("La lista de usuarios está vacía.");
                }
                
                System.out.println();
                System.out.print("Ingrese una tecla para continuar");
                puntosSuspensivos();
                scan.next();
                menuUsuarios();
                break;
            case 3:
                menuPrincipal();
                break;
        }
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
            cargarVuelo();
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
                cargarVuelo();
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
            cargarVuelo();
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
                cargarVuelo();
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
        System.out.println("\nIngrese '0' para cancelar la operacion.");
        System.out.print("Ingrese el anio: ");
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
            puntosSuspensivos();
            refrescarConsola();
            System.out.println("\nFecha de vuelo:__/__/__");
            System.out.println("\nIngrese '0' para cancelar la operacion.");
            System.out.print("Ingrese el anio: ");
            anio = scan.nextInt();
            
            if(anio==0)
            {
                menuPrincipal();
            }
        }
        refrescarConsola();

        System.out.println("\nFecha de vuelo:__/__/"+anio);
        System.out.println("\nIngrese '0' para cancelar la operacion.");
        System.out.print("Ingrese el mes: ");
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
            puntosSuspensivos();
            refrescarConsola();
            System.out.println("\nFecha de vuelo:__/__/"+anio);
            System.out.println("\nIngrese '0' para cancelar la operacion.");
            System.out.print("Ingrese el mes: ");
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
        System.out.println("\nIngrese '0' para cancelar la operacion.");
        System.out.print("Ingrese el dia: ");
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
            puntosSuspensivos();
            refrescarConsola();
            System.out.println("\nFecha de vuelo:__/"+mes+"/"+anio+"/");
            System.out.println("\nIngrese '0' para cancelar la operacion.");
            System.out.print("Ingrese el dia: ");
            dia = scan.nextInt();
            
            if(dia==0)
            {
                menuPrincipal();
            }
        }

        fecha = dia+"/"+mes+"/"+anio;
        
        return fecha;
    }
}
