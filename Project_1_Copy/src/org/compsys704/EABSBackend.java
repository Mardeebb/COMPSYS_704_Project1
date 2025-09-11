package org.compsys704;
import java.util.concurrent.*;

public class EABSBackend {
    BlockingQueue<Order> orderQueue = new LinkedBlockingQueue<>();

	public EABSBackend(){
	}
	
    // Add new order
    public void enqueueOrder(Order order) {
        orderQueue.add(order);
    }

    // Retrieve next order (blocking until available)
    public Order takeOrder() throws InterruptedException {
        return orderQueue.take();
    }

	public Order[] getOrders() {
		// TODO Auto-generated method stub
		return null;
	}

}