/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ruben;

import java.util.Scanner;

/**
 *
 * @author diabl
 */
public class ParteA {

    public static void main(String[] args) {
        final int KILOVATIOS_CAMBIO = 1000;
        int vatios, opcion;
        double kiloVatioHora, tiempo, precioTotal, kiloVatios;
        Scanner t = new Scanner(System.in);

        System.out.println("Bienvenido a la calculadora de luz");
        //bucle para repetir hasta que el usuario quiera salir 
        do {
            System.out.println("Que quiere hacer: \n 1- Calculadora \n 2- Salir");
            opcion = t.nextInt();
            //switch para elegir si desea saslir o usar la calculadora 
            switch (opcion) {

                case 1:
                    //Bucle para hacer que los datos de los vatios sean los deseados 
                    do {
                        System.out.println("Introduzca la cantidad de vatios del aparato (1-4500)");

                        vatios = t.nextInt();
                        //If para que si los datos son correctos entre en el y si no muestra un mensaje de error
                        if (vatios >= 1 && vatios <= 4500) {
                            //Bucle para hacer que el tiempo sea el deseado 
                            do {

                                System.out.println("Introduzca el tiempo de uso (0.01h-24h)");
                                tiempo = t.nextDouble();
                                //If para que si los datos son correctos entre en el y si no muestra un mensaje de error
                                if (tiempo > 0 && tiempo <= 24) {
                                    //Bucle para hacer que los datos del precio sean los deseados 
                                    do {

                                        System.out.println("Introduzca el precio de los kWh (0.1- 0.45)");
                                        kiloVatioHora = t.nextDouble();
                                        //If para que si los datos son correctos entre en el y si no muestra un mensaje de error
                                        if (kiloVatioHora > 0 && kiloVatioHora < 0.46) {
                                            //cuentas necesarias para hayar el precio de la luz
                                            kiloVatios = (double) vatios / KILOVATIOS_CAMBIO;
                                            precioTotal = ((kiloVatios * tiempo) * kiloVatioHora);
                                            System.out.printf("total a pagar es de = %.2f€", precioTotal);
                                            System.out.println(" ");

                                        } else {
                                            System.out.println("Cantidad invalida");
                                        }

                                    } while (kiloVatioHora < 0 || kiloVatioHora > 0.46);

                                } else {
                                    System.out.println("Hora incorrecta");
                                }

                            } while (tiempo < 0 || tiempo >= 24);

                        } else {
                            System.out.println("Cantidad invalida");
                        }

                    } while (vatios < 0 && vatios > 4501);
                    break;

                case 2:
                    System.out.println("Has selecionado salir");

            }

        } while (opcion != 2);

    }
}
