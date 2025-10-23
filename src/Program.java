import java.util.Scanner;

public class Program {
    public static void main() {

        int numeroTotal = 0;
        System.out.println("Bienvenido a PASA LA CALCULADORA");
        System.out.println("Por favor, introduce un número del 10 al 99");
        System.out.println("Si quieres un número aleatorio, introduce: -1");

        int numeroObjetivo = pedirNumeroObjetivo();
        System.out.println("El número objetivo de la partida es: " + numeroObjetivo);
        System.out.println("Comienza el juego");

        int numJugadorActual = 1;
        System.out.println("Jugador " + numJugadorActual + ", inserta un número del 1 al 9");

        int numeroDel1Al9 = pedirNumeroDel1Al9();
        numeroTotal = sumarLosResultados(numeroTotal, numeroDel1Al9);
        int numAnterior = numeroDel1Al9;

        while (true) {
            if (numeroTotal >= numeroObjetivo) {
                break;
            }

            // Cambiar de turno
            numJugadorActual = cambiarTurno2Jugadores(numJugadorActual);
            System.out.println("Turno de jugador " + numJugadorActual + ":");

            int numeroJugador = pedirNuevoNumValid(numAnterior);
            numAnterior = numeroJugador;

            numeroTotal = sumarLosResultados(numeroTotal, numeroJugador);
            System.out.println("Jugador " + numJugadorActual + " ha introducido el número: " + numeroJugador);
            System.out.println("Total actual: " + numeroTotal + " | Objetivo: " + numeroObjetivo);
        }

        System.out.println("¡El jugador " + numJugadorActual + " ha ganado!");

        System.out.println("¿Quieres jugar otra partida? (Si/No)");
        boolean jugarOtra = reiniciarJuego();

        if (jugarOtra) {
            main();
        } else {
            System.out.println("Gracias por jugar. ¡Hasta la próxima!");
        }
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
            }
            System.err.println("Número inválido. Introduce uno entre 10 y 99, o -1:");
            return pedirNumeroObjetivo();
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

    // Aqui sumaremos los numeros validos por cada turno para calcular el total en cada turno.
    public static int sumarLosResultados(int numeroTotal, int nuevoNum) {

        return numeroTotal + nuevoNum;
    }

    // En esta funcion cambiamos el turno de los jugadores en el modo 2 Jugadores.
    public static int cambiarTurno2Jugadores(int jugador) {

        if (jugador == 1) {
            return 2;
        }
        if (jugador == 2) {
            return 1;
        } else {
            return -1;
        }
    }

    // En esta funcion cambiamos el turno de los jugadores en el modo 3 Jugadores.
    public static int cambiarTurno3Jugadores(int jugador) {

        if (jugador == 1) {
            return 2;
        }
        if (jugador == 2) {
            return 3;
        }
        if (jugador == 3) {
            return 1;
        } else {
            return -1;
        }
    }

    public static boolean EligirModoDeJuego(int cantidadDeJugadores) {

        return true;  // solo para poder subir a git
    }

    //En esta función creamos el bucle para reiniciar la partida
    public static boolean reiniciarJuego() {

        String respuesta = "Si";
        Scanner sc = new Scanner(System.in);
        String respuestaJugador = sc.next();

        if (respuesta.compareToIgnoreCase(respuestaJugador) == 0) {
            return true;
        }
        return false;

    }
    //Solo me falta hacer que si le das a "No" no se reinicie la partida
}
