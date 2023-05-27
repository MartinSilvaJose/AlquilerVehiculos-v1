package org.iesalandalus.programacion.alquilervehiculos;

import org.iesalandalus.programacion.alquilervehiculos.controlador.Controlador;
import org.iesalandalus.programacion.alquilervehiculos.modelo.Modelo;
import org.iesalandalus.programacion.alquilervehiculos.modelo.ModeloCascada;
import org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.memoria.FuenteDatosMemoria;
import org.iesalandalus.programacion.alquilervehiculos.vista.Vista;
import org.iesalandalus.programacion.alquilervehiculos.vista.VistaTexto;

public class MainApp {
//	VERSION 1
	public static void main(String[] args) {
		Modelo modelo=new ModeloCascada(new FuenteDatosMemoria());
		Vista vista=new VistaTexto();
		Controlador controlador= new Controlador(modelo,vista);
		controlador.comenzar();
	}

}
