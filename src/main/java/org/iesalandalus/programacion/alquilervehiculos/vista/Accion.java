package org.iesalandalus.programacion.alquilervehiculos.vista;

public enum Accion {
	SALIR("Salir"),
	INSERTAR_CLIENTE("Insertar cliente"),
	INSERTAR_VEHICULO("Insertar vehículo"),
	INSERTAR_ALQUILER("Insertar alquiler"),
	BUSCAR_CLIENTE("Buscar cliente"),
	BUSCAR_VEHICULO("Buscar vehículo"),
	BUSCAR_ALQUILER("Buscar alquiler"),
	MODIFICAR_CLIENTE("Modificar cliente"),
	DEVOLVER_ALQUILER("Devolver alquiler"),
	BORRAR_CLIENTE("Borrar cliente"),
	BORRAR_VEHICULO("Borrar vehículo"),
	BORRAR_ALQUILER("Borrar alquiler"),
	LISTAR_CLIENTES("Listar clientes"),
	LISTAR_VEHICULO("Listar vehículo"),
	LISTAR_ALQUILERES("Listar alquileres"),
	LISTAR_ALQUILERES_CLIENTE("Listar los alquileres de un cliente"),
	LISTAR_ALQUILERES_VEHICULO("Listar los alquileres de un vehículo");
	
	private String texto;
	

	private Accion(String texto) {
		this.texto=texto;
	}
	
	private static boolean esOrdinalValido(int ordinal) {
		if(ordinal<values().length || ordinal>=0) {
			return true;
		}
		return false;		
	}
	
	public static Accion get(int ordinal) {
		if(esOrdinalValido(ordinal)==false) {
			throw new IllegalArgumentException("ERROR: El ordinal introducido no es válido.");
		}
		return values()[ordinal];
	}
	
	public String toString() {
		return String.format("%d.- %s.", ordinal(),texto);

	}
}
