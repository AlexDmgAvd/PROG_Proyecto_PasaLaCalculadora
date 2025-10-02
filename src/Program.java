import java.util.Scanner;

public class Program {
    static void main(String[] args) {

        // numero máximo que marcará el final del juego, el número ha de ser mayor que 10 y menor que 99.

        System.out.println("Bienvenido, Dame un número entre 10 y 99 para iniciar el juego.");
        System.out.println("Si quieres cualquier número, escribe -1 en la consola por favor.");

        // aqui ya se ha elegido el numero y empieza la partida a partir de aqui

        int numeroDePartida = pedirNumeroUsuario();

        System.out.println("Has elegido el numero:" + numeroDePartida);

    }

    // funcion introducir numero tope para el juego

    private static int pedirNumeroUsuario() {

        System.out.println("Introduce un numero:");

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
            }

            else {
                System.err.println("numero invalido, porfavor introduce un numero valido (Debe ser entre 10 y 99, o -1)");
            }


        }
        return numeroDeUsuario;


    }
}
