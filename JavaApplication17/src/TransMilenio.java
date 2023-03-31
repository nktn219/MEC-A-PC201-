import java.util.*;

public class TransMilenio {
    public static void main(String[] args) { 
        // Crear estaciones
        Estacion estacion1 = new Estacion("Portal de las Américas");
        Estacion estacion2 = new Estacion("Marsella");
        Estacion estacion3 = new Estacion("Patio Bonito");
        Estacion estacion4 = new Estacion("San Façon");
        Estacion estacion5 = new Estacion("Museo del Oro");

        // Crear rutas
        Ruta ruta1 = new Ruta("B23");
        ruta1.agregarEstacion(estacion1);
        ruta1.agregarEstacion(estacion2);
        ruta1.agregarEstacion(estacion3);
        Ruta ruta2 = new Ruta("G10");
        ruta2.agregarEstacion(estacion3);
        ruta2.agregarEstacion(estacion4);
        ruta2.agregarEstacion(estacion5);

        // Crear transportes
        Transporte transporte1 = new Transporte(ruta1, "Bus");
        Transporte transporte2 = new Transporte(ruta2, "Bus");

        // Crear lista de transportes
        List<Transporte> transportes = new ArrayList<>();
        transportes.add(transporte1);
        transportes.add(transporte2);

        // Pedir entrada del usuario
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el nombre de la estación: ");
        String nombreEstacion = scanner.nextLine();
        System.out.print("Ingrese el número de la ruta: ");
        String numeroRuta = scanner.nextLine();

        // Buscar el tipo de transporte asociado a la combinación de estación y ruta
        String tipoTransporte = "No se encontró una combinación de estación y ruta válida";
        for (Transporte transporte : transportes) {
            Ruta ruta = transporte.getRuta();
            if (ruta.contieneEstacion(nombreEstacion) && ruta.getNumero().equals(numeroRuta)) {
                tipoTransporte = transporte.getTipo();
                break;
            }
        }

        // Mostrar el resultado
        System.out.println("El tipo de transporte asociado a la estación " + nombreEstacion + " y la ruta " + numeroRuta + " es: " + tipoTransporte);
    }
}

class Estacion {
    private final String nombre;

    public Estacion(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
}

class Ruta {
    private final String numero;
    private final List<Estacion> estaciones;

    public Ruta(String numero) {
        this.numero = numero;
        this.estaciones = new ArrayList<>();
    }

    public String getNumero() {
        return numero;
    }

    public void agregarEstacion(Estacion estacion) {
        estaciones.add(estacion);
    }

    public boolean contieneEstacion(String nombreEstacion) {
        for (Estacion estacion : estaciones) {
            if (estacion.getNombre().equals(nombreEstacion)) {
                return true;
            }
        }
        return false;
    }
}

class Transporte {
    private final Ruta ruta;
    private final String tipo;

    public Transporte(Ruta ruta, String tipo)
{
    this.ruta = ruta;
    this.tipo = tipo;
}

public Ruta getRuta() {
    return ruta;
}

public String getTipo() {
    return tipo;
}
}