/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actividadjdbc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author guti8
 */
public class Herramientas {

    public static String pidePalabra(String pregunta) {
        String userInput = "";
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println(pregunta);
            userInput = br.readLine();

        } catch (IOException ex) {
            System.out.println("Input/Output Error");
        }
        return userInput;

    }

    public static double pideDouble(String pregunta) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double userInput = 0;

        boolean flag = false;
        do {
            try {
                System.out.println(pregunta);
                userInput = Double.parseDouble(br.readLine());
                flag = true;
            } catch (IOException ex) {
                System.out.println("Input/Output error");
            } catch (NumberFormatException nex) {
                System.out.println("El valor introducido no es número válido.");
            }
        } while (!flag);
        return userInput;
    }

    public static int pideEntero(String pregunta) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numero = 0;
        boolean flag = false;

        do {
            System.out.println(pregunta);
            try {
                numero = Integer.parseInt(br.readLine());
                flag = true;
            } catch (IOException ex) {
                System.out.println("Input/Output error");
            } catch (NumberFormatException nex) {
                System.out.println("El valor introducido no es un número válido.");
            }

        } while (!flag);
        return numero;
    }

    public static void enter() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            String enter = br.readLine();
        } catch (IOException ex) {
            System.out.println("Input/Output Error");
        }
    }

    public static long randomAccount() {

        long account[] = new long[10];

        Random shuffle = new Random();

        for (int i = 0; i < account.length; i++) {

            account[i] = shuffle.nextInt(9); // genero un numero del 0-9 para el numero de cuenta
        }

        StringBuilder strNum = new StringBuilder();

        for (long newValue : account) { // del valor de array accont, añado cada 
            strNum.append(newValue);    // valor del array con "Append" en la variable srtnNum
        }
        // Creo una variable long para poder convertir la String strNum a Long.
        long finaLong = Long.parseLong(strNum.toString());

        // Retorno el valor long para la funcion.
        return finaLong;

    }

    

}
