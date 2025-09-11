package org.compsys704;
import java.util.ArrayList;
import java.util.List;
import run.BottleTwin;

public class EABSBackend {
    private final List<Order> waitingOrders = new ArrayList<>();
    private final List<Order> completedOrders = new ArrayList<>();
    private Order processingOrder = null;

    public void enqueueOrder(Order order) {
        waitingOrders.add(order);
    }

    public List<Order> getWaitingOrders() {
        return waitingOrders;
    }

    public List<Order> getCompletedOrders() {
        return completedOrders;
    }

    public Order getProcessingOrder() {
        return processingOrder;
    }

    // Start next order if idle
    public void startNextOrder() {
        if (processingOrder == null && !waitingOrders.isEmpty()) {
            processingOrder = waitingOrders.remove(0);
        }
    }

    // Take the next bottle from the active order
    public BottleTwin takeBottle() {
        if (processingOrder == null) {
            startNextOrder();
            if (processingOrder == null) return null; // nothing available
        }

        BottleTwin next = processingOrder.getNextBottle();
        if (next == null) {
            // Order finished, move to completed
            completedOrders.add(processingOrder);
            processingOrder = null;
            // try next order
            return takeBottle();
        }
        return next;
    }
    
    public BottleTwin getBottleFromID(int ID) {
        // check current processing order
        if (processingOrder != null) {
            for (BottleTwin b : processingOrder.bottles) {
                if (b.ID == ID) {
                	return b;

                }
            }
        }

        // check waiting orders
        for (Order o : waitingOrders) {
            for (BottleTwin b : o.bottles) {

                if (b.ID == ID) {
                	return b;
                }
            }
        }

        // check completed orders
        for (Order o : completedOrders) {
            for (BottleTwin b : o.bottles) {

                if (b.ID == ID) {
                	return b;
                }
            }
        }

        return null; // not found
    }
    
    public int getGUIrep(int ID) {
    	BottleTwin bottle = getBottleFromID(ID);

    	if(bottle != null) {
    		return bottle.getGUIint();
    	}
    	return -1;
    }
}
