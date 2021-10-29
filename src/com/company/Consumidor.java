package com.company;

public class Consumidor implements Runnable{
    final Contenedor datos;


    public Consumidor(Contenedor datos) {
        this.datos = datos;

    }

    @Override
    public void run() {
        int[]dato = null;
        while (!Thread.currentThread().isInterrupted()){
            synchronized (datos){

                    while(datos.contenedorVacio()&&!Thread.currentThread().isInterrupted()) {
                        try {
                            datos.wait();
                        } catch (InterruptedException e) {

                        }
                    }
                    if(!Thread.currentThread().isInterrupted())
                    dato = datos.get();
                    datos.notifyAll();

            }
        }

    }

    private void consumirDato(int[] dato) {
        int resultado=0;
        for (int i = 0; i < dato.length; i++) {
            resultado +=dato[i];
        }
        System.out.println(resultado);
    }
}
