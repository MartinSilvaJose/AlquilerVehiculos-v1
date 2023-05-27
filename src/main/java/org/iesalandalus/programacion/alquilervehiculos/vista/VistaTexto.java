package org.iesalandalus.programacion.alquilervehiculos.vista;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Alquiler;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Vehiculo;

public class VistaTexto extends Vista {	
	
	//CONSTRUCTOR
	public VistaTexto() {
		
	}
	
	//	COMENZAR Y TERMINAR
	public void comenzar() {
		Consola.mostrarCabecera("Programa de administración de alquileres");
		Consola.mostrarMenu();
		ejecutar(Consola.elegirOpcion());
	}
	public void terminar() {
		System.out.println("Hasta la próxima.");
	}
	
	
	//	EJECUTAR	
	protected void ejecutar(Accion opcion) {
		switch(opcion) {
		case SALIR:
			terminar();
			System.exit(0);
			break;
		case INSERTAR_CLIENTE:
			insertarCliente();
			comenzar();
			break;
		case INSERTAR_VEHICULO:
			insertarVehiculo();
			comenzar();
			break;
		case INSERTAR_ALQUILER:
			insertarAlquiler();
			comenzar();
			break;
		case BUSCAR_CLIENTE:
			buscarCliente();
			comenzar();
			break;
		case BUSCAR_VEHICULO:
			buscarVehiculo();
			comenzar();
			break;
		case BUSCAR_ALQUILER:
			buscarAlquiler();
			comenzar();
			break;
		case MODIFICAR_CLIENTE:
			modificarCliente();
			comenzar();
			break;
		case DEVOLVER_ALQUILER:
			devolverAlquiler();
			comenzar();
			break;
		case BORRAR_CLIENTE:
			borrarCliente();
			comenzar();
			break;
		case BORRAR_VEHICULO:
			borrarVehiculo();
			comenzar();
			break;
		case BORRAR_ALQUILER:
			borrarAlquiler();
			comenzar();
			break;
		case LISTAR_CLIENTES:
			listarClientes();
			comenzar();
			break;
		case LISTAR_VEHICULO:
			listarVehiculos();
			comenzar();
			break;
		case LISTAR_ALQUILERES:
			listarAlquileres();
			comenzar();
			break;
		case LISTAR_ALQUILERES_CLIENTE:
			listarAlquileresCliente();
			comenzar();
			break;
		case LISTAR_ALQUILERES_VEHICULO:
			listarAlquileresVehiculo();
			comenzar();
			break;
		}
				
	}
	
	
	//	INSERTAR 
	protected void insertarCliente() {
		Consola.mostrarCabecera("Insertar cliente");
		try {
			controlador.insertar(Consola.leerCliente());
		} catch (IllegalArgumentException | NullPointerException e) {
			System.out.println(e.getMessage());
		} catch (OperationNotSupportedException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("Operación realizada con éxito");

	}
	protected void insertarVehiculo() {
		Consola.mostrarCabecera("Insertar Vehiculo");
		try {
			controlador.insertar(Consola.leerVehiculo());
		} catch (IllegalArgumentException | NullPointerException e) {
			System.out.println(e.getMessage());
		} catch (OperationNotSupportedException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("Operación realizada con éxito");

	}
	protected void insertarAlquiler() {
		Consola.mostrarCabecera("Insertar alquiler");
		try {
			controlador.insertar(Consola.leerAlquiler());
			System.out.println("Operación realizada con éxito");
		} catch (IllegalArgumentException | NullPointerException e) {
			System.out.println(e.getMessage());
		} catch (OperationNotSupportedException e) {
			System.out.println(e.getMessage());
		}


	}
	
	//	BUSCAR
	protected void buscarCliente() {
		Consola.mostrarCabecera("Buscar cliente");
		Cliente cliente=controlador.buscar(Consola.leerClienteDni());
		if(cliente==null) {
			System.out.println("ERROR:El cliente que busca no existe");
		}
		else {
			System.out.println(cliente);
		}
		System.out.println("Operación realizada con éxito");

	}
	protected void buscarVehiculo() {
		Consola.mostrarCabecera("Buscar vehiculo");
		Vehiculo vehiculo=controlador.buscar(Consola.leerVehiculoMatricula());
		if(vehiculo==null) {
			System.out.println("ERROR:El turismo que busca no existe");
		}
		else {
			System.out.println(vehiculo);

		}
		System.out.println("Operación realizada con éxito");

	}
	protected void buscarAlquiler() {
		Consola.mostrarCabecera("Buscar alquiler");
		Alquiler alquiler=controlador.buscar(Consola.leerAlquiler());
		if(alquiler==null) {
			System.out.println("ERROR:El Alquiler que busca no existe");
		}
		else {
			System.out.println(alquiler);
		}
		System.out.println("Operación realizada con éxito");
	}
	
	
	//	MODIFICAR Y DEVOLVER
	protected void modificarCliente() {
		Consola.mostrarCabecera("Modificar cliente");
		try {
			Cliente cliente=controlador.buscar(Consola.leerClienteDni());
			controlador.modificar(cliente,Consola.leerNombre(),Consola.leerTelefono());
		} catch (IllegalArgumentException | NullPointerException e) {
			System.out.println(e.getMessage());
		} catch (OperationNotSupportedException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("Operación realizada con éxito");
	}
	protected void devolverAlquiler() {
		Consola.mostrarCabecera("Devolver alquiler");
		try {
			controlador.devolver(Consola.leerAlquiler(),Consola.leerFechaDevolucion());
		} catch (IllegalArgumentException | NullPointerException e) {
			System.out.println(e.getMessage());
		} catch (OperationNotSupportedException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("Operación realizada con éxito");
	}
	
	
	//	BORRAR
	protected void borrarCliente() {
		Consola.mostrarCabecera("Borrar cliente");
		try {
			controlador.borrar(controlador.buscar(Consola.leerClienteDni()));
		} catch (IllegalArgumentException | NullPointerException e) {
			System.out.println(e.getMessage());
		} catch (OperationNotSupportedException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("Operación realizada con éxito");

	}
	protected void borrarVehiculo() {
		Consola.mostrarCabecera("Borrar vehiculo");
		try {
			controlador.borrar(controlador.buscar(Consola.leerVehiculoMatricula()));
		} catch (IllegalArgumentException | NullPointerException e) {
			System.out.println(e.getMessage());
		} catch (OperationNotSupportedException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("Operación realizada con éxito");

	}
	protected void borrarAlquiler() {
		Consola.mostrarCabecera("Borrar alquiler");
		try {
			controlador.borrar(Consola.leerAlquiler());
		} catch (IllegalArgumentException | NullPointerException e) {
			System.out.println(e.getMessage());
		} catch (OperationNotSupportedException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("Operación realizada con éxito");
	}
	
	
	//	LISTAR
	protected void listarClientes() {
		Consola.mostrarCabecera("Listar clientes");
		List<Cliente> clientes=new ArrayList<>(controlador.getClientes());
		clientes.sort(Comparator.comparing(Cliente::getNombre).thenComparing(Cliente::getDni));
		
		if(clientes.size()==0) {
			System.out.println("No hay clientes que mostrar");
		}
		else {
			for(Cliente cliente:clientes) {
				
				System.out.println(cliente);
			}
		}
		System.out.println("Operación realizada con éxito");

	}
	protected void listarVehiculos() {
		Consola.mostrarCabecera("Listar vehiculos");
		List<Vehiculo> vehiculos=new ArrayList<>(controlador.getVehiculo());
		vehiculos.sort(Comparator.comparing(Vehiculo::getMarca).thenComparing(Vehiculo::getModelo).thenComparing(Vehiculo::getMatricula));
		
		if(vehiculos.size()==0) {
			System.out.println("No hay vehiculos que mostrar");
		}
		else {
			for(Vehiculo vehiculo:vehiculos) {
				
				System.out.println(vehiculo);
			}
		}
		System.out.println("Operación realizada con éxito");
	}
	protected void listarAlquileres() {
			Consola.mostrarCabecera("Listar alquileres");
				
			List<Alquiler> alquileres=new ArrayList<>(controlador.getAlquileres());
			Comparator<Cliente> comparadorCliente = Comparator.comparing(Cliente::getNombre).thenComparing(Cliente::getDni);
			alquileres.sort(Comparator.comparing(Alquiler::getFechaAlquiler).thenComparing(Alquiler::getCliente, comparadorCliente));
				
			if (alquileres.size()==0)
				System.out.println("No hay alquileres que mostrar.");
			else
			{
				for(Alquiler alquiler:alquileres)
				{
					System.out.println(alquiler);
				}
			}
			System.out.println("Operación realizada con éxito");
	}
	
	
	//	LISTAR CON PARAMETROS
	protected void listarAlquileresCliente() {
		Consola.mostrarCabecera("Listar alquileres por clientes");
		try {
			controlador.getAlquileres(Consola.leerClienteDni());
		} catch (NullPointerException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("Operación realizada con éxito");
	}
	protected void listarAlquileresVehiculo() {
		Consola.mostrarCabecera("Listar alquileres por vehiculo");
		try {
			controlador.getAlquileres(Consola.leerVehiculoMatricula());
		} catch (NullPointerException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("Operación realizada con éxito");
	}
}
