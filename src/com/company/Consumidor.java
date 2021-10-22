package com.company;

public class Consumidor implements Runnable{
    final Contenedor datos;

    public Consumidor(Contenedor datos) {
        this.datos = datos;
    }

    @Override
    public void run() {
        while (true){
            synchronized (datos){
                while(datos.contenedorVacio()){
                    try{
                        datos.wait();
                    }catch (InterruptedException e){

                    }
                }
                consumirDato(datos.get());
                datos.notifyAll();
            }
        }

    }

    private int consumirDato(int[] dato) {
        int resultado= 0;
        for (int i = 0; i < dato.length; i++) {
            resultado +=dato[i];
        }
        return resultado;
    }
}
