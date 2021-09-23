/*
 * 
 */
package main;

import clases.Alumno;
import clases.Materia;
import java.util.Scanner;


public class Main {
    
    static Scanner input;
    static Alumno[] alumnos;
    static String nombre;
    static String grado;
    static Materia materia;
    static String nota;
    static boolean validarDatos = false;
    
    public static void main(String[] args) {
        
        input = new Scanner(System.in);
        alumnos = new Alumno[5];
        
        System.out.println("Bienvenido al sistema de cálculo de notas de alumnos");
        System.out.println("----------------------------------------------------");
        System.out.println();
        System.out.println("Por favor, introduzca la información relativa a los alumnos:");
        
        for(int i = 0; i<alumnos.length; i++){
            System.out.println();
            System.out.println("Alumno #" + (i+1));
            System.out.println("Nombre: ");
            nombre = input.nextLine();
            //Bucle que solicita el grado hasta que sea un valor correcto
            while(validarDatos == false){
                //Se captura exception en caso de que el usuario introduzca una cadena de caracteres en vez de
                //un grado con valor numerico y se muestra mensaje
                try{
                    System.out.println("Grado: ");
                    grado = input.nextLine();
                    if(Integer.parseInt(grado)>0 && Integer.parseInt(grado)<=10){
                        validarDatos = true;
                    }
                    else{
                        System.out.println("ERROR. El grado ha de ser un número entero del 1 al 10");
                    }
                }catch(NumberFormatException ex){
                    System.out.println("ERROR. El grado ha de ser un número entero del 1 al 10");
                }
            }
                
            validarDatos = false;
            System.out.println("Materia: ");
            materia = new Materia(input.nextLine());
            
            //Si todo es correcto se instancia un objeto de alumno guardandolo en la posicion 
            //del array correspondiente
            alumnos[i] = new Alumno(nombre, materia, Integer.parseInt(grado));
            //Se solicitan las notas de las 5 actividades
            System.out.println("Indique las notas de las actividades: ");
            System.out.println();
            
            for(int j = 0; j<materia.getNotasActividades().length; j++){
                //Se repite la solicitud de cada nota hasta que sea un numero correcto del 1 al 10
                while(validarDatos == false){
                    //Se captura la exception en caso de que el usuario introduzca una cadena de caracteres
                    //en vez de un valor numerico
                    try{
                        System.out.println("Actividad #" + (j+1));
                        nota = input.nextLine();
                        if(Double.parseDouble(nota)>0 && Double.parseDouble(nota)<=10){
                            validarDatos = true;
                        }
                        else{
                            System.out.println("ERROR. La nota ha de ser un número del 1 al 10");
                        }
                    }catch(NumberFormatException ex){
                        System.out.println("ERROR. La nota ha de ser un número del 1 al 10");
                    }
                }
                validarDatos = false;
                //Si la nota es correcta, se añade al array de notas de la materia del alumno antes instanciado
                alumnos[i].getMateria().agregarNota(Double.parseDouble(nota), j);
                
            }
            //Una vez añadidas todas las notas se calcula la nota final y el estado de la materia
            alumnos[i].getMateria().calcularNotaFinal();
            alumnos[i].getMateria().calcularEstado();
            System.out.println("El estado de la materia es: " + alumnos[i].getMateria().getEstado());
        }
        
        System.out.println("------------------------");
        System.out.println("Previsión de los alumnos");
        System.out.println();
        mostrarAlumnos();
        
        
    }//Fin metodo main
    
    //Metodo que muestra la informacion requerida de los alumnos según el enunciado
    public static void mostrarAlumnos(){
        
        for(int i = 0; i<alumnos.length; i++){
            System.out.println(alumnos[i].toString());
        }
    }
    
}//Fin Main
