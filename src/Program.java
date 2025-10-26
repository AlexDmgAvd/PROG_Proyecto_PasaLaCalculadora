import java.util.Scanner;

public class Program {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        boolean volverAJugar = true;
        while (volverAJugar) {
            jugarPartida();

            volverAJugar = preguntarRepetir();
        }
        System.out.println("Gracias por jugar. ¡Hasta la próxima!");
    }

    public static void jugarPartida() {
        int numeroTotal = 0;

        System.out.println("Bienvenido a PASA LA CALCULADORA");
        System.out.println("Ingrese el numero de jugadores que jugaran (Minimo 2 / Maximo 3)");
        int numJugadores = preguntarPorJugadores();
        System.out.println("Introduce un número del 10 al 99 (o -1 para aleatorio):");
        int numeroObjetivo = pedirNumeroObjetivo();

        System.out.println("El número objetivo es: " + numeroObjetivo);
        int turnoJugador = 1;
        System.out.println("Jugador 1, elige un número del 1 al 9:");
        int numAnterior = pedirNumeroDel1Al9();
        numeroTotal += numAnterior;

        while (numeroTotal < numeroObjetivo) {
            turnoJugador = comprobarQuienJuega(turnoJugador , numJugadores);
            System.out.println("Turno del jugador " + turnoJugador + ":");
            int numero = pedirNuevoNumValid(numAnterior);
            numAnterior = numero;
            numeroTotal += numero;

            System.out.println("Jugador " + turnoJugador + " Eligio --> " + numero);
            System.out.println("Total actual: " + numeroTotal + " / Objetivo: " + numeroObjetivo);
        }

        System.out.println("¡El jugador " + turnoJugador + " ha ganado!");
    }

    // Preguntaremos por el numero de jugadores que jugaran en la partida.
    public static int preguntarPorJugadores() {
        int numeroJugadores;
        Scanner sc = new Scanner(System.in);
        numeroJugadores = sc.nextInt();

        while (numeroJugadores < 2 || numeroJugadores > 3) {
            System.out.println("Ingrese el numero de jugadores que jugaran (Minimo 2 / Maximo 3");
            numeroJugadores = sc.nextInt();
        }
        return numeroJugadores;
    }

    // Comprobamos si son 2 jugadores o 3 jugadores.
    public static int comprobarQuienJuega(int turnoJugador, int numJugadores ) {
        return (turnoJugador % numJugadores) + 1;


    }

    // Pedimos el numereo tope de la partida.
    public static int pedirNumeroObjetivo() {
        Scanner sc = new Scanner(System.in);
        int numeroDeUsuario = sc.nextInt();

        while (true) {
            if (numeroDeUsuario >= 10 && numeroDeUsuario <= 99) {
                break;
            }
            if (numeroDeUsuario == -1) {
                numeroDeUsuario = (int) (Math.random() * 90 + 10);
                break;
            } else {
                System.err.println("Número inválido. Introduce uno entre 10 y 99, o -1:");
                return pedirNumeroObjetivo();
            }
        }
        return numeroDeUsuario;
    }

    // Le pedimos al primer jugador un numero 1 al 9.
    public static int pedirNumeroDel1Al9() {
        Scanner sc = new Scanner(System.in);
        int numero = sc.nextInt();

        while (true) {
            if (numero >= 1 && numero <= 9) {
                System.out.println("Jugador 1 ha introducido el número: " + numero);
                break;
            } else {
                System.err.println("Número inválido. Introduce un número del 1 al 9:");
                numero = sc.nextInt();
            }
        }
        return numero;
    }

    // Aqui el programa comprobara que el numero introducido es valido.
    public static int pedirNuevoNumValid(int numeroAnterior) {
        Scanner sc = new Scanner(System.in);
        int nuevoNum = sc.nextInt();

        while (true) {
            if (validarFilasColumnas(nuevoNum, numeroAnterior)) {
                break;
            } else {
                System.err.println("Número inválido. Introduce otro:");
                nuevoNum = sc.nextInt();
            }
        }
        return nuevoNum;
    }

    // Vamos a crear la condición de que el resto de números deben de estar en la msima fila y columna.
    public static boolean validarFilasColumnas(int numeroJugador, int numeroAnterior) {

        //Si es el 1º turno, cualquier numero vale
        if (numeroAnterior == -1) {
            return true;
        }
        if (numeroJugador == 1) {

            if (numeroAnterior == 2 || numeroAnterior == 3 || numeroAnterior == 4 || numeroAnterior == 7) {
                return true;
            }
        }

        if (numeroJugador == 2) {

            if (numeroAnterior == 1 || numeroAnterior == 3 || numeroAnterior == 5 || numeroAnterior == 8) {
                return true;
            }
        }

        if (numeroJugador == 3) {

            if (numeroAnterior == 1 || numeroAnterior == 2 || numeroAnterior == 6 || numeroAnterior == 9) {
                return true;
            }
        }

        if (numeroJugador == 4) {

            if (numeroAnterior == 1 || numeroAnterior == 7 || numeroAnterior == 5 || numeroAnterior == 6) {
                return true;
            }
        }

        if (numeroJugador == 5) {

            if (numeroAnterior == 4 || numeroAnterior == 6 || numeroAnterior == 2 || numeroAnterior == 8) {
                return true;
            }
        }

        if (numeroJugador == 6) {

            if (numeroAnterior == 4 || numeroAnterior == 5 || numeroAnterior == 3 || numeroAnterior == 9) {
                return true;
            }
        }

        if (numeroJugador == 7) {

            if (numeroAnterior == 1 || numeroAnterior == 4 || numeroAnterior == 8 || numeroAnterior == 9) {
                return true;
            }
        }

        if (numeroJugador == 8) {

            if (numeroAnterior == 2 || numeroAnterior == 5 || numeroAnterior == 7 || numeroAnterior == 9) {
                return true;
            }
        }

        if (numeroJugador == 9) {

            if (numeroAnterior == 3 || numeroAnterior == 6 || numeroAnterior == 7 || numeroAnterior == 8) {
                return true;
            }
        }

        return false;

    }

    // En esta funcion vamos preguntaremos al usuario si quiere repetir la partida.
    public static boolean preguntarRepetir() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("¿Quieres jugar otra partida? (si/no)");
            String respuesta = sc.next().trim().toLowerCase();

            if (respuesta.equals("si")) return true;
            if (respuesta.equals("no")) return false;

            System.err.println("Respuesta inválida. Escribe 'si' o 'no'.");
        }
    }



}
