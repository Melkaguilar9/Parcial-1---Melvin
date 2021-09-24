/*
 * 
 */
package clases;


public class Materia {
    
    //Declaracion de atributos
    private String nombre;
    private double[] notasActividades;
    private double notaFinal;
    private String estado;
    
    //Constantes
    public final int[] PORCENTAJE_ACTIVIDADES;
    
    
    //Constructor
    public Materia(String n){
        this.nombre = n;
        this.notaFinal = 0;
        this.notasActividades = new double[5];
        this.PORCENTAJE_ACTIVIDADES = new int[5];
        this.PORCENTAJE_ACTIVIDADES[0] = 15;
        this.PORCENTAJE_ACTIVIDADES[1] = 10;
        this.PORCENTAJE_ACTIVIDADES[2] = 20;
        this.PORCENTAJE_ACTIVIDADES[3] = 30;
        this.PORCENTAJE_ACTIVIDADES[4] = 25;
    }
    
    //Metodos get y set
    public void setNombre(String n){
        this.nombre = n;
    }
    
    public String getNombre(){
        return this.nombre;
    }
    
    public void setNotaFinal(double n){
        this.notaFinal = n;
    }
    
    public double getNotaFinal(){
        return this.notaFinal;
    }
    
    public void setEstado(String e){
        this.estado = e;
    }
    
    public String getEstado(){
        return this.estado;
    }
    
    public double[] getNotasActividades(){
        return this.notasActividades;
    }
    
    //Metodo que agrega una nota en una determinada posicion del array de actividades
    public void agregarNota(double n, int p){
        this.notasActividades[p] = n;
    }
    
    //Metodo que calcula la nota final, que segun el enunciado, es la sumatoria de los porcentajes 
    //de la nota individual de cada actividad
    public void calcularNotaFinal(){
        
        for(int i = 0; i<this.notasActividades.length; i++){
            this.notaFinal = this.notaFinal + ((this.notasActividades[i]*this.PORCENTAJE_ACTIVIDADES[i])/100);
        }
    }
    
    //Metodo que calcula el estado en el que se encuentra la materia en base a la nota final
    public void calcularEstado(){
        
        if(this.notaFinal>=7.0){
            this.estado = "APROBADO";
        }
        else if(this.notaFinal<=5.0){
            this.estado = "REPROBADO";
        }
        else{
            this.estado = "EXAMEN";
        }
    }
    
}//Fin Materia
