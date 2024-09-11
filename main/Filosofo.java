public class Filosofo implements Runnable {
    private final String nome;
    private final Talher talherEsquerdo;
    private final Talher talherDireito;

    public Filosofo(String nome, Talher talherEsquerdo, Talher talherDireito) {
        this.nome = nome;
        this.talherEsquerdo = talherEsquerdo;
        this.talherDireito = talherDireito;
    }

    @Override
    public void run() {
        try {
            while (true) {
                pensar();
                pegarTalheres();
                comer();
                liberarTalheres();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private void pensar() throws InterruptedException {
        System.out.println(nome + " está pensando.");
        Thread.sleep((long) (Math.random() * 1000));
    }

    private void pegarTalheres() throws InterruptedException {
        if (nome.hashCode() % 2 == 0) {
            talherEsquerdo.pegar();
            System.out.println(nome + " pegou talher esquerdo.");
            talherDireito.pegar();
            System.out.println(nome + " pegou talher direito.");
        } else {
            talherDireito.pegar();
            System.out.println(nome + " pegou talher direito.");
            talherEsquerdo.pegar();
            System.out.println(nome + " pegou talher esquerdo.");
        }
    }

    private void comer() throws InterruptedException {
        System.out.println(nome + " está comendo.");
        Thread.sleep((long) (Math.random() * 1000));
    }

    private void liberarTalheres() {
        talherEsquerdo.liberar();
        talherDireito.liberar();
    }
}
