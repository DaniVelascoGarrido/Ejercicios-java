
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Ejercicio5_5BuscaMInas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[][] matriz = new int[8][8];
        int usuarioColumna = 0, usuarioFila = 0;
        Boolean flag = true;
        Random rand = new Random();
        String Ubicacion = "";
        String[] arrayUbicacion;
        char[][] matrizChar = new char[8][8];

        //Pasamos por cada columna
        for(int i = 0; i < matriz.length;i++){ 

            //Pasamos por cada posicion de las filas
            for( int y = 0; y < matriz[i].length; y++){ 
                //Rellenamos la matriz que se mostrara con X
                matrizChar[i][y] ='x'; 
                //Rellenamos con 0 y 1 para meterle minas
                matriz[i][y] = rand.nextInt(0,2); 
            }
        }

        do {
            //Mostramos la matriz (el tablero)
            for(int i = 0; i < matrizChar.length;i++){
                System.out.println(Arrays.toString(matrizChar[i])); 
            }

            //Preguntamos que casilla busca
            System.out.println("Que casilla buscas"); 
            
            //Preguntamos la columna y guardamos el valor
            System.out.print("Nº columna(0-7): "); 
            usuarioColumna = sc.nextInt();
            sc.nextLine();

             //Preguntamos la fila y guardamos el valor
            System.out.print("Nº fila(0-7): ");
            usuarioFila = sc.nextInt();
            sc.nextLine();
            System.out.println();
            
            // Si la posicion dicha es 1 pisa una mina y pierde
            if (matriz[usuarioColumna][usuarioFila] == 1){ 

                // Se pone la bandera(falg) en false para que se acabe el bucle
                flag = false; 
                System.out.println("Pisaste una mina perdiste");
            } else { //Si es 0 no pisa niguna mina y sigue vivo 

                // Ponemos un O en la ubicacion puesta para que se diferencien las posiciones no visitadas (X) con las visitadas (O)
                matrizChar[usuarioFila][usuarioColumna] = 'O'; 
                //Guardamos la ubicaion añadida
                Ubicacion += usuarioColumna +":"+ usuarioFila + ","; 
                //La ubicacion añadida lo guardamos en un array para despues enseñarlo
                arrayUbicacion = Ubicacion.split(","); 

                System.out.println("No has pisado ninguna mina");
                
                //Le mostramos que ubicaciones ya visito
                System.out.println("Has visitado estas ubicaciones: "+ Arrays.toString(arrayUbicacion)); //Se enseña el numero de columnas por las que a pasado
           
                System.out.println();
            }
        } while (flag); // Si la bandera (flag) es true seguimos jugando 
        sc.close();

    }
}
