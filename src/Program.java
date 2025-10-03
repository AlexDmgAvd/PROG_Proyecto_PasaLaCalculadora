import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        // numero máximo que marcará el final del juego, el número ha de ser mayor que 10 y menor que 99.

        System.out.println("Bienvenido, Dame un número entre 10 y 99 para iniciar el juego.");
        System.out.println("Si quieres cualquier número, escribe -1 en la consola por favor.");

        // aqui ya se ha elegido el numero y empieza la partida a partir de aqui

        System.out.println("Introduce un numero:");

        int numeroDePartida = pedirNumeroUsuario();

        System.out.println("Has elegido el numero:" + numeroDePartida);

        //Se crean los dos jugadores

        String Jugador1;
        String Jugador2;

        System.out.println("Jugador 1 introduzca un número del 1 al 9");

        int primerNumeroJugador1 = pedirNumeroDel1Al9();


    }

    // funcion introducir numero tope para el juego

    private static int pedirNumeroUsuario() {

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
                return pedirNumeroUsuario();
            }


        }
        return numeroDeUsuario;


    }

    //Preguntamos el número del 1 al 9 para empezar

    private static int pedirNumeroDel1Al9() {

        Scanner sc = new Scanner(System.in);
        int numero1Al9 = sc.nextInt();

        while (true) {
            if (numero1Al9 >= 1 && numero1Al9 <= 9) {
                System.out.println("Jugador1 " + "has introducido el número" + numero1Al9);
                break;
            } else {
                System.err.println("El número introducido no es válido");
                return pedirNumeroDel1Al9();
            }
        }
        return numero1Al9;
    }

//    Vamos a crear la condición de que el resto de números deben de estar en la msima fila y columna

    private static int pedirNumerosJuego() {

        System.out.println("Introduzca un número que esté en la misma fila o columna que el anterior número");
        Scanner sc = new Scanner(System.in);
        int numeroFilaColumna = sc.nextInt();

        while (true) {
            int numeroPedido = pedirNumeroDel1Al9();
            if (numeroPedido == 1){

            }
        }


    }
}
