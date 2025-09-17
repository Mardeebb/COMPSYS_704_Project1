package org.compsys704;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import run.BottleTwin;

public class Order {
    private static final AtomicInteger globalIdGenerator = new AtomicInteger(0);

    String id;
    List<BottleTwin> bottles = new ArrayList<>();
    int nextBottleIndex = 0; // pointer to track progress

    public Order(String id, int qty, int[] recipe, boolean isLarge) {
        this.id = id;
        for (int i = 0; i < qty; i++) {
            int uniqueId = globalIdGenerator.getAndIncrement(); // global unique ID
            bottles.add(new BottleTwin(uniqueId, "name", id, recipe, isLarge));
        }
    }

    public boolean isCompleted() {
        return nextBottleIndex >= bottles.size();
    }

    public BottleTwin getNextBottle() {
        if (isCompleted()) return null;
        return bottles.get(nextBottleIndex++);
    }

    // total number of bottles in this order
    public int getTotal() {
        return bottles.size();
    }
    

    // number of bottles that have status == "completed"
    public synchronized int getCompletedCount() {
        int cnt = 0;
        for (BottleTwin b : bottles) {
            if (b.isCompleted()) cnt++;
        }
        return cnt;
    }
}
