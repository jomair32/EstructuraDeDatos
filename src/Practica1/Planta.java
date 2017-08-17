package Practica1;

public abstract class Planta extends Empleado {

	protected double pagoSemanal;
	protected boolean[] prestaciones;
	protected double diaVacaciones;
	protected String nombrePuesto;
	
	private static final String [] PRESTACIONES = {"Vales despensa", "Afore", "Infonavit", "Vacaciones Semana Santa", 
				"Vacaciones Verano", "Descuento proveedores afiliados", "Seguro de auto", "Seguro de vida"}; 
	private static final double [] PAGO_PRESTACIONES = {1000, 0.2, 0.1, 7, 2, 0.25, 5000, 25000}; 				 
	private static final double PORCENTAJE_PLANTA = 0.1;			
	private static final int MAXIMO_SUELDO = 25000;
	
	

	public Planta( String nombre, String apellido, int antiguedad, double pagoSemanal, boolean[] prestaciones) {
		super(nombre, apellido, antiguedad);
                if (pagoSemanal>Planta.MAXIMO_SUELDO || pagoSemanal<0){
                    this.pagoSemanal=0;}
                else{
                    this.pagoSemanal=pagoSemanal;
                }
                this.prestaciones=prestaciones;
                this.diaVacaciones=this.pagoSemanal*this.antiguedad*Planta.PORCENTAJE_PLANTA;
		/*
		 * TODO: 
		 * Constructor de la clase Planta.
		 * 1. Inicializa el atributo  de instancia del arreglo de prestaciones con los valores
		 *    del arreglo de prestaciones que recibe de par�metro.
		 * 2. Valida que el atributo de instancia, pagoSemanal, se inicialice con un valor entre 0 y MAXIMO_SUELDO.
		 *    En caso contrario, se asigna 0.
		 * 3. El atributo de instancia, diaVacaciones, se inicializa con el pagoSemanal * antiguedad * PORCENTAJE_PLANTA. 
		 */
	}
   
   
    private String regresaPrestaciones() {
    	/*
    	 * TODO: 
    	 * M�todo privado que recorre el arreglo de instancia de prestaciones y si tiene un valor de true en la posici�n i,
    	 * entonces crea una cadena con el nombre de la prestaci�n correspondiente. Los nombres de las prestaciones est�n en
    	 * el arreglo est�tico PRESTACIONES, en la misma posici�n i. As�, si prestaciones[0] = true, entonces la prestaci�n
    	 * correspondiente es PRESTACIONES[0] (que es �Vales despensa�).
    	 */
        String a="";
        
    	for(int i=0; i<this.prestaciones.length;i++){
            if(this.prestaciones[i]==true){
                a=a+Planta.PRESTACIONES[i]+", ";
            }}
    	return a;
	}
	
	
	public double sueldo() { 
		/*
		 * TODO:
		 * Calcula el sueldo  de un empleado de Planta de la siguiente manera:
		 *    El sueldo inicial es el pagoSemanal.
		 * A ese sueldo se le agregan las prestaciones de la siguiente forma:
		 *    Si el arreglo de instancia de prestaciones tiene un valor de true en la posici�n i, donde i es:
		 *       0, 6, 7: sumarle al sueldo el PAGO_PRESTACIONES de la misma posici�n i
		 *       1, 2, 5: sumarle al sueldo el PAGO_PRESTACIONES de la misma posici�n i multiplicado por el pagoSemanal
		 *       3, 4: sumarle al sueldo el PAGO_PRESTACIONES de la misma posici�n i multiplicado por diaVacaciones
		 */
		double Sueldo=this.pagoSemanal;
                for(int i=0; i<this.prestaciones.length;i++){
                    if(this.prestaciones[i]==true){
                        if(i==0 || i==6 || i==7){
                    Sueldo=Sueldo+Planta.PAGO_PRESTACIONES[i];}
                        if(i==1 || i==2 || i==5){
                    Sueldo=Sueldo+(Planta.PAGO_PRESTACIONES[i]*this.pagoSemanal);}
                        if(i==3|| i==4){
                    Sueldo=Sueldo+(Planta.PAGO_PRESTACIONES[i]*this.diaVacaciones);}
            }}
		return Sueldo;
	}
	
    public void setPagoSemanal( double pagoSemanal ) { 
		if (pagoSemanal > 0 && pagoSemanal <= MAXIMO_SUELDO)
			this.pagoSemanal = pagoSemanal;
	}
   
   	public String toString() {
		return "\n***  Empleado de Planta  ***\n" + super.toString() + "\nCon puesto: " + this.getNombrePuesto() +
				"\nPago semanal: " + this.pagoSemanal + "\nSueldo integrado: " + this.sueldo() + "\nPrestaciones: " + this.regresaPrestaciones();
	}
	
	public String getNombrePuesto() {
		return this.nombrePuesto;
	}
	
	/*
	 * TODO:
	 * Crear m�todo p�blico abstracto de nombre setNombrePuesto.
	 * El m�todo no regresa nada.
	 * El m�todo recibe una cadena de caracteres con el nombre del puesto (nombrePuesto).
	 */
        public abstract void setNombrePuesto(String nombre);
        
}