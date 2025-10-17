import java.util.Random;

public class GiocaNumeri {

    public static void main(String[] args) throws Exception {
        System.out.println("=== Inizia gioco ===");

        // Generazione dei 3 numeri segreti
        Random rnd = new Random();
        Giocatore.numeriGenerati = new int[3];
        for (int i = 0; i < 3; i++) {
            Giocatore.numeriGenerati[i] = rnd.nextInt(10) + 1;
        }

        System.out.print("Numeri segreti (debug): ");
        for (int n : Giocatore.numeriGenerati) {
            System.out.print(n + " ");
        }
        System.out.println("\n");

        // Creazione giocatori
        Giocatore g1 = new Giocatore("Mario");
        Giocatore g2 = new Giocatore("Bros");

        g1.start();
        g2.start();

        g1.join();
        g2.join();

        // Gestione del risultato finale
        GestioneGioco gestione = new GestioneGioco();
        gestione.determinaVincitore(g1, g2);
    }
}
