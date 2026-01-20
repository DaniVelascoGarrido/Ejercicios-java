package simples;

public class Carta {
    public int numero;
    public String palo;

    public Carta(int numero, String palo) {
        this.numero = numero;
        this.palo = palo;
    }

    public void imprimir() {
        int cantidadGuiones = String.valueOf(numero).length() + palo.length() + 3;
        String carta =
            "+" + "-".repeat(cantidadGuiones) + "+\n"
            + "| " + numero + " " + palo + " |\n"
            + "+" + "-".repeat(cantidadGuiones) + "+";

        System.out.println(carta);
    }

}
