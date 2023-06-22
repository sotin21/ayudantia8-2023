import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Agencia {
    private List<Persona> personas;

    public Agencia() {
        this.personas = new ArrayList<>();
    }

    public void agregarPersona(Persona persona) {
        personas.add(persona);
        System.out.println("Persona agregada correctamente.");
    }

    public void buscarPorIdentificacion(String identificacion) {
        boolean encontrado = false;
        for (Persona persona : personas) {
            if (persona.getIdentificacion().equals(identificacion)) {
                persona.mostrarInformacion();
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("No se encontro ninguna persona con la identificacion proporcionada.");
        }
    }

    public void ejecutarPrograma() {
        System.out.println("Bienvenido a la Agencia");

        iniciarConsola();
    }

    public void iniciarConsola() {
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;

        while (opcion != 7) {
            System.out.println("----- MENU -----");
            System.out.println("1. Agregar Agente");
            System.out.println("2. Buscar Agente por Identificacion");
            System.out.println("3. Eliminar Agente por Identificacion");
            System.out.println("4. Agregar Cliente");
            System.out.println("5. Buscar Cliente por Identificacion");
            System.out.println("6. Generar Venta");
            System.out.println("7. Salir");
            System.out.print("Ingrese la opcion deseada: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    agregarAgente();
                    break;
                case 2:
                    buscarAgentePorIdentificacion();
                    break;
                case 3:
                    eliminarAgentePorIdentificacion();
                    break;
                case 4:
                    agregarCliente();
                    break;
                case 5:
                    buscarClientePorIdentificacion();
                    break;
                case 6:
                    generarVenta();
                    break;
                case 7:
                    System.out.println("Hasta luego!");
                    break;
                default:
                    System.out.println("Opcion invalida. Intente nuevamente.");
                    break;
            }
        }

        scanner.close();
    }

    public void agregarAgente() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el nombre del agente: ");
        String nombre = scanner.nextLine();

        System.out.println("Ingrese el apellido del agente: ");
        String apellido = scanner.nextLine();

        System.out.println("Ingrese la identificacion del agente: ");
        String identificacion = scanner.nextLine();

        Agente agente = new Agente(nombre, apellido, identificacion);
        agregarPersona(agente);
    }

    public void buscarAgentePorIdentificacion() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese la identificacion del agente a buscar: ");
        String identificacion = scanner.nextLine();

        buscarPorIdentificacion(identificacion);
    }

    public void eliminarAgentePorIdentificacion() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese la identificacion del agente a eliminar: ");
        String identificacion = scanner.nextLine();

        boolean encontrado = false;
        for (Persona persona : personas) {
            if (persona instanceof Agente && persona.getIdentificacion().equals(identificacion)) {
                personas.remove(persona);
                encontrado = true;
                System.out.println("Agente eliminado correctamente.");
                break;
            }
        }

        if (!encontrado) {
            System.out.println("No se encontro ningun agente con esa identificacion.");
        }
    }

    public void agregarCliente() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el nombre del cliente: ");
        String nombre = scanner.nextLine();

        System.out.println("Ingrese el apellido del cliente: ");
        String apellido = scanner.nextLine();

        System.out.println("Ingrese la identificacion del cliente: ");
        String identificacion = scanner.nextLine();

        System.out.println("Ingrese el origen del cliente: ");
        String origenCliente = scanner.nextLine();

        System.out.println("Ingrese el destino del cliente: ");
        String destinoCliente = scanner.nextLine();

        Cliente cliente = new Cliente(nombre, apellido, identificacion, origenCliente, destinoCliente);
        agregarPersona(cliente);
    }

    public void buscarClientePorIdentificacion() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese la identificacion del cliente a buscar: ");
        String identificacion = scanner.nextLine();

        buscarPorIdentificacion(identificacion);
    }

    public void generarVenta() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese la identificacion del cliente: ");
        String identificacionCliente = scanner.nextLine();

        Cliente clienteEncontrado = null;
        for (Persona persona : personas) {
            if (persona instanceof Cliente && persona.getIdentificacion().equals(identificacionCliente)) {
                clienteEncontrado = (Cliente) persona;
                break;
            }
        }

        if (clienteEncontrado != null) {
            System.out.println("Identificacion: " + clienteEncontrado.getIdentificacion());
            System.out.println("Origen del Cliente: " + clienteEncontrado.getOrigenCliente());
            System.out.println("Destino del Cliente: " + clienteEncontrado.getDestinoCliente());
            System.out.println("Pasaje de avion vendido correctamente!");
        } else {
            System.out.println("No se encontro ningun cliente con esa identificacion.");
        }
    }

    public static void main(String[] args) {
        Agencia agencia = new Agencia();
        agencia.ejecutarPrograma();
    }
}
