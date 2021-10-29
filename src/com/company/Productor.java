package com.company;

public class Productor implements Runnable{
    public final int NUMERO_DATOS =100;
    public final int NUMERO_MÁXIMO =100;
    final Contenedor datos;


    public Productor(Contenedor datos) {
        this.datos = datos;
    }

    @Override
    public void run() {
        // TRata de bloquear el contenedor
        // Cada vez que se usa la palabra syncronized el monitor manda señales a los hilos
        int[] dato;
    while(true){
        // Los calculos se hacen fuera del bloque de sincronización
        dato = producirDato();
        // puedo usar los datos yo solo?
        synchronized (datos){
            //Comprueba si se ha producido el numero maximo de recursos necesarios
            // Si no es el caso el hilo produce otro elemento y lo posiciona en el contenedor

            while(datos.maxAlcanzado()){
                try{
                    // Espera inactiva, no  consume recursos del procesador
                    datos.wait();
                }catch(InterruptedException e){
                    System.out.println("*****INTERRUMPIDO*****" + this.nombre);
                }
            }
            datos.put(dato);
            datos.notifyAll();
        }
    }
    }

    private int [] producirDato() {
        int dato [];
        dato = new  int [NUMERO_DATOS];
        for (int i = 0; i < dato.length; i++) {
            dato[i] = (int) (Math.random() * NUMERO_MÁXIMO+1);
        }
        return dato;
    }
}
