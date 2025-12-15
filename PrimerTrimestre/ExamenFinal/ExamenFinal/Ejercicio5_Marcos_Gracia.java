package Examen_Package;
import java.util.Scanner;

public class Ejercicio5_AjedrezSimplificado {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Tablero actual:");
		char[][] tablero = new char[8][8];
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				tablero[i][j] = '.';
			}
		}

		int caballo_fila = 0, caballo_columna = 1;
		int peon_fila = 6, peon_columna = 1;
		tablero[caballo_fila][caballo_columna] = 'C';
		tablero[peon_fila][peon_columna] = 'P';
		boolean salir = false;
		
		while (!salir) {
			System.out.println("    0 1 2 3 4 5 6 7");
			System.out.println("-------------------");
			for (int i = 0; i < 8; i++) {
				System.out.print(i + " | ");
				for (int j = 0; j < 8; j++) {
					System.out.print(tablero[i][j] + " ");
				}
				System.out.println();
			}
			System.out.println("-------------------");
			System.out.print("¿Qué pieza quieres mover? (caballo/peon/salir): ");
			String opcion = sc.next();
			if (opcion.equals("salir")) {
				salir = true;
				
			} else if (opcion.equals("caballo")) {
				int[][] movimientos = { { -2, -1 }, { -2, 1 }, { -1, -2 }, { -1, 2 }, { 1, -2 }, { 1, 2 }, { 2, -1 },
						{ 2, 1 } };
				int[][] validos = new int[8][2];
				int contador = 0;
				for (int i = 0; i < movimientos.length; i++) {
					int nueva_fila = caballo_fila + movimientos[i][0];
					int nueva_columna = caballo_columna + movimientos[i][1];
					if (nueva_fila >= 0 && nueva_fila < 8 && nueva_columna >= 0 && nueva_columna < 8
							&& tablero[nueva_fila][nueva_columna] == '.') {
						validos[contador][0] = nueva_fila;
						validos[contador][1] = nueva_columna;
						contador++;
					}
				}
				if (contador == 0) {
					System.out.println("No hay movimientos válidos.");
					continue;
				}
				System.out.println("Movimientos válidos del caballo:");
				for (int i = 0; i < contador; i++) {
					System.out.println("[" + i + "] (" + validos[i][0] + "," + validos[i][1] + ")");
				}
				System.out.print("Elige el índice del movimiento: ");
				int eleccion = sc.nextInt();
				tablero[caballo_fila][caballo_columna] = '.';
				caballo_fila = validos[eleccion][0];
				caballo_columna = validos[eleccion][1];
				tablero[caballo_fila][caballo_columna] = 'C';
			} else if (opcion.equals("peon")) {
				int nuevaFila = peon_fila - 1;
				if (nuevaFila >= 0 && tablero[nuevaFila][peon_columna] == '.') {
					int eleccion = 0;
					do {
						System.out.println("Movimientos válidos del peón:");
						System.out.println("[0] (" + nuevaFila + "," + peon_columna + ")");
						System.out.print("Elige el índice del movimiento: ");
						eleccion = sc.nextInt();
					} while (eleccion != 0);
					tablero[peon_fila][peon_columna] = '.';
					peon_fila = nuevaFila;
					tablero[peon_fila][peon_columna] = 'P';
				} else {
					System.out.println("El peón no puede moverse.");
				}
			}
			else {
				System.out.println("Opción no válida.");
			}
		}
		System.out.println("Fin del programa.");
		sc.close();
	}
}
