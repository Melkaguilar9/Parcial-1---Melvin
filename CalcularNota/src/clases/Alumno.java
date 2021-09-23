/*
 * 
 */
package clases;


public class Alumno {
    
    //Declaracion de atributos
    private String nombre;
    private Materia materia;
    private int grado;
    private int estado;
    
    //Constructor
    public Alumno(String n, Materia m, int g){
        this.nombre = n;
        this.materia = m;
        this.grado = g;
    }
    
    //Metodos get y set
    public void setNombre(String n){
        this.nombre = n;
    }
    
    public String getNombre(){
        return this.nombre;
    }
    
    public void setMateria(Materia m){
        this.materia = m;
    }
    
    public Materia getMateria(){
        return this.materia;
    }
    
    //Metodo que comprueba si el alumno es graduado, devuelve true si el grado es 10 y la materia esta
    //aprobada, devuelve false en caso contrario.
    public boolean isGraduado(){
        
        if(this.grado==10 && this.materia.getEstado().equalsIgnoreCase("APROBADO")){
            return true;
        }
        
        return false;
    }
    
    //Metodo que devuelve un String que representa el estado en el que se encuentra el alumno en base 
    //al grado y el estado de la materia
    public String getEstado(){
        String aux = "";
        if(this.grado==10 && this.materia.getEstado().equalsIgnoreCase("APROBADO")){
            aux = "GRADUACION";
        }
        if(this.grado<10 && this.materia.getEstado().equalsIgnoreCase("APROBADO")){
            aux = "GRADO A CURSAR " + Integer.toString(this.grado + 1);
        }
        if(this.grado<10 && this.materia.getEstado().equalsIgnoreCase("REPROBADO")){
            aux = "REPITE GRADO " + Integer.toString(grado);
        }
        if(this.grado<10 && this.materia.getEstado().equalsIgnoreCase("EXAMEN")){
            aux = "POSIBLE GRADO " + Integer.toString(grado + 1) + " SI APRUEBA EXAMEN";
        }
        
        return aux;
    }
    
    //Metodo que prepara la informacion del alumno para mostrarla por pantalla
    public String toString(){
        
        String materiaAux = this.materia.getNombre();
        if(isGraduado()==true){
            materiaAux = "GRADUACION";
        }
        String aux = "Nombre: " + this.nombre + "\n" + 
                     "Materia: " + materiaAux + " - " + this.materia.getEstado() + "\n" +
                     "Nota final: " + this.materia.getNotaFinal() + "\n" +
                     "Estado del alumno: " + this.getEstado() + "\n";
                     
        
        return aux;
        
    }
    
    
}//Fin Alumno
