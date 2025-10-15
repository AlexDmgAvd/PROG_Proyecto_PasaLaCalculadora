import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        int numeroTotal = 0;
        System.out.println("Bienvenido a PASA LA CALCULADORA");
        System.out.println("Porfavor introduce un numero del 10 al 99");
        System.out.println("Si quieres un numero aleatorio, introduce: -1");

        int numeroObjetivo = pedirNumeroObjetivo();

        System.out.println("El numero objetivo de la partida es:" + numeroObjetivo);

        System.out.println("Comienza el juego");

        int numJugadorActual = 1;

        System.out.println("jugador" + numJugadorActual + " inserta un numero del 1 al 9");

        int numeroDel1Al9 = pedirNumeroDel1Al9();
        numeroTotal = sumarLosResultados(numeroTotal, numeroDel1Al9);
        int numAnterior = numeroDel1Al9;


        int numeroJugador;
        while (true){

            if (numeroTotal >= numeroObjetivo){
                break;
            }else {

                System.out.println("Turno de jugador " + esElTurnoDe(numJugadorActual) + ":");


                numeroJugador = pedirNuevoNumValid(numAnterior);
                numAnterior = numeroJugador;

                numeroTotal = sumarLosResultados(numeroTotal, numeroJugador);
                numeroJugador = numAnterior;

                System.out.println("jugador" + esElTurnoDe(numJugadorActual) + " has introducido el número: " + numeroJugador);
                System.out.println("Total Actual:" + numeroTotal + " Objetivo:" + numeroObjetivo);
            }


        }

        System.out.println("El" + esElTurnoDe(numJugadorActual) + "ha ganado");


    }


    // funcion introducir numero tope para el juego

    public static int pedirNumeroObjetivo() {

        //Le pedimos un numero entero al usuario o un numero ramdom (-1)

        Scanner sc = new Scanner(System.in);
        int numeroDeUsuario = sc.nextInt();

        // aqui hacemos un bucle para que si le da error vuelva a preguntarle el numero
        // Si introduce un numero valido se (break) rompe el bucle y continua el programa

        while (true) {

            if (numeroDeUsuario >= 10 && numeroDeUsuario < 99) {

                System.out.println("Comienza el juego");
                break;
            }

            if (numeroDeUsuario == -1) {

                numeroDeUsuario = (int) (Math.random() * 90 + 10);
                break;
            } else {
                System.err.println("numero invalido, porfavor introduce un numero valido (Debe ser entre 10 y 99, o -1)");
                return pedirNumeroObjetivo();
            }


        }
        return numeroDeUsuario;


    }

    //Preguntamos el número del 1 al 9 para empezar, solo devuelve numeros validos del 1 al 9

    public static int pedirNumeroDel1Al9() {

        Scanner sc = new Scanner(System.in);
        int numero1Al9 = sc.nextInt();

        while (true) {

            if (numero1Al9 >= 1 && numero1Al9 <= 9) {
                System.out.println("Jugador1 " + "has introducido el número: " + numero1Al9);
                break;
            } else {
                System.err.println("El número introducido no es válido");
                numero1Al9 = sc.nextInt();
            }
        }
        return numero1Al9;

    }

    public static int pedirNuevoNumValid(int numeroAnterior) {

        Scanner sc = new Scanner(System.in);
        int nuevoNum = sc.nextInt();

        while (true) {

            if (validarFilasColumnas(nuevoNum, numeroAnterior)) {
                break;
            } else {
                System.err.println("El número introducido no es válido");
                nuevoNum = sc.nextInt();
            }
        }
        return nuevoNum;

    }

//    Vamos a crear la condición de que el resto de números deben de estar en la msima fila y columna

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

    public static int sumarLosResultados(int numeroTotal, int nuevoNum ) {

        return numeroTotal + nuevoNum;
    }

    public static boolean esFinDeJuego(int numeroTotal, int numeroObjetivo) {
        return numeroTotal >= numeroObjetivo;
    }

    public static int esElTurnoDe(int jugador) {

        if (jugador == 1) {
            return 2;
        }
        if (jugador == 2) {
            return 1;
        }else {
            return -1;
        }
    }


}
