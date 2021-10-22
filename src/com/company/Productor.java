package com.company;

public class Productor implements Runnable{
    final Contenedor datos;

    public Productor(Contenedor datos) {
        this.datos = datos;
    }

    @Override
    public void run() {
        // TRata de bloquear el contenedor
        // Cada vez que se usa la palabra syncronized el monitor manda señales a los hilos
    while(true){

        // puedo usar los datos yo solo?
        synchronized (datos){
            //Comprueba si se ha producido el numero maximo de recursos necesarios
            // Si no es el caso el hilo produce otro elemento y lo posiciona en el contenedor
            while(datos.maxAlcanzado()){
                try{
                    // Espera inactiva, no  consume recursos del procesador
                    datos.wait();
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
            datos.put(producirDato());
            datos.notifyAll();
        }
    }
    }

    private int[] producirDato() {
        return null;
    }
}
