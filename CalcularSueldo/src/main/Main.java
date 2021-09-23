/*
 * Programa que solicita la informacion de 5 empleados para calcular su sueldo liquido
 */
package main;

import clases.Empleado;
import java.util.Scanner;


public class Main {

    static Empleado[] empleados;
    static Scanner input;
    static String nombre;
    static String apellidos;
    static String cargo;
    static String horas;
    static boolean validarHoras = false;
    
    public static void main(String[] args) {
        
        empleados = new Empleado[5];
        input = new Scanner(System.in);
        
        System.out.println("Bienvenido al sistema de cálculo de nóminas");
        System.out.println("--------------------------------------------");
        System.out.println();
        System.out.println("Por favor, introduzca la información relativa a los empleados:");
        
        for(int i=0; i<empleados.length; i++){
            System.out.println();
            System.out.println("Empleado #" + (i+1));
            System.out.println("Nombre: ");
            nombre = input.nextLine();
            System.out.println("Apellidos: ");
            apellidos = input.nextLine();
            System.out.println("Cargo: ");
            cargo = input.nextLine();
            //Se solicita las horas hasta que cumplan la condicion adecuada
            while(validarHoras==false){
                //Se captura exception en caso de que el usuario introduzca una cadena de caracteres en vez de un 
                //valor numerico y se muestra mensaje de error si es asi.
                try{
                    System.out.println("Horas trabajadas: ");
                    horas = input.nextLine();
                    if(Integer.parseInt(horas)>0){
                        validarHoras = true;
                    }
                    else{
                        System.out.println("ERROR. Las horas trabajadas no pueden ser menores a 1");
                    }
                }catch(NumberFormatException ex){
                    System.out.println("ERROR. El valor de 'horas trabajadas' ha de ser numérico");
                }
            }
            validarHoras = false;
            //Si todo es correcto, se instancia un nuevo objeto empleado guardandolo en la posicion correspondiente
            //del array de empleados calculando sus retenciones, sueldo base y sueldo liquido.
            empleados[i] = new Empleado(nombre, apellidos, cargo, Integer.parseInt(horas));
            empleados[i].calcularSueldoBase();
            empleados[i].calcularRetenciones();
            empleados[i].calcularSueldoLiquido();
        }
        
        System.out.println("-------------------------");
        mostrarEmpleados();
        System.out.println();
        System.out.println("-------------------------");
        System.out.println();
        System.out.println("Empleado con el salario más alto: ");
        System.out.println(empleadoMejorPagado().toString());
        System.out.println("-------------------------");
        System.out.println();
        System.out.println("Empleado con el salario más bajo: ");
        System.out.println(empleadoPeorPagado().toString());
        System.out.println("-------------------------");
        System.out.println();
        empleadosSueldosMayoresA(300);
        
        
        
    }//Fin metodo main
    
    //Metodo que muestra la informacion de todos los empleados del array
    public static void mostrarEmpleados(){
        
        System.out.println("Información de empleados:");
        System.out.println();
        for(int i = 0; i<empleados.length; i++){
            System.out.println("Empleado #" + (i+1));
            System.out.println();
            System.out.println(empleados[i].toString());
        }
    }
    
    //Metodo que devuelve el objeto Empleado con mayor sueldo líquido
    public static Empleado empleadoMejorPagado(){
        double mayor = 0;
        Empleado empleado = null;
        for(int i = 0; i<empleados.length; i++){
            if(empleados[i].getSueldoLiquido()>mayor){
                mayor = empleados[i].getSueldoLiquido();
                empleado = empleados[i];
            }
        }
        return empleado;
    }
    
    //Metodo que devuelve el objeto Empleado con menor sueldo líquido
    public static Empleado empleadoPeorPagado(){
        double menor = empleados[0].getSueldoLiquido();
        Empleado empleado = empleados[0];
        for(int i = 1; i<empleados.length; i++){
            if(empleados[i].getSueldoLiquido()<menor){
                menor = empleados[i].getSueldoLiquido();
                empleado = empleados[i];
            }
        }
        return empleado;
    }
    
    //Metodo que muestra por pantalla los empleados con un sueldo liquido mayor al especificado como parametro
    public static void empleadosSueldosMayoresA(double x){
        
        System.out.println("Empleados con un sueldo líquido mayor a $" + x);
        System.out.println();
        for(int i = 0; i<empleados.length; i++){
            if(empleados[i].getSueldoLiquido()>x){
                System.out.println(empleados[i].toString());
            }
        }
    }
    
}//Fin Main
