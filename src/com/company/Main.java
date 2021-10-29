package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static int NUMERO_PRODUCTORES= 5;
    public static int NUMERO_CONSUMIDORES= 5;

    public static void main(String[] args) {
	// write your code here

        Contenedor almacen = new Contenedor();
        List <Thread> productores = new ArrayList<>();
        List <Thread> consumidores = new ArrayList<>();
        for (int i = 0; i < NUMERO_PRODUCTORES ; i++) {
            productores.add(new Thread(new Productor(almacen)));
        }

        for (int i = 0; i < NUMERO_PRODUCTORES ; i++) {
            consumidores.add(new Thread(new Consumidor(almacen)));
        }

        hprod1.start();
        hprod2.start();
        hprod3.start();
        hprod4.start();
        hcons1.start();
        hcons2.start();
        hcons3.start();
        hcons4.start();
    }
}
