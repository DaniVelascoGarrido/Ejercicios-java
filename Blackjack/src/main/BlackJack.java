package main;

import simples.Carta;

import java.util.Random;
import java.util.Scanner;


public class BlackJack {
    public static void main(String[] args) {

        Random rnd = new Random();
        Carta[] cartas = new Carta[40];
        // Creamos la cartas
        //Espadas
        cartas[0] = new Carta(1, "🗡️");
        cartas[1] = new Carta(2, "🗡️");
        cartas[2] = new Carta(3, "🗡️");
        cartas[3] = new Carta(4, "🗡️");
        cartas[4] = new Carta(5, "🗡️");
        cartas[5] = new Carta(6, "🗡️");
        cartas[6] = new Carta(7, "🗡️");
        cartas[7] = new Carta(8, "🗡️");
        cartas[8] = new Carta(9, "🗡️");
        cartas[9] = new Carta(10, "🗡️");
        //Bastos
        cartas[10] = new Carta(1, "🪵");
        cartas[11] = new Carta(2, "🪵");
        cartas[12] = new Carta(3, "🪵");
        cartas[13] = new Carta(4, "🪵");
        cartas[14] = new Carta(5, "🪵");
        cartas[15] = new Carta(6, "🪵");
        cartas[16] = new Carta(7, "🪵");
        cartas[17] = new Carta(8, "🪵");
        cartas[18] = new Carta(9, "🪵");
        cartas[19] = new Carta(10, "🪵");
        //Oros
        cartas[20] = new Carta(1, "🪙");
        cartas[21] = new Carta(2, "🪙");
        cartas[22] = new Carta(3, "🪙");
        cartas[23] = new Carta(4, "🪙");
        cartas[24] = new Carta(5, "🪙");
        cartas[25] = new Carta(6, "🪙");
        cartas[26] = new Carta(7, "🪙");
        cartas[27] = new Carta(8, "🪙");
        cartas[28] = new Carta(9, "🪙");
        cartas[29] = new Carta(10, "🪙");
        //Copas
        cartas[30] = new Carta(1, "🏆");
        cartas[31] = new Carta(2, "🏆");
        cartas[32] = new Carta(3, "🏆");
        cartas[33] = new Carta(4, "🏆");
        cartas[34] = new Carta(5, "🏆");
        cartas[35] = new Carta(6, "🏆");
        cartas[36] = new Carta(7, "🏆");
        cartas[37] = new Carta(8, "🏆");
        cartas[38] = new Carta(9, "🏆");
        cartas[39] = new Carta(10, "🏆");

        Scanner sc = new Scanner(System.in);
        int usuario = 0, carta;
        String Salidas = "", sale;
        boolean cartaPedida;
        System.out.println("Este Blackjack esta echo sobre la braja española");
        
        //Da una carta aleatoria
        carta = rnd.nextInt(1, cartas.length);
        //Muestra las dos cartas que nos dan
        System.out.println("Tus dos cartas son : ");
        // Le sumamos el valor de esas carta al usuario 
        usuario = cartas[carta].numero;
        // Guardamos esa carta en un String para que no vuelca a salir
        Salidas += "" + carta; 

        // Mostramos carta
        cartas[carta].imprimir(); 
        //Nos da una carta aleatoria
        carta = rnd.nextInt(1, cartas.length);
        //La guardamos en carta que sale
        sale = "" + carta;
        //En el String Salidas vamos guardando todas las cartas, entonces si la que nos acaba de salir ya salio se cambia
        if (Salidas.contains(sale)) { 
            carta = rnd.nextInt(1, cartas.length);
            sale = "" + carta;
        }
        //Guardamos la nueva carta
        Salidas += sale;
        //Le sumamos al usuario la nueva carta
        usuario += cartas[carta].numero;
        //Enseñamos la segunda carta
        cartas[carta].imprimir();

        do {
            //Preguntamos al usuario si quiere una carta
            System.out.print("¿Quieres otra carta?(S/N)"); //Si quiere otra carta le damos otra carta sino salimos
            cartaPedida = sc.nextLine().toUpperCase().equals("S");
            
            //Si dijo que si damos una nueva carta, si dijo que no salimos de este bucle
            if (cartaPedida) { 
                //Carta aleatoria
                carta = rnd.nextInt(1, cartas.length);
                //La guardamos en sale
                sale = "" + carta;
                //Si ya salio la cambiamos
                if (Salidas.contains(sale)) {
                    carta = rnd.nextInt(1, cartas.length);
                    sale = "" + carta;
                }
                //Guardamos la carta salida
                Salidas += sale;
                System.out.println("Esta es tu otra carta:");
                cartas[carta].imprimir();
                //Enseñamos la carta
                usuario += cartas[carta].numero;
                //Le decimos cuanto lleva
                System.out.println("Levas: " + usuario);
                //En caso de que lleve mas de 21 pierde y se acaba
                if (usuario > 21) {
                    System.out.println("Has perdido: " + usuario);
                    cartaPedida = false;
                }
            }

        } while (cartaPedida);
        sc.close();
        
        //Si no perdemos vamos con el crupier
        if(usuario <= 21){

            //Ahora vamos con las cartas del crupier, que se mostra solo si haun no perdimos
            System.out.println("Estas son las cartas del crupier:");
        
        //Creamos una variable para el crupier donde se iran sumando el valor de sus cartas
        int crupier = 0;

        //Si el crupier tiene menos que el usuario y menos que 21 le damos otra carta al crupier
        while (usuario <= 21 && crupier < usuario && crupier < 21) { 
            
            //Le damos una carta aleatoria
            carta = rnd.nextInt(1, cartas.length);
            sale = "" + carta;
            //Si ya salio la cambiamos
                if (Salidas.contains(sale)) {
                    carta = rnd.nextInt(1, cartas.length);
                    sale = "" + carta;
                }
            //Guardamos la carta salida
            Salidas += sale;
            //Ensenamos la carta del crupier
            cartas[carta].imprimir();
            //Le sumamos esa carta al valor del crupier
            crupier += cartas[carta].numero;

            //Si el crupier supera 21 pierde y ganas tu
            if (crupier > 21){ 
                System.out.println("Has ganado el crupier paso de 21");
            }

        }

        //Si el crupier tiene menos que 21 o tiene 21 y tiene mas que tu pierdes
        if(crupier <= 21 && crupier > usuario){
            System.out.println("Perdiste, crupier: " + crupier + " tu: " + usuario);
        } else if( crupier == usuario){ //Si teneis la misma cantidad empatais
            System.out.println("Empataste, crupier: " + crupier + " tu: " + usuario);
        }
        }
          
    }
}

