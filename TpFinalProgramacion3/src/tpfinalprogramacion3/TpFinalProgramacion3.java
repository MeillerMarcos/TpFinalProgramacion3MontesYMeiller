package tpfinalprogramacion3;


import com.google.gson.reflect.TypeToken;
import java.awt.HeadlessException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TpFinalProgramacion3
{
    public static Scanner scan = new Scanner(System.in);
    public static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");
    public static Date date = new Date();
    private static ArrayList<Vuelo> vuelos = new ArrayList<Vuelo>();
    private static ArrayGenerico<Vuelo> listaVuelos = new ArrayGenerico<Vuelo>(vuelos);
    private static ArrayList<Vuelo> vuelosBorrados = new ArrayList<Vuelo>();
    private static ArrayGenerico<Vuelo> listaVuelosBorrados = new ArrayGenerico<Vuelo>(vuelosBorrados);
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
        int opcion=0;
        int i = 0;
        listaVuelos.setList(listaVuelos.leerArchivoGSon("vuelosGSON.json", new TypeToken<ArrayList<Vuelo>>(){}.getType()));
        listaUsuarios.setList(listaUsuarios.leerArchivoGSon("usuariosGSON.json",new TypeToken<ArrayList<Usuario>>(){}.getType()));

        refrescarConsola();
        System.out.println("------Menu principal------");
        System.out.println();
        System.out.println("1. Menu de usuarios");
        System.out.println("2. Contratar un nuevo vuelo");
        System.out.println("3. Listado de fechas de vuelos");
        System.out.println("4. Cancelar vuelo");
        System.out.println("5. Salir");
        System.out.println();
        System.out.print("Opción: ");
            
        try
        {
            
            opcion = scan.nextInt();
            
        }
        catch(Exception e)
        {
            mensajeOpcionInvalida();
            scan.nextLine();
            menuPrincipal(); 
        }
        
        if(opcion<1 || opcion>5)
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
                refrescarConsola();
                for(i=0;i<listaVuelos.getList().size();i++)
                {
                    if(listaVuelos.getList().get(i).getAvion().getTipoDeAvion().equals("Avion Gold"))
                    {
                        System.out.println(listaVuelos.getList().get(i).getFecha().toString()+": Avion Gold");
                    }
                    if(listaVuelos.getList().get(i).getAvion().getTipoDeAvion().equals("Avion Silver"))
                    {
                        System.out.println(listaVuelos.getList().get(i).getFecha().toString()+": Avion Silver");
                    }
                    if(listaVuelos.getList().get(i).getAvion().getTipoDeAvion().equals("Avion Bronze"))
                    {
                        System.out.println(listaVuelos.getList().get(i).getFecha().toString()+": Avion Bronze");
                    }
                }
                System.out.println();
                System.out.print("Ingrese una tecla para volver");
                puntosSuspensivos();
                scan.next();
                menuPrincipal();
                break;
            case 4:
                eliminarVuelo();
                break;
            case 5:
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

    public static String mostrarOpcionesOrigenYDestino (String mostrarVuelo, int origenOdestino)
    {
        int i = 0;
        ArrayList <String> lista = new ArrayList<String>();

        lista.add("BsAs");
        lista.add("Santiago");
        lista.add("Montevideo");
        lista.add("Cordoba");
        System.out.println();
        System.out.print("Opción: ");

        for(i=0; i<lista.size();i++)
        {
            if(lista.get(i).equals(mostrarVuelo))
            {
                lista.remove(i);
            }
        }
        System.out.println();

        if(origenOdestino==1)
        {
            System.out.println("Elija el origen: ");
        }

        if(origenOdestino==2)
        {
            System.out.println("Elija el destino: ");
        }

        for(i=0; i<lista.size();i++)
        {
            System.out.println(i +1 + ". "+ lista.get(i));
        }

        try
        {
            i = scan.nextInt();
        }
        catch(Exception e)
        {
            mensajeOpcionInvalida();
            scan.nextLine();
            menuPrincipal();
        }

        while(i<1 || i>lista.size())
        {
            mensajeOpcionInvalida();
            menuPrincipal();
        }

        if(lista.size()==4)
        {
            mostrarVuelo = lista.get(i-1);
        }
        else
        {
            mostrarVuelo += " – " + lista.get(i - 1);
        }

        return mostrarVuelo;
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
        Vuelo vuelo = new Vuelo();
        Usuario usuario = new Usuario();
        Fecha fechaElegida = new Fecha();
        String vueloElegido = new String();
        ArrayList<Avion> aviones = new ArrayList<Avion>();
        AvionGold avionGold = new AvionGold (200,300,5,1020,"Motor a reacción","Avion Gold");
        AvionSilver avionSilver = new AvionSilver (190,230,4,950,"Motor a hélice","Avion Silver");
        AvionBronze avionBronze = new AvionBronze (160,150,2,950,"Motor de pistones","Avion Bronze");
        int opcion=0;
        int cantidadElegida=0;
        int i=0;
        int buscarUsuario=0;
        String dni= new String();

        listaVuelos.setList(listaVuelos.leerArchivoGSon("vuelosGSON.json", new TypeToken<ArrayList<Vuelo>>(){}.getType()));

        if(aviones.isEmpty())
        {
            aviones.add(avionGold);
            aviones.add(avionSilver);
            aviones.add(avionSilver);
            aviones.add(avionBronze);
            aviones.add(avionBronze);
            aviones.add(avionBronze);
            aviones.add(avionBronze);
        }

        ArrayGenerico<Avion> listaDeAviones = new ArrayGenerico<Avion>(aviones);

        refrescarConsola();
        System.out.println("Ingrese '0' para cancelar la operacion.");
        System.out.print("Ingrese su DNI: ");
        dni = scan.next();

        if(dni.equals("0"))
        {
            menuPrincipal();
        }

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

        System.out.print("Fecha elegida del vuelo: "+fechaElegida.toString());
        puntosSuspensivos();

        refrescarConsola();
        System.out.println("Fecha de vuelo: "+fechaElegida.toString());
        System.out.println();
        vueloElegido = mostrarOpcionesOrigenYDestino(vueloElegido, 1);
        vueloElegido = mostrarOpcionesOrigenYDestino(vueloElegido, 2);
        vuelo.setOrigenDestino(vueloElegido);
        System.out.println();
        System.out.print("Usted ha elegido: '"+vueloElegido+"'");
        puntosSuspensivos();

        refrescarConsola();
        System.out.println("Fecha de vuelo: "+fechaElegida.toString());
        System.out.println();
        System.out.println("Eliga la cantidad de acompañantes: ");
        
        try
        {
            cantidadElegida = scan.nextInt();
        }
        catch(Exception e)
        {
            mensajeOpcionInvalida();
            scan.nextLine();
            menuPrincipal();
        }
        
        
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
        System.out.println("Fecha de vuelo: "+fechaElegida.toString());
        System.out.println();
        mostrarOpcionesTipoDeAvion();
        
        try
        {
            opcion = scan.nextInt();
        }
        catch(Exception e)
        {
            mensajeOpcionInvalida();
            scan.nextLine();
            menuPrincipal();
        }

        while(opcion<1 || opcion>3)
        {
            mensajeOpcionInvalida();
            refrescarConsola();
            System.out.println("Fecha de vuelo: "+fechaElegida.toString());
            System.out.println();
            mostrarOpcionesTipoDeAvion();
            
            try
            {
                opcion = scan.nextInt();
            }
            catch(Exception e)
            {
                mensajeOpcionInvalida();
                scan.nextLine();
                menuPrincipal();
            }
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
        
        vuelo.getAvion().setTipoDeAvion();
        
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
        
        try
        {
            opcion = scan.nextInt();
        }
        catch(Exception e)
        {
            mensajeOpcionInvalida();
            scan.nextLine();
            menuPrincipal();
        }

        if(opcion<1 || opcion>3)
        {
            mensajeOpcionInvalida();
            menuPrincipal();
        }
        
        switch(opcion)
        {
            case 1:
                listaVuelos.getList().add(vuelo);
                listaVuelos.escribirArchivoGSon("vuelosGSON.json", listaVuelos.getList());
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

    public static Fecha ingresarFecha ()
    {
        int limiteDia=0;
        Fecha fecha = new Fecha();

        System.out.println("\nFecha de vuelo:__/__/__");
        System.out.println("\nIngrese '0' para cancelar la operacion.");
        System.out.print("Ingrese el anio: ");
        fecha.setAnio(scan.nextInt());

        if(fecha.getAnio()==0)
        {
            menuPrincipal();
        }

        while((fecha.getAnio() < (date.getYear()+1900)) || (fecha.getAnio()>2050))
        {
            refrescarConsola();
            System.out.println("\nFecha de vuelo:__/__/__");
            System.out.println("\nAnio invalido. El anio debe variar entre "+(date.getYear()+1900)+" y 2050");
            puntosSuspensivos();
            refrescarConsola();
            System.out.println("\nFecha de vuelo:__/__/__");
            System.out.println("\nIngrese '0' para cancelar la operacion.");
            System.out.print("Ingrese el anio: ");
            fecha.setAnio(scan.nextInt());

            if(fecha.getAnio()==0)
            {
                menuPrincipal();
            }
        }
        refrescarConsola();

        System.out.println("\nFecha de vuelo:__/__/"+fecha.getAnio());
        System.out.println("\nIngrese '0' para cancelar la operacion.");
        System.out.print("Ingrese el mes: ");
        fecha.setMes(scan.nextInt());

        if(fecha.getMes()==0)
        {
            menuPrincipal();
        }

        while((fecha.getMes() < (date.getMonth()+1)) || (fecha.getMes()>12 && fecha.getMes()<1))
        {
            refrescarConsola();
            System.out.println("\nFecha de vuelo:__/__/"+fecha.getAnio());
            System.out.println("\nEl mes solo puede variar del "+(date.getMonth()+1)+" al 12.");
            puntosSuspensivos();
            refrescarConsola();
            System.out.println("\nFecha de vuelo:__/__/"+fecha.getAnio());
            System.out.println("\nIngrese '0' para cancelar la operacion.");
            System.out.print("Ingrese el mes: ");
            fecha.setMes(scan.nextInt());

            if(fecha.getMes()==0)
            {
                menuPrincipal();
            }
        }
        refrescarConsola();

        System.out.println("\nFecha de vuelo:__/"+fecha.getMes()+"/"+fecha.getAnio()+"/");

        if(fecha.getAnio()%4==0)
        {
            if(fecha.getMes()==2)
            {
                limiteDia=29;
            }
            else
            {
                if(fecha.getMes()==1 || fecha.getMes()==3 || fecha.getMes()==5 || fecha.getMes()==7 || fecha.getMes()==8 || fecha.getMes()==10 || fecha.getMes()==12)
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
            if(fecha.getMes()==2)
            {
                limiteDia=28;
            }
            else
            {
                if(fecha.getMes()==1 || fecha.getMes()==3 || fecha.getMes()==5 || fecha.getMes()==7 || fecha.getMes()==8 || fecha.getMes()==10 || fecha.getMes()==12)
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

        System.out.println("\nFecha de vuelo:__/"+fecha.getMes()+"/"+fecha.getAnio()+"/");
        System.out.println("\nIngrese '0' para cancelar la operacion.");
        System.out.print("Ingrese el dia: ");
        fecha.setDia(scan.nextInt());

        if(fecha.getDia()==0)
        {
            menuPrincipal();
        }

        if(fecha.getMes() == (date.getMonth()+1))  
        {
            while((fecha.getDia() < date.getDate()) || (fecha.getDia()<1))
            {
                refrescarConsola();
                System.out.println("\nFecha de vuelo:__/"+fecha.getMes()+"/"+fecha.getAnio()+"/");
                System.out.println("\nEl dia puede variar de "+date.getDate()+" a "+limiteDia+".");
                puntosSuspensivos();
                refrescarConsola();
                System.out.println("\nFecha de vuelo:__/"+fecha.getMes()+"/"+fecha.getAnio()+"/");
                System.out.println("\nIngrese '0' para cancelar la operacion.");
                System.out.print("Ingrese el dia: ");
                fecha.setDia(scan.nextInt());

                if(fecha.getDia()==0)
                {
                    menuPrincipal();
                }
            }
        }
        else
        {
            while((fecha.getDia()<1) || (fecha.getDia()>limiteDia))
            {
                refrescarConsola();
                System.out.println("\nFecha de vuelo:__/"+fecha.getMes()+"/"+fecha.getAnio()+"/");
                System.out.println("\nEl dia puede variar de 1 a "+limiteDia+".");
                puntosSuspensivos();
                refrescarConsola();
                System.out.println("\nFecha de vuelo:__/"+fecha.getMes()+"/"+fecha.getAnio()+"/");
                System.out.println("\nIngrese '0' para cancelar la operacion.");
                System.out.print("Ingrese el dia: ");
                fecha.setDia(scan.nextInt());

                if(fecha.getDia()==0)
                {
                    menuPrincipal();
                }
            }
        }
        
        return fecha;
    }

    public static void menuUsuarios ()
    {
        Usuario usuario = new Usuario();
        int opcion=0;
        int i=0;
        int buscarUsuario=0;
        int dni=0;

        listaUsuarios.setList(listaUsuarios.leerArchivoGSon("usuariosGSON.json",new TypeToken<ArrayList<Usuario>>(){}.getType()));
        refrescarConsola();
        System.out.println("------Menu de usuarios------");
        System.out.println();
        System.out.println("1. Registrar usuario");
        System.out.println("2. Listado de usuarios");
        System.out.println("3. Volver");
        System.out.println();
        System.out.print("Opción: ");
        
        try
        {
            opcion = scan.nextInt();
        }
        catch(Exception e)
        {
            mensajeOpcionInvalida();
            scan.nextLine();
            menuUsuarios();
        }
        
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
                
                try
                {
                    usuario.setEdad(scan.nextInt());
                }
                catch(Exception e)
                {
                    mensajeOpcionInvalida();
                    scan.nextLine();
                    menuUsuarios();
                }
                listaUsuarios.getList().add(usuario);
                listaUsuarios.escribirArchivoGSon("usuariosGSON.json", listaUsuarios.getList());

                System.out.println();
                System.out.print("Usuario cargado con exito");
                puntosSuspensivos();
                menuUsuarios();
                break;
            case 2:
                refrescarConsola();

                if(!listaUsuarios.getList().isEmpty())
                {
                    for(i=0;i<listaUsuarios.getList().size();i++)
                    {
                        System.out.println("-------------"+(i+1)+"-------------");
                        System.out.println("Nombre: "+listaUsuarios.getList().get(i).getNombre());
                        System.out.println("Apellido: "+listaUsuarios.getList().get(i).getApellido());
                        System.out.println("Edad: "+listaUsuarios.getList().get(i).getEdad());
                        System.out.println("Dni: "+listaUsuarios.getList().get(i).getDni());
                        if(!listaVuelos.getList().isEmpty())
                        {

                            System.out.println("Avion mas utilizado: "+listaUsuarios.getList().get(i).avionMasUtilizado(listaVuelos,listaUsuarios.getList().get(i).getDni()));

                            System.out.println("Costo total de todos los vuelos: " + listaUsuarios.getList().get(i).costoTotalDeVuelos(listaVuelos,listaUsuarios.getList().get(i).getDni()));
                        }
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

    public static void eliminarVuelo ()
    {
        Scanner scan = new Scanner(System.in);
        String dni = new String();
        ArrayList<Integer> posicion = new ArrayList<Integer>();
        int buscarUsuario=0;
        int i = 0;
        Usuario usuario = new Usuario();
        Vuelo vuelo = new Vuelo();
        int diaIngresado=0;
        int mesIngresado=0;
        int anioIngresado=0;
        int diaActual=0;
        int mesActual=0;
        int anioActual=0;
        int opcion=0;
        
        listaVuelos.setList(listaVuelos.leerArchivoGSon("vuelosGSON.json", new TypeToken<ArrayList<Vuelo>>(){}.getType()));
        listaUsuarios.setList(listaUsuarios.leerArchivoGSon("usuariosGSON.json", new TypeToken<ArrayList<Usuario>>(){}.getType()));
        
        System.out.print("Ingrese su DNI: ");
        dni = scan.next();
        buscarUsuario=usuario.buscarDni(listaUsuarios.getList(), dni);

        if(buscarUsuario==-1)
        {
            System.out.println();
            System.out.print("Usuario no encontrado");
            puntosSuspensivos();
            menuPrincipal();
        }
        usuario.setDni(dni);
        
        for(i=0;i<listaVuelos.getList().size();i++)
        {
            if(listaVuelos.getList().get(i).getUsuario().getDni().equals(usuario.getDni()))
            {
                posicion.add(i);
            }
        }
        System.out.println("Eliga cual desea eliminar: ");
        System.out.println();
        
        for(i = 0; i<posicion.size(); i++)
        {
            System.out.println("Opcion: " + (i+1) + " " + listaVuelos.getList().get(posicion.get(i)).getFecha());
        }
        
        try
        { 
            i = scan.nextInt();
            i--;
        }
        catch(Exception e)
        {
            mensajeOpcionInvalida();
            scan.nextLine();
            menuPrincipal(); 
        }
        
        if(i<0 || i>posicion.size())
        {
            mensajeOpcionInvalida();
            menuPrincipal();
        }
        
        diaIngresado=listaVuelos.getList().get(posicion.get(i)).getFecha().getDia();
        mesIngresado=listaVuelos.getList().get(posicion.get(i)).getFecha().getMes();
        anioIngresado=listaVuelos.getList().get(posicion.get(i)).getFecha().getAnio();
        diaActual=date.getDate();
        mesActual=date.getMonth()+1;
        anioActual=date.getYear()+1900;
        
        if((mesIngresado > mesActual) && (anioIngresado >= anioActual))
        {
            if(diaIngresado == diaActual)
            {
                System.out.println();
                System.out.print("Debe eliminar un vuelo con al menos un dia de anticipación");
            }
            else
            {
                System.out.println("¿Esta seguro que desea eliminar el vuelo?: ");
                System.out.println("1. Si");
                System.out.println("2. No");
                
                try
                { 
                    opcion = scan.nextInt();
                }
                catch(Exception e)
                {
                    mensajeOpcionInvalida();
                    scan.nextLine();
                    menuPrincipal(); 
                }
                
                if(opcion<1 && opcion>2)
                {
                    mensajeOpcionInvalida();
                    menuPrincipal();
                }
                
                if(opcion==1)
                {
                    listaVuelosBorrados.getList().add((listaVuelos.getList().get(posicion.get(i))));
                    listaVuelos.quitarElementoDeArray(listaVuelos,listaVuelos.getList().get(posicion.get(i)));
                    listaVuelos.escribirArchivoGSon("vuelosGSON.json", listaVuelos.getList());
                    listaVuelosBorrados.escribirArchivoGSon("vuelosBorradosGSON.json", listaVuelosBorrados.getList());
                    System.out.println();
                    System.out.print("Vuelo eliminado satisfactoriamente");  
                }
            } 
        }
        if((anioIngresado == anioActual) && (mesIngresado == mesActual) && (diaIngresado == diaActual))
        {
            System.out.println();
            System.out.print("Debe eliminar un vuelo con al menos un dia de anticipación");
        }
        puntosSuspensivos();
        menuPrincipal();
    }
}
