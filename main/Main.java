import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        final int NUM_FILOSOFOS = 5;
        List<Talher> talheres = new ArrayList<>();
        List<Thread> threads = new ArrayList<>();

        // Cria os talheres
        for (int i = 0; i < NUM_FILOSOFOS; i++) {
            talheres.add(new Talher());
        }

        // Nomes dos filósofos
        String[] nomes = { "Sócrates", "Platão", "Aristóteles", "Descartes", "Nietzsche" };

        // Cria os filósofos e suas threads
        for (int i = 0; i < NUM_FILOSOFOS; i++) {
            Talher talherEsquerdo = talheres.get(i);
            Talher talherDireito = talheres.get((i + 1) % NUM_FILOSOFOS);
            Filosofo filosofo = new Filosofo(nomes[i], talherEsquerdo, talherDireito);
            Thread thread = new Thread(filosofo);
            threads.add(thread);
            thread.start();
        }

        // Espera que todas as threads terminem
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

