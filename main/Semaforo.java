public class Semaforo {
    private boolean livre = true;

    public synchronized void esperar() throws InterruptedException {
        while (!livre) {
            wait();
        }
        livre = false;
    }

    public synchronized void sinalizar() {
        livre = true;
        notify();
    }
}
