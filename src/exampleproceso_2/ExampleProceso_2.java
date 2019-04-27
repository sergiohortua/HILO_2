/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exampleproceso_2;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author PC-50
 */
public class ExampleProceso_2 implements Runnable {

    private int nombre;
    private int duracion;
    static int hil;

    public static void main(String[] args) {
        // TODO code application logic here

        Scanner tc = new Scanner(System.in);
        System.out.print("digite el hilo que desea interrumpir ");
        hil = tc.nextInt();

        Random aleatorio = new Random(1337);

        for (int i = 0; i < 3; i++) {
            new Thread(new ExampleProceso_2(i, aleatorio.nextInt(10000))).start();
        }

    }

    public ExampleProceso_2(int nombre, int duracion) {
        this.nombre = nombre;
        this.duracion = duracion;
    }

    @Override
    public void run() {
        System.out.println("Soy el hilo: " + this.nombre + " y he iniciado mi ejecucion");
        System.out.println("Soy el hilo: " + this.nombre + " y voy a parar mi ejecicion en " + this.duracion + " ms");

        try {
            if (this.nombre == hil) {
                throw new InterruptedException();
            }
            Thread.sleep(this.duracion);
        } catch (InterruptedException e) {
            System.out.println("Interrupcion inesperada del hilo " + this.nombre);
            return;
        }
        System.out.println("Soy el hilo: " + this.nombre + " y he iniciado mi ejecucion");
        System.out.println("Soy el hilo: " + this.nombre + " y he finalizado mi ejecicion en ");
    }

}
