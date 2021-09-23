/*
 * 
 */
package clases;


public class Empleado extends Persona{
    
    //Declaracion de atributos
    private double sueldoBase;
    private double sueldoLiquido;
    private double horasTrabajadas;
    private double ISSS;
    private double AFP;
    private double renta;
    //Constantes
    public final double PORCENTAJE_ISSS = 5.25;
    public final double PORCENTAJE_AFP = 6.88;
    public final double PORCENTAJE_RENTA = 10;
    public final double VALOR_HORA_1 = 9.75;
    public final double VALOR_HORA_2 = 11.5;
    
    //Constructor
    public Empleado(String n, String a, String c, double h) {
        super(n, a, c);
        this.horasTrabajadas = h;
        
    }
    
    //Metodos get y set
    public void setSueldoBase(double s){
        this.sueldoBase = s;
    }
    
    public double getSueldoBase(){
        return this.sueldoBase;
    }
    
    public void setHorasTrabajadas(double h){
        this.horasTrabajadas = h;
    }
    
    public double getHorasTrabajadas(){
        return this.horasTrabajadas;
    }
    
    public void setSueldoLiquido(double s){
        this.sueldoLiquido = s;
    }
    
    public double getSueldoLiquido(){
        return this.sueldoLiquido;
    }
    
    //Devuelve la suma de las retenciones de acuerdo a su sueldo base
    public double getRetenciones(){
        return this.AFP + this.ISSS + this.renta;
    }
    
    
    
    
    
    //Metodo que cancula el sueldo base de un trabajador en base a su cantidad de horas trabajadas
    //segun indica el enunciado.
    public void calcularSueldoBase(){
        
        if(this.horasTrabajadas>160){
            this.sueldoBase = (this.horasTrabajadas - 160)*this.VALOR_HORA_2 + 160*this.VALOR_HORA_1;
        }
        else{
            this.sueldoBase = this.horasTrabajadas*this.VALOR_HORA_1;
        }
    }
    
    //Metodo que calcula las retenciones segun el sueldo base y los porcentajes especificados en el enunciado.
    public void calcularRetenciones(){
        this.AFP = this.sueldoBase*this.PORCENTAJE_AFP/100;
        this.ISSS = this.sueldoBase*this.PORCENTAJE_ISSS/100;
        this.renta = this.sueldoBase*this.PORCENTAJE_RENTA/100;
    }
    
    //Metodo que calcula el sueldo liquido descontando del sueldo base las retenciones indicadas en el enunciado
    public void calcularSueldoLiquido(){
        
        this.sueldoLiquido = this.sueldoBase - this.AFP - this.ISSS - this.renta;
        
    }
    
    //Metodo que prepara la informacion del empleado para ser mostrada por pantalla
    public String toString(){
        
        String aux = "Nombre: " + this.getNombre() + "\n" +
                     "Apellidos: " + this.getApellido() + "\n" +
                     "Sueldo base: $" + this.getSueldoBase() + "\n" +
                     "Retenciones: -$" + this.getRetenciones() + "\n" + "\n" +
                     "Sueldo líquido: $" + this.getSueldoLiquido() + "\n";
        
        return aux;
        
    }
   
    
}//Fin Empleado
