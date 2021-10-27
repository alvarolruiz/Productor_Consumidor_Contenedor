package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Contenedor almacen = new Contenedor();
        Thread hprod1 = new Thread(new Productor(almacen, "P1"));
        Thread hprod2 = new Thread(new Productor(almacen, "P2"));
        Thread hprod3 = new Thread(new Productor(almacen, "P3"));
        Thread hprod4 = new Thread(new Productor(almacen, "P4"));
        Thread hcons1 = new Thread(new Consumidor(almacen, "C1"));
        Thread hcons2 = new Thread(new Consumidor(almacen, "C2"));
        Thread hcons3 = new Thread(new Consumidor(almacen, "C3"));
        Thread hcons4 = new Thread(new Consumidor(almacen, "C4"));
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
