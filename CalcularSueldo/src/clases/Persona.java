/*
 * 
 */
package clases;


public class Persona {
    
    private String nombre;
    private String apellido;
    private String cargo;
    
    
    //Constructor
    public Persona(String n, String a, String c){
        this.nombre = n; 
        this.apellido = a;
        this.cargo = c;
    }
    
    
    //Metodos get y set
    public void setNombre(String n){
        this.nombre = n;
    }
    
    public String getNombre(){
        return this.nombre;
    }
    
    public void setApellido(String a){
        this.apellido = a;
    }
    
    public String getApellido(){
        return this.apellido;
    }
    
    public void setCargo(String c){
        this.cargo = c;
    }
    
    public String getCargo(){
        return this.cargo;
    }
    
    
    
}//Fin Persona
