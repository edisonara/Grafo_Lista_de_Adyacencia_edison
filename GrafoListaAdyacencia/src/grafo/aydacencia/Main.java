package grafo.aydacencia;

import java.util.Scanner;
import grafo.aydacencia.*;

public class Main {
    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        GrafoAdcia grafo = new GrafoAdcia(20);
        AnalizadorRecorridoProfundidad analizador = new AnalizadorRecorridoProfundidad();
        int opcion;
        do {
            System.out.println("MENU");
            System.out.println("1. Agregar un nuevo vértice");
            System.out.println("2. Agregar un nuevo arco");
            System.out.println("3. Determinar si dos vértices son adyacentes");
            System.out.println("4. Realizar recorrido en profundidad");
            System.out.println("5. Determinar Eficiencia");
            System.out.println("6. Determinar Complejidad");
            System.out.println("0. Salir");
            System.out.print("Ingrese una opción: ");
            opcion = inputScanner.nextInt();
            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nombre de la ciudad: ");
                    String nombreCiudad = inputScanner.next();
                    VerticeAdy vertice = new VerticeAdy(nombreCiudad);
                    grafo.agregarVertice(vertice);
                    System.out.println("Se agregó el vértice " + nombreCiudad);
                    break;
                case 2:
                    System.out.print("Ingrese el número del vértice origen: ");
                    int origen = inputScanner.nextInt();
                    System.out.print("Ingrese el número del vértice destino: ");
                    int destino = inputScanner.nextInt();
                    System.out.print("Ingrese el peso del arco: ");
                    double peso = inputScanner.nextDouble();
                    grafo.agregarArco(origen, destino, peso);
                    System.out.println("Se agregó el arco (" + origen + ", " + destino + ") con peso " + peso);
                    break;
                case 3:
                    System.out.print("Ingrese el número del vértice 1: ");
                    int v1 = inputScanner.nextInt();
                    System.out.print("Ingrese el número del vértice 2: ");
                    int v2 = inputScanner.nextInt();
                    if (grafo.sonAdyacentes(v1, v2)) {
                        System.out.println("Los vértices " + v1 + " y " + v2 + " son adyacentes");
                    } else {
                        System.out.println("Los vértices " + v1 + " y " + v2 + " no son adyacentes");
                    }
                    break;
                case 4:
                    System.out.print("Ingrese el número del vértice de inicio para el recorrido en profundidad: ");
                    int startVertex = inputScanner.nextInt();
                    System.out.println("Recorrido en Profundidad desde el vértice " + startVertex + ":");
                    analizador.recorridoEnProfundidad(grafo, startVertex).forEach(System.out::println);
                    break;
                case 5:
                    double eficiencia = analizador.determinarEficiencia(grafo);
                    System.out.println("La eficiencia del recorrido en profundidad es " + eficiencia);
                    break;
                case 6:
                    int complejidad = analizador.determinarComplejidad(grafo);
                    System.out.println("La complejidad del recorrido en profundidad es O(" + complejidad + ")");
                    break;
                case 0:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida");
                    break;
            }
        } while (opcion != 0);
    }
}
