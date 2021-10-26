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
public class ParteB {

    public static void main(String[] args) {
        final int KILOVATIOS_CAMBIO = 1000;
        int vatios, opcion;
        double kiloVatioHoraPunta, kiloVatioHoraLlana, kiloVatioHoraValle, tiempo, tiempoHoraPunta, tiempoHoraValle, tiempoHoraLlana, precioTotal, kiloVatios, precioPunta, precioValle, precioLlana;
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
                                    //Bucle para conseguir las horas punta, llana y valle
                                    do {
                                        System.out.println("Introduzca el tiempo en hora punta ");
                                        tiempoHoraPunta = t.nextDouble();
                                        System.out.println("Introduzca el tiempo en hora llana");
                                        tiempoHoraLlana = t.nextDouble();
                                        System.out.println("Introduzca el tiempo en hora valle");
                                        tiempoHoraValle = t.nextDouble();

                                    } while (!(tiempo == (tiempoHoraValle + tiempoHoraLlana + tiempoHoraPunta)));
                                    //bucles para los kWh 
                                    do {
                                        System.out.println("Introduzca el precio de los kWh en la hora punta  (0.31- 0.45)");
                                        kiloVatioHoraPunta = t.nextDouble();
                                        kiloVatios = (double) vatios / KILOVATIOS_CAMBIO;
                                        precioPunta = ((kiloVatios * tiempoHoraPunta) * kiloVatioHoraPunta);
                                        System.out.printf("total a pagar es de = %.2f€", precioPunta);
                                        System.out.println(" ");

                                    } while (!(kiloVatioHoraPunta >= 0.31 && kiloVatioHoraPunta <= 0.45));
                                    do {
                                        System.out.println("Introduzca el precio de los kWh en la hora llana (0.21- 0.3)");
                                        kiloVatioHoraLlana = t.nextDouble();
                                        kiloVatios = (double) vatios / KILOVATIOS_CAMBIO;
                                        precioLlana = ((kiloVatios * tiempoHoraLlana) * kiloVatioHoraLlana);
                                        System.out.printf("total a pagar es de = %.2f€", precioLlana);
                                        System.out.println(" ");

                                    } while (!(kiloVatioHoraLlana >= 0.21 || kiloVatioHoraLlana <= 0.3));
                                    do {
                                        System.out.println("Introduzca el precio de los kWh en la hora valle (0.1- 0.2)");
                                        kiloVatioHoraValle = t.nextDouble();
                                        kiloVatios = (double) vatios / KILOVATIOS_CAMBIO;
                                        precioValle = ((kiloVatios * tiempoHoraValle) * kiloVatioHoraValle);
                                        System.out.printf("total a pagar es de = %.2f€", precioValle);
                                        System.out.println(" ");

                                    } while (!(kiloVatioHoraValle >= 0.1 || kiloVatioHoraValle <= 0.2));
                                    precioTotal = precioLlana + precioPunta + precioValle;
                                    System.out.printf("total a pagar es de = %.2f€", precioTotal);
                                    //If para que si los datos son correctos entre en el y si no muestra un mensaje de error
                                    //cuentas necesarias para hayar el precio de la luz
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
