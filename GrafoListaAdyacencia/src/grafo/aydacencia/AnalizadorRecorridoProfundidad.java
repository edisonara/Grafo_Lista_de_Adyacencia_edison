package grafo.aydacencia;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

import grafo.aydacencia.GrafoAdcia;
import grafo.aydacencia.VerticeAdy;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

import grafo.aydacencia.GrafoAdcia;
import grafo.aydacencia.VerticeAdy;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class AnalizadorRecorridoProfundidad {

	public static Set<VerticeAdy> recorridoEnProfundidad(GrafoAdcia grafo, int startVertex) {
        Set<VerticeAdy> visitados = new HashSet<>();
        Stack<VerticeAdy> pila = new Stack<>();
        pila.push(grafo.tablAdc[startVertex]); // Agregar el vértice de inicio a la pila

        while (!pila.isEmpty()) {
            VerticeAdy currentVertex = pila.pop(); // Obtener el vértice actual

            if (!visitados.contains(currentVertex)) {
                visitados.add(currentVertex); // Marcar el vértice actual como visitado

                List<Arco> vecinos = currentVertex.lad; // Obtener la lista de adyacencia

                for (Arco arco : vecinos) {
                    int neighborIndex = arco.destino; // Obtener el índice del vecino
                    pila.push(grafo.tablAdc[neighborIndex]); // Agregar el vecino a la pila
                }
            }
        }

        return visitados;
    }

    public static int determinarComplejidad(GrafoAdcia grafo) {
        // La complejidad del recorrido en profundidad es O(V + E).
        int numVertices = grafo.numVerts;
        int numAristas = calcularNumAristas(grafo);
        return numVertices + numAristas;
    }

    private static int calcularNumAristas(GrafoAdcia grafo) {
        int numAristas = 0;
        for (int i = 0; i < grafo.numVerts; i++) {
            numAristas += grafo.tablAdc[i].lad.size();
        }
        return numAristas;
    }

    public static double determinarEficiencia(GrafoAdcia grafo) {
        // La eficiencia del recorrido en profundidad es V / E.
        int numVertices = grafo.numVerts;
        int numAristas = calcularNumAristas(grafo);
        return (double) numVertices / numAristas;
    }
}
