package com.company;

import java.util.ArrayList;
import java.util.List;

public class Contenedor {
    private int MAXIMO = 10;
    // Aunque vayamos a añadir elementos al arraylist se marca como final, peus la instanciación solo se realiza una vez
    private final List<int[]> datos = new ArrayList<>();

    public synchronized void put(int[]datos){
        this.datos.add(datos);
    }
    public synchronized int[] get(){
        int[]dato = datos.get(0);
        datos.remove(datos.get(0));
        return dato;
    }
    public synchronized boolean datoDisponible(){
        boolean dato = true;
        if(!contenedorVacio()){
            dato=false;
        }
        return dato;
    }

    // devuelve true si ya ha alcanzado el max (10)
    synchronized boolean maxAlcanzado(){
        return datos.size()==MAXIMO;
    }
    synchronized boolean contenedorVacio(){
        return datos.isEmpty();
    }
}
