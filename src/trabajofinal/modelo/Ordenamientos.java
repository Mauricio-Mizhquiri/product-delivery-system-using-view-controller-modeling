package trabajofinal.modelo;

import java.util.ArrayList;

public class Ordenamientos {

    //ORDENAMIENTO HEAPSORT POR PLACA
    public void HeapVehiculo(ArrayList<Vehiculo> arreglo) {
        final int tamanio = arreglo.size();
        for (int iteracion = tamanio / 2; iteracion >= 0; iteracion--) {
            recursivoHeapVehiculo(arreglo, iteracion, tamanio - 1);
        }
        for (int iteracion = tamanio - 1; iteracion >= 0; iteracion--) {
            Vehiculo temporal = arreglo.get(0);
            arreglo.set(0, arreglo.get(iteracion));
            arreglo.set(iteracion, temporal);
            recursivoHeapVehiculo(arreglo, 0, iteracion - 1);
        }
    }

    //INTERMEDIO DEL ORDENAMIENTO
    private void recursivoHeapVehiculo(ArrayList<Vehiculo> arreglo, int monticulo, int tamanio) {
        int inicial = 2 * monticulo + 1;
        int mitad = inicial + 1;
        int mayor;
        if (inicial > tamanio) {
            return;
        }
        if (mitad > tamanio) {
            mayor = inicial;
        } else {
            mayor = arreglo.get(inicial).getPlaca().compareToIgnoreCase(arreglo.get(mitad).getPlaca()) > 0 ? inicial : mitad;
        }
        if (arreglo.get(monticulo).getPlaca().compareToIgnoreCase(arreglo.get(mayor).getPlaca()) < 0) {
            Vehiculo tmp = arreglo.get(monticulo);
            arreglo.set(monticulo, arreglo.get(mayor));
            arreglo.set(mayor, tmp);
            recursivoHeapVehiculo(arreglo, mayor, tamanio);
        }
    }

    //ORDENAMIENTO HEAP CONTRATO
    public void HeapContrato(ArrayList<Transaccion> arreglo, boolean fecha, boolean ciudad) {
        final int tamanio = arreglo.size();
        for (int iteracion = tamanio / 2; iteracion >= 0; iteracion--) {
            recursivoHeapContrato(arreglo, iteracion, tamanio - 1, fecha, ciudad);
        }
        for (int iteracion = tamanio - 1; iteracion >= 0; iteracion--) {
            Transaccion temporal = arreglo.get(0);
            arreglo.set(0, arreglo.get(iteracion));
            arreglo.set(iteracion, temporal);
            recursivoHeapContrato(arreglo, 0, iteracion - 1, fecha, ciudad);
        }
    }

    //INTERMEDIO DEL ORDENAMIENTO
    private void recursivoHeapContrato(ArrayList<Transaccion> arreglo, int monticulo, int tamanio, boolean fecha, boolean ciudad) {
        int inicial = 2 * monticulo + 1;
        int mitad = inicial + 1;
        int mayor = 0;
        if (inicial > tamanio) {
            return;
        }
        if (mitad > tamanio) {
            mayor = inicial;
        } else {
            if (fecha) {
                mayor = arreglo.get(inicial).getFecha().compareToIgnoreCase(arreglo.get(mitad).toString()) > 0 ? inicial : mitad;
            }
            if (ciudad) {
                mayor = arreglo.get(inicial).getDestino().getNombre().compareToIgnoreCase(arreglo.get(mitad).getDestino().getNombre()) > 0 ? inicial : mitad;
            }
        }
        int validacion = 0;
        if (fecha) {
            validacion = arreglo.get(monticulo).getFecha().compareToIgnoreCase(arreglo.get(mayor).toString());
        }
        if (ciudad) {
            validacion = arreglo.get(monticulo).getDestino().getNombre().compareToIgnoreCase(arreglo.get(mayor).getDestino().getNombre());
        }
        if (validacion < 0) {
            Transaccion tmp = arreglo.get(monticulo);
            arreglo.set(monticulo, arreglo.get(mayor));
            arreglo.set(mayor, tmp);
            recursivoHeapContrato(arreglo, mayor, tamanio, fecha, ciudad);
        }
    }

    public void quicksortVehiclo(ArrayList<Vehiculo> arreglo, int izquierdo, int derecho) {

        Vehiculo pivote = arreglo.get(izquierdo);//A[izq]; // pivote
        int i = izquierdo;
        int j = derecho;
        Vehiculo auxiliar;
        while (i < j) { // mientras no se crucen las búsquedas
            while (arreglo.get(i).getPlaca().compareToIgnoreCase(pivote.getPlaca()) <= 0 && i < j) {
                i++; //A[i]<=pivote busca elemento mayor que pivote
            }
            while (arreglo.get(j).getPlaca().compareToIgnoreCase(pivote.getPlaca()) > 0) {
                j--;         // busca elemento menor que pivoteA[j]>pivote
            }
            if (i < j) {// si no se han cruzado                      
                auxiliar = arreglo.get(i); //A[i];//intercambio
                arreglo.set(i, arreglo.get(j));
                arreglo.set(j, auxiliar);
            }
        }
        arreglo.set(izquierdo, arreglo.get(j));//separa menores izquierda mayores derecha
        arreglo.set(j, pivote);  //A[j]=pivote; 
        if (izquierdo < j - 1) {
            quicksortVehiclo(arreglo, izquierdo, j - 1); // ordenamos subarray izquierdo
        }
        if (j + 1 < derecho) {
            quicksortVehiclo(arreglo, j + 1, derecho); // ordenamos subarray derecho
        }
    }

    //QUICKSORT CONTRATO
    public void quicksortContrato(ArrayList<Transaccion> arreglo, int izquierdo, int derecho, boolean fecha, boolean ciudad) {

        Transaccion pivote = arreglo.get(izquierdo);//A[izq]; // pivote
        int i = izquierdo;
        int j = derecho;

        Transaccion auxiliar;
        while (i < j) { // mientras no se crucen las búsquedas
            int validacion = 0;
            if (fecha) {
                while (arreglo.get(i).getFecha().compareToIgnoreCase(pivote.getFecha()) <= 0 && i < j) {
                    i++; //A[i]<=pivote busca elemento mayor que pivote
                }
            }
            if (ciudad) {
                while (arreglo.get(i).getDestino().getNombre().compareToIgnoreCase(pivote.getDestino().getNombre()) <= 0 && i < j) {
                    i++; //A[i]<=pivote busca elemento mayor que pivote
                }
            }

            if (fecha) {
                while (arreglo.get(j).getFecha().compareToIgnoreCase(pivote.getFecha())> 0) {
                    j--;         // busca elemento menor que pivoteA[j]>pivote
                }
            }
            if (ciudad) {
                while (arreglo.get(j).getDestino().getNombre().compareToIgnoreCase(pivote.getDestino().getNombre()) > 0) {
                    j--;         // busca elemento menor que pivoteA[j]>pivote
                }
            }

            if (i < j) {// si no se han cruzado                      
                auxiliar = arreglo.get(i); //A[i];//intercambio
                arreglo.set(i, arreglo.get(j));
                arreglo.set(j, auxiliar);
            }
        }
        arreglo.set(izquierdo, arreglo.get(j));//separa menores izquierda mayores derecha
        arreglo.set(j, pivote);  //A[j]=pivote; 
        if (izquierdo < j - 1) {
            quicksortContrato(arreglo, izquierdo, j - 1, fecha, ciudad); // ordenamos subarray izquierdo
        }
        if (j + 1 < derecho) {
            quicksortContrato(arreglo, j + 1, derecho, fecha, ciudad); // ordenamos subarray derecho
        }
    }

    //ORDENAMIENTO MERGESORT
    public ArrayList<Vehiculo> mergeSortPlaca(ArrayList<Vehiculo> arreglo) {
        int i, j, k;
        if (arreglo.size() > 1) {
            int numIzq = arreglo.size() / 2;
            int numDer = arreglo.size() - numIzq;
            ArrayList<Vehiculo> arregloIzq = new ArrayList<Vehiculo>();
            ArrayList<Vehiculo> arregloDer = new ArrayList<Vehiculo>();
            for (i = 0; i < numIzq; i++) {
                arregloIzq.add(arreglo.get(i));
            }
            for (i = numIzq; i < numIzq + numDer; i++) {
                arregloDer.add(arreglo.get(i));
            }
            arregloIzq = mergeSortPlaca(arregloIzq);
            arregloDer = mergeSortPlaca(arregloDer);
            i = 0;
            j = 0;
            k = 0;
            while (arregloIzq.size() != j && arregloDer.size() != k) {
                if (arregloIzq.get(j).getPlaca().compareToIgnoreCase(arregloDer.get(k).getPlaca()) < 0) {
                    arreglo.set(i, arregloIzq.get(j));
                    i++;
                    j++;
                } else {
                    arreglo.set(i, arregloDer.get(k));
                    i++;
                    k++;
                }
            }
            while (arregloIzq.size() != j) {
                arreglo.set(i, arregloIzq.get(j));
                i++;
                j++;
            }
            while (arregloDer.size() != k) {
                arreglo.set(i, arregloDer.get(k));
                i++;
                k++;
            }
        }
        return arreglo;
    }
    //ORDENAMIENTO MERGESORT TRANSACCION
    public ArrayList<Transaccion> mergeSortTransaccion(ArrayList<Transaccion> arreglo, boolean fecha, boolean ciudad) {
        int i, j, k;
        if (arreglo.size() > 1) {
            int numIzq = arreglo.size() / 2;
            int numDer = arreglo.size() - numIzq;
            ArrayList<Transaccion> arregloIzq = new ArrayList<Transaccion>();
            ArrayList<Transaccion> arregloDer = new ArrayList<Transaccion>();
            for (i = 0; i < numIzq; i++) {
                arregloIzq.add(arreglo.get(i));
            }
            for (i = numIzq; i < numIzq + numDer; i++) {
                arregloDer.add(arreglo.get(i));
            }
            arregloIzq = mergeSortTransaccion(arregloIzq, fecha, ciudad);
            arregloDer = mergeSortTransaccion(arregloDer, fecha, ciudad);
            i = 0;
            j = 0;
            k = 0;
            while (arregloIzq.size() != j && arregloDer.size() != k) {
                if (fecha) {
                    if (arregloIzq.get(j).getFecha().compareToIgnoreCase(arregloDer.get(k).getFecha()) < 0) {
                        arreglo.set(i, arregloIzq.get(j));
                        i++;
                        j++;
                    } else {
                        arreglo.set(i, arregloDer.get(k));
                        i++;
                        k++;
                    }
                }
                if (ciudad) {
                    if (arregloIzq.get(j).getDestino().getNombre().compareToIgnoreCase(arregloDer.get(k).getDestino().getNombre()) < 0) {
                        arreglo.set(i, arregloIzq.get(j));
                        i++;
                        j++;
                    } else {
                        arreglo.set(i, arregloDer.get(k));
                        i++;
                        k++;
                    }
                }
            }
            while (arregloIzq.size() != j) {
                arreglo.set(i, arregloIzq.get(j));
                i++;
                j++;
            }
            while (arregloDer.size() != k) {
                arreglo.set(i, arregloDer.get(k));
                i++;
                k++;
            }
        }
        return arreglo;
    }
}
