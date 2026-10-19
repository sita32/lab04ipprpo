package com.autoservice.experimental;

import com.autoservice.model.RepairOrder;
import com.autoservice.repository.RepairRepository;

import java.util.HashMap;
import java.util.Map;

public class DatabaseRepairRepository implements RepairRepository {

    private final Map<String, RepairOrder> orders = new HashMap<>();

    @Override
    public void save(RepairOrder order) {
        orders.put(order.getId(), order);
    }

    @Override
    public RepairOrder findById(String id) {
        return orders.get(id);
    }
}
