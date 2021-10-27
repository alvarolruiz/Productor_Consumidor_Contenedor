package com.company;

public class Consumidor implements Runnable{
    final Contenedor datos;
    String nombre;

    public Consumidor(Contenedor datos, String nombre) {
        this.datos = datos;
        this.nombre=nombre;
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

    private void consumirDato(int[] dato) {
        int resultado=0;
        for (int i = 0; i < dato.length; i++) {
            resultado +=dato[i];
        }
        System.out.println(resultado);
    }
}
