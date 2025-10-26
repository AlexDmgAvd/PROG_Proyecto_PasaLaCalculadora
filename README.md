# PROG_Proyecto_PasaLaCalculadora
Primer proyecto de programación 
Este juego funcionará de la siguiente manera:
Al iniciar el juego el sistema nos pedirá que introduzcamos el numero máximo que
marcará el final del juego, el número ha de ser mayor que 10 y menor que 99. Si el
usuario introduce un número no valido el sistema le comunicará su error y se lo pedirá
otra vez.
Además, si el usuario introduce un -1 el número se generará aleatoriamente dentro del
rango mencionado anteriormente.
Una vez establecido el objetivo del juego se comenzará la partida.
El jugador que tenga el turno introducirá un numero del 1 al 9.
Si es el 1º número introducido en el juego se aceptará automáticamente.
Si no es el 1º numero introducido, el número deberá estar en la misma fila o columna
que el ultimo introducido, pero no ser el mismo.
Cuando el número sea valido se sumará al total y se comprobará si el igual o mayor que
el objetivo del juego, si sucede el jugador que igualo o supero el número será el
perdedor.

Ejemplo:
1º turno
Objetivo del juego 16
Ultimo numero introducido = ?
Turno = J1
Total = 0
J1 selecciona 5
2º turno
Objetivo del juego 16
Último número introducido = 5
Turno = J2
Total = 5
J2 selecciona 4 (es válido porque está en la misma fila que 5 en una calculadora)
3º turno
Objetivo del juego 16
Último número introducido = 4
Turno = J1
Total = 9
J1 selecciona 8 (es válido porque está en la misma columna que 4 en una calculadora)
4º turno
Objetivo del juego 16
Último número introducido = 8
Turno = J2
Total = 17
J2 ha ganado, el total es mayor que el objetivo del juego
