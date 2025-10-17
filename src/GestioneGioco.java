public class GestioneGioco {

    public void determinaVincitore(Giocatore g1, Giocatore g2) {
        System.out.println("\n=== RISULTATI FINALI ===");
        System.out.println(g1.nome + ": " + g1.punteggio + " punti");
        System.out.println(g2.nome + ": " + g2.punteggio + " punti");

        if (g1.punteggio > g2.punteggio) {
            System.out.println("Vince " + g1.nome + "!");
        } else if (g2.punteggio > g1.punteggio) {
            System.out.println(" Vince " + g2.nome + "!");
        } else {
            System.out.println(" Pareggio!");
        }
    }
}
