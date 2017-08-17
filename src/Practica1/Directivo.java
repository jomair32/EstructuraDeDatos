package Practica1;

public class Directivo extends Planta implements Administrativo{

	private double bonoExtra; 

	public Directivo( String nombre, String apellido, int antiguedad, boolean[] prestaciones, double pagoSemanal, double bono, String nombrePuesto) {
		super( nombre, apellido, antiguedad, pagoSemanal, prestaciones);  
		setBono(bono);
		setNombrePuesto(nombrePuesto);
	}
   
   
	public void setBono( double bono ) { 
		/*
		 * TODO: 
		 * M�todo que actualiza el atributo de instancia bonoExtra.
		 * Validar que el bono que se recibe de par�metro est� en el rango de 0 y BONO_MAXIMO (que se encuentra en la interfaz).
		 * De lo contrario se le asigna 0.
		 */
            if(bono<0 || bono>Administrativo.BONO_MAXIMO){
                this.bonoExtra=0;}
            else{
                this.bonoExtra=bono;
            }
	}
   
   
        @Override
	public double sueldo() { 
		/*
		 * TODO:
		 * Calcula el sueldo de un Directivo de la siguiente manera:
		 * Invocar al m�todo sueldo del padre y sumarle el bonoExtra.
		 */
                return super.sueldo()+this.bonoExtra;
		
	}
   
        @Override
   public String administrar() {
	   return "Administra los recursos de su departamento";
   }
   
        @Override
   public String definirAumentos() {
	   return "Define los aumentos de sueldo de sus empleados";
   }
   
        @Override
   public String reportarLogros() {
	   return "Reporta los logros de su departamento";
   }
   
        @Override
   	public void setNombrePuesto(String nombre){
		this.nombrePuesto = nombre;
	}
	
   
        @Override
    public String toString() {
		return "\n\n***  Directivo  ***\n" + super.toString() + "\nCon bono extra de: " + this.bonoExtra;
	}
}