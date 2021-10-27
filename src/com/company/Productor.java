package com.company;

public class Productor implements Runnable{
    final Contenedor datos;
    String nombre;

    public Productor(Contenedor datos, String nombre) {
        this.datos = datos;
        this.nombre=nombre;
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
                    e.printStackTrace();
                }
            }
            datos.put(dato);
            datos.notifyAll();
        }
    }
    }

    private int [] producirDato() {
        int dato [];
        dato = new  int [100];
        for (int i = 0; i < dato.length; i++) {
            dato[i] = (int) (Math.random() * 100001);
        }
        return dato;
    }
}
