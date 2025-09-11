package org.compsys704;


class OrderDispatcher implements Runnable {
    private EABSBackend backend;

    public OrderDispatcher(EABSBackend backend) {
        this.backend = backend;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Order order = backend.takeOrder(); // blocks until order arrives
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
