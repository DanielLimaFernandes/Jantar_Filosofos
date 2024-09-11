public class Talher {
    private final Semaforo semaforo = new Semaforo();

    public void pegar() throws InterruptedException {
        semaforo.esperar();
    }

    public void liberar() {
        semaforo.sinalizar();
    }
}
