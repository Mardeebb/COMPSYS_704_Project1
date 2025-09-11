package org.compsys704;

import java.util.ArrayList;
import java.util.List;


class Order {
    String id;
    List<BottleTwin> bottles = new ArrayList<>();
    public Order(String id, int qty) {
        this.id = id;
        for (int i=0; i<qty; i++) {
            bottles.add(new BottleTwin(i, "name"));
        }
    }
    public long getCompletedCount() {
        return bottles.stream().filter(b -> b.status.equals("completed")).count();
    }
}
