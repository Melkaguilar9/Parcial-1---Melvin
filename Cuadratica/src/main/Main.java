/*
 * Programa que solicita al usuario los valores de a,b y c para resolver la ecuacion cuadratica.
 */
package main;

import java.util.InputMismatchException;
import java.util.Scanner;


public class Main {

    //Declaracion e inicializacion de atributos
    static Scanner input = new Scanner(System.in);
    static double a, b, c, resultado1, resultado2;
    
    public static void main(String[] args) {
        
        //Se captura exception en caso de que el usuario no introduzca valores numericos 
        //Mostrando mensaje de error.
        try{
            //Peticion de datos al usuario
            System.out.println("Resolución de la ecuación cuadrática");
            System.out.println("------------------------------------");
            System.out.println();
            System.out.println("Indique el valor de A: ");
            a = input.nextDouble();
            System.out.println("Indique el valor de B: ");
            b = input.nextDouble();
            System.out.println("Indique el valor de C: ");
            c = input.nextDouble();
        
            //Resolucion de la ecuacion y obtencion de los dos posibles resultados
            resultado1 = (-b + Math.sqrt(Math.pow(b, 2) - (4*a*c))) / (2*a);
            resultado2 = (-b - Math.sqrt(Math.pow(b, 2) - (4*a*c))) / (2*a);
        
            //Se muestra por consola los valores obtenidos de X
            System.out.println("Resolución #1: \n" + "X = " + resultado1);
            System.out.println("Resolución #2: \n" + "X = " + resultado2);
        }catch(InputMismatchException ex){
            System.out.println("ERROR. Los valores introducidos han de ser numéricos");
        }
        
        
    }
    
}
