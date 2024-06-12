import java.util.Scanner;
import java.io.IOException;
/**
 * Clase ColaDePrioridad: Implementa una cola de prioridad utilizando tres colas internas para
 * manejar diferentes niveles de prioridad (alta, media y baja).
 *
 * @param <TipoDeDato> el tipo de datos almacenado en la cola de prioridad
 *@author Marcos Ortiz (marcos.ram.ort@gmail.com)
 */
public class ColaDePrioridad<TipoDeDato> {
	//Colas internas para cada nivel de prioridad
	private Cola<TipoDeDato> prioridadAlta = new Cola<>();
	private Cola<TipoDeDato> prioridadMedia = new Cola<>();
	private Cola<TipoDeDato> prioridadBaja = new Cola<>();
	// Contadores para el número de elementos atendidos por cada nivel de prioridad
	private int altaAtendidos = 0;
	private int mediaAtendidos = 0;
	private int bajaAtendidos = 0;

	/**
	 * Método para encolar un nuevo dato en la cola de prioridad correspondiente.
	 *
	 * @param nuevoDato el dato a ser encolado
	 * @param prioridad la prioridad del dato (1 para alta, 2 para media, 3 para baja)
	 */
	public void encolar(TipoDeDato nuevoDato, String prioridad) {
		if (prioridad.equals("1")) {
			prioridadAlta.encolar(nuevoDato);
		} else if (prioridad.equals("2")) {
			prioridadMedia.encolar(nuevoDato);
		} else if (prioridad.equals("3")) {
			prioridadBaja.encolar(nuevoDato);
		} else {
			System.out.println("Prioridad no válida.");
		}
	}

	/**
	 * Método para validar el nombre del cliente ingresado.
	 *
	 * @param nombre el nombre a validar
	 * @param scanner el objeto Scanner para leer la entrada del usuario
	 * @return el nombre validado, o null si se alcanzaron demasiados intentos fallidos
	 */
	private String validarNombre(String nombre, Scanner scanner) {
		int invalidNameCount = 0;

		while ((!nombre.matches("[a-zA-Z]+") || nombre.isEmpty()) && invalidNameCount < 3) {
			if (nombre.isEmpty()) {
				System.out.println("Error: El nombre no puede estar vacío.");
			} else {
				System.out.println("Error: El nombre solo puede contener letras.");
			}
			System.out.print("Ingrese el nombre del cliente nuevamente: ");
			nombre = scanner.nextLine();
			invalidNameCount++;
		}

		if (invalidNameCount == 3 && (!nombre.matches("[a-zA-Z]+") || nombre.isEmpty())) {
			System.out.println("Demasiados intentos fallidos. Volviendo al menú principal.");
			return null;
		}

		return nombre;
	}
	/**
	 * Método para validar la prioridad ingresada.
	 *
	 * @param prioridad la prioridad a validar
	 * @param scanner el objeto Scanner para leer la entrada del usuario
	 * @return la prioridad validada, o null si se alcanzaron demasiados intentos fallidos
	 */
	private String validarPrioridad(String prioridad, Scanner scanner) {
		int invalidPriorityCount = 0;

		while (!prioridad.matches("[123]") && invalidPriorityCount < 3) {
			System.out.println("Error: La prioridad debe ser 1, 2 o 3.");
			System.out.print("Ingrese la prioridad nuevamente: ");
			prioridad = scanner.nextLine().toUpperCase();
			invalidPriorityCount++;
		}

		if (invalidPriorityCount == 3 && !prioridad.matches("[123]")) {
			System.out.println("Demasiados intentos fallidos. Volviendo al menú principal.");
			return null;
		}

		return prioridad;
	}

	/**
	 * Método para desencolar el siguiente dato de acuerdo a la prioridad.
	 *
	 * @return el siguiente dato en la cola de prioridad, o null si todas las colas están vacías
	 */
	public TipoDeDato desencolar() {
		// Verificar si todas las colas están vacías
		if (prioridadAlta.esVacia() && prioridadMedia.esVacia() && prioridadBaja.esVacia()) {
			System.out.println("No existen clientes por ser atendidos.");
			return null;
		}

		TipoDeDato ret;

		// Desencolar de acuerdo a las prioridades y la política de atención
		if (altaAtendidos < 3 && !prioridadAlta.esVacia()) {
			ret = prioridadAlta.desencolar();
			altaAtendidos++;
		} else if (mediaAtendidos < 2 && !prioridadMedia.esVacia()) {
			ret = prioridadMedia.desencolar();
			mediaAtendidos++;
		} else if (bajaAtendidos < 1 && !prioridadBaja.esVacia()) {
			ret = prioridadBaja.desencolar();
			bajaAtendidos++;
		} else {
			// Reiniciar contadores y volver a intentar
			altaAtendidos = 0;
			mediaAtendidos = 0;
			bajaAtendidos = 0;
			return desencolar();
		}
		// Retornar el dato si no es nulo
		if (ret != null) {
			return ret;
		}

		// Si las colas específicas están vacías, desencolar de la siguiente disponible
		if (!prioridadAlta.esVacia()) {
			return prioridadAlta.desencolar();
		} else if (!prioridadMedia.esVacia()) {
			return prioridadMedia.desencolar();
		} else {
			return prioridadBaja.desencolar();
		}
	}
	/**
	 * Método para mostrar el contenido de todas las colas de prioridad.
	 */
	public void mostrarCola() {
		System.out.println("Cola de espera:");
		int numeroCliente = 1;
		numeroCliente = mostrarCola(prioridadAlta, "1", numeroCliente);
		numeroCliente = mostrarCola(prioridadMedia, "2", numeroCliente);
		mostrarCola(prioridadBaja, "3", numeroCliente);
	}
	/**
	 * Método auxiliar para mostrar el contenido de una cola específica.
	 *
	 * @param cola la cola a mostrar
	 * @param prioridad la prioridad de la cola
	 * @param numeroCliente el número del cliente actual
	 * @return el número del cliente actualizado
	 */
	private int mostrarCola(Cola<TipoDeDato> cola, String prioridad, int numeroCliente) {
		Cola<TipoDeDato> temp = new Cola<>();
		while (!cola.esVacia()) {
			TipoDeDato dato = cola.desencolar();
			System.out.println(numeroCliente + ". " + dato + " (Prioridad " + prioridad + ")");
			temp.encolar(dato);
			numeroCliente++;
		}
		while (!temp.esVacia()) {
			cola.encolar(temp.desencolar());
		}
		return numeroCliente;
	}

	/**
	 * Método para limpiar la pantalla de la consola.
	 */
	public void limpiarPantalla() {
		try {
			if (System.getProperty("os.name").contains("Windows")) {
				new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			} else {
				new ProcessBuilder("bash", "-c", "clear").inheritIO().start().waitFor();
			}
		} catch (IOException | InterruptedException e) {
			System.out.println("Error al limpiar la pantalla: " + e.getMessage());
		}
	}



	/**
	 * Método principal para ejecutar el programa de cola de prioridad.
	 *
	 * @param args argumentos de la línea de comandos.
	 */
	public static void main(String[] args) {
		ColaDePrioridad<String> cola = new ColaDePrioridad<>();
		Scanner scanner = new Scanner(System.in);
		boolean salir = false;

		while (!salir) {
			cola.limpiarPantalla();
			System.out.print("----------------------------------------");
			System.out.print("\n	Seleccione una opción: ");
			System.out.println("\n=============== Menú ===============");
			System.out.println("1. Añadir un nuevo cliente");
			System.out.println("2. Atender al siguiente cliente");
			System.out.println("3. Mostrar lista de clientes en espera");
			System.out.println("4. Salir");
			String opcion = scanner.nextLine();

			if (!opcion.matches("[1-4]")) {
				System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
				continue;
			}

			switch (opcion) {
				case "1":
					cola.limpiarPantalla();
					System.out.print("Ingrese el nombre del cliente: ");
					String nombre = cola.validarNombre(scanner.nextLine(), scanner);
					if (nombre == null) break;

					System.out.print("Ingrese la prioridad (1 para ALTA, 2 para MEDIA, 3 para BAJA): ");
					String prioridad = cola.validarPrioridad(scanner.nextLine().toUpperCase(), scanner);
					if (prioridad == null) break;

					cola.encolar(nombre, prioridad);
					System.out.println("Cliente " + nombre + " agregado con prioridad " + prioridad + ".");
					break;
				case "2":
					cola.limpiarPantalla();
					System.out.println("Cliente atendido: " + cola.desencolar());
					break;
				case "3":
					cola.limpiarPantalla();
					cola.mostrarCola();
					break;
				case "4":
					salir = true;
					break;
			}
		}

		scanner.close();
	}
}
