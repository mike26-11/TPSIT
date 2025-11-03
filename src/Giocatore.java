import java.util.Scanner;

public class Giocatore extends Thread {
    String nome;
    int punteggio;
    static int[] numeriGenerati; // numeri da indovinare
    static Scanner input = new Scanner(System.in); // Scanner unico condiviso

    public Giocatore(String nome){
        this.nome = nome;
    }

    private void comunica(){
        System.out.println("Sono il giocatore " + nome + " e ho iniziato il gioco!");
    }

    private void gioca() {
        synchronized (Giocatore.class) { // 🔒 solo un giocatore alla volta può inserire
            System.out.println("[" + nome + "] Inserisci un numero:");
            int num = input.nextInt();

            System.out.println("[" + nome + "] Ho scelto il numero " + num);

            verifica(num);
        }
    }

    // 🔹 Metodo per controllare se il numero è tra quelli generati
    private void verifica(int num) {
        boolean trovato = false;
        for (int n : numeriGenerati) {
            if (num == n) {
                trovato = true;
                break;
            }
        }

        if (trovato) {
            punteggio++;
            System.out.println( [" + nome + "] Ha indovinato! (+1 punto)");
        } else {
            System.out.println( [" + nome + "] Non ha indovinato.");
        }
    }

    @Override
    public void run(){
        comunica();

        try {
            sleep(1000);
        } catch (InterruptedException e) {
            System.err.println("Errore nella fase di sleeping");
        }

        gioca();
    }
}
